package org.aryalinux.modelbuilder.ui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.aryalinux.modelbuilder.model.ColumnProperties;
import org.aryalinux.modelbuilder.model.DatabaseProperties;
import org.aryalinux.modelbuilder.model.TableProperties;

@SuppressWarnings("serial")
public class TablePropertiesPanel extends GenericPanel implements ItemListener, ActionListener {
	private DatabaseProperties databaseProperties;
	private List<String> tables;
	private List<TableProperties> tableProperties;
	private JComboBox<String> tableNames;
	private JTextField modelClassName;
	private JTextField restResourceName;
	private DefaultTableModel defaultTableModel;
	private JTable tableDetails;
	private ButtonPanel buttonPanel;

	public TablePropertiesPanel() {
		tableNames = new JComboBox<String>();
		defaultTableModel = new DefaultTableModel();
		tableDetails = new JTable(defaultTableModel);
		modelClassName = new JTextField();
		restResourceName = new JTextField();
		buttonPanel = new ButtonPanel();
		buttonPanel.addButton("Update", this);

		gbc.anchor = GridBagConstraints.EAST;

		add(new JLabel("Entity Class"), 0, 1, 1, 1);
		add(new JLabel("Rest Resource"), 0, 2, 1, 1);

		gbc.fill = GridBagConstraints.BOTH;
		add(buttonPanel, 1, 4, 1, 1);

		gbc.weightx = 1.0;
		add(tableNames, 0, 0, 2, 1);
		add(modelClassName, 1, 1, 1, 1);
		add(restResourceName, 1, 2, 1, 1);

		gbc.weighty = 1.0;
		add(new JScrollPane(tableDetails), 0, 3, 2, 1);

		tableNames.addItemListener(this);
	}

	public void setDatabaseProperties(DatabaseProperties databaseProperties) {
		this.databaseProperties = databaseProperties;
	}

	public DatabaseProperties getDatabaseProperties() {
		return databaseProperties;
	}

