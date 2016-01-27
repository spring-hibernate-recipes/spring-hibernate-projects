package org.aryalinux.modelbuilder.ui;

import java.awt.GridBagConstraints;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.aryalinux.modelbuilder.model.ColumnProperties;
import org.aryalinux.modelbuilder.model.DatabaseProperties;
import org.aryalinux.modelbuilder.model.TableProperties;

@SuppressWarnings("serial")
public class TablePropertiesPanel extends GenericPanel implements ItemListener {
	private DatabaseProperties databaseProperties;
	private List<String> tables;
	private List<TableProperties> tableProperties;
	private JComboBox<String> tableNames;
	private DefaultTableModel defaultTableModel;
	private JTable tableDetails;

	public TablePropertiesPanel() {
		tableNames = new JComboBox<String>();
		defaultTableModel = new DefaultTableModel();
		tableDetails = new JTable(defaultTableModel);

		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.weightx = 1.0;
		add(tableNames, 0, 0, 1, 1);
		gbc.weighty = 1.0;
		add(new JScrollPane(tableDetails), 0, 1, 1, 1);

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
}