	public void setTables(List<String> tables) {
		this.tables = tables;
		try {
			Class.forName(databaseProperties.getDriverClassName());
			Connection con = DriverManager.getConnection(databaseProperties.getDatabaseUrl(),
					databaseProperties.getUsername(), databaseProperties.getPassword());
			DatabaseMetaData databaseMetaData = con.getMetaData();
			tableProperties = new ArrayList<TableProperties>();
			for (String table : tables) {
				TableProperties properties = new TableProperties();
				properties.setName(table);
				properties.setEntityClassName(suggestModelClassName(table));
				properties.setRestResource(suggestRestResourceName(table));
				tableProperties.add(properties);
				properties.setColumnProperties(new ArrayList<ColumnProperties>());
				String primaryKeyColumnName = null;
				ResultSet pkResultSet = databaseMetaData.getPrimaryKeys(null, null, table);
				while (pkResultSet.next()) {
					primaryKeyColumnName = pkResultSet.getString("COLUMN_NAME");
				}
				ResultSet resultSet = databaseMetaData.getColumns(null, null, table, null);
				while (resultSet.next()) {
					ColumnProperties columnProperties = new ColumnProperties();
					columnProperties.setName(resultSet.getString("COLUMN_NAME"));
					columnProperties.setDataType(resultSet.getString("TYPE_NAME"));
					columnProperties.setJavaType(resultSet.getString("DATA_TYPE"));
					columnProperties.setJoinColumn(false);
					if (columnProperties.getName().equals(primaryKeyColumnName)) {
						columnProperties.setPrimary(true);
					}
					columnProperties.setLength(resultSet.getInt("COLUMN_SIZE"));
					properties.getColumnProperties().add(columnProperties);
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		updateTheUI();
	}

	public List<String> getTables() {
		return tables;
	}

	public List<TableProperties> getTableProperties() {
		return tableProperties;
	}

	public void setTableProperties(List<TableProperties> tableProperties) {
		this.tableProperties = tableProperties;
	}

	private void updateTheUI() {
		tableNames.removeAllItems();
		for (String table : tables) {
			tableNames.addItem(table);
		}
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Data Type");
		defaultTableModel.addColumn("Java Type");
		defaultTableModel.addColumn("Length");
		defaultTableModel.addColumn("Primary Key?");
		defaultTableModel.addColumn("Join Column?");
		defaultTableModel.addColumn("Join Type");

		populateCurrentTableDetails();
	}

	private void populateCurrentTableDetails() {
		if (tableNames.getSelectedIndex() != -1) {
			String currentTable = tableNames.getItemAt(tableNames.getSelectedIndex());
			if (currentTable != null) {
				int count = defaultTableModel.getRowCount();
				for (int i = 0; i < count; i++) {
					defaultTableModel.removeRow(0);
				}
				for (TableProperties properties : tableProperties) {
					if (properties.getName().equals(currentTable)) {
						restResourceName.setText(properties.getRestResource());
						modelClassName.setText(properties.getEntityClassName());
						for (ColumnProperties columnProperties : properties.getColumnProperties()) {
							Object[] row = new Object[] { columnProperties.getName(), columnProperties.getDataType(),
									columnProperties.getJavaType(), columnProperties.getLength(),
									columnProperties.isPrimary(), columnProperties.isJoinColumn(),
									columnProperties.getJoinType() };
							defaultTableModel.addRow(row);
						}
					}
				}

			}
		}
	}

	public void itemStateChanged(ItemEvent e) {
		populateCurrentTableDetails();
	}

	@SuppressWarnings("rawtypes")
	public void actionPerformed(ActionEvent e) {
		int index = this.tableNames.getSelectedIndex();
		if (index != -1) {
			String selection = tableNames.getItemAt(index);
			for (TableProperties properties : this.tableProperties) {
				if (properties.getName().equals(selection)) {
					properties.setEntityClassName(modelClassName.getText());
					properties.setRestResource(restResourceName.getText());

					List<ColumnProperties> columnProperties = new ArrayList<ColumnProperties>();

					Vector dataVector = defaultTableModel.getDataVector();

					for (Object ref : dataVector) {
						Vector row = (Vector) ref;
						ColumnProperties columnPropertiesObj = new ColumnProperties();
						columnProperties.add(columnPropertiesObj);

						columnPropertiesObj.setName(row.get(0).toString());
						columnPropertiesObj.setDataType(row.get(1).toString());
						String javaType = row.get(2).toString();
						System.out.println(javaType);
						columnPropertiesObj.setJavaType(javaType);
						columnPropertiesObj.setLength(Integer.parseInt(row.get(3).toString()));
						columnPropertiesObj.setPrimary(Boolean.parseBoolean(row.get(4).toString()));
						columnPropertiesObj.setJoinColumn(Boolean.parseBoolean(row.get(5).toString()));
						columnPropertiesObj.setJoinType(Integer.parseInt(row.get(6).toString()));
					}
					properties.setColumnProperties(columnProperties);
				}
			}
		}
	}

	private String suggestModelClassName(String table) {
		String modelClassName = "";
		StringTokenizer st = new StringTokenizer(table, "_");
		while (st.hasMoreTokens()) {
			String part = st.nextToken();
			modelClassName += (Character.toUpperCase(part.charAt(0)) + part.substring(1));
		}
		if (modelClassName.endsWith("ies")) {
			modelClassName = modelClassName.substring(0, modelClassName.length() - 3) + "y";
		} else if (modelClassName.endsWith("s")) {
			modelClassName = modelClassName.substring(0, modelClassName.length() - 1);
		}
		return modelClassName;
	}

	private String suggestRestResourceName(String table) {
		String restResourceName = "";
		StringTokenizer st = new StringTokenizer(table, "_");
		while (st.hasMoreTokens()) {
			String part = st.nextToken();
			restResourceName += part.toLowerCase();
		}
		if (restResourceName.endsWith("ies")) {
			restResourceName = restResourceName.substring(0, restResourceName.length() - 3) + "y";
		} else if (restResourceName.endsWith("s")) {
			restResourceName = restResourceName.substring(0, restResourceName.length() - 1);
		}
		return restResourceName;
	}
}
