package org.aryalinux.modelbuilder.ui;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;

import org.aryalinux.modelbuilder.model.DatabaseProperties;

@SuppressWarnings("serial")
public class TablesPanel extends GenericPanel implements ActionListener {
	private DatabaseProperties databaseProperties;
	private JList<String> tables;
	private DefaultListModel<String> model;
	private ButtonPanel buttonPanel;

	public TablesPanel() {
		model = new DefaultListModel<String>();
		tables = new JList<String>(model);

		gbc.weightx = 1.0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weighty = 1.0;
		add(new JScrollPane(tables), 0, 0, 1, 1);
		gbc.weighty = 0;
		add(buttonPanel = new ButtonPanel(), 0, 1, 1, 1);
		gbc.fill = GridBagConstraints.NONE;
		buttonPanel.addButton("Remove", this);
	}

	public DatabaseProperties getDatabaseProperties() {
		return databaseProperties;
	}

	public void setDatabaseProperties(DatabaseProperties databaseProperties) {
		this.databaseProperties = databaseProperties;
		model.clear();
		try {
			Class.forName(databaseProperties.getDriverClassName());
			Connection con = DriverManager.getConnection(databaseProperties.getDatabaseUrl(),
					databaseProperties.getUsername(), databaseProperties.getPassword());
			DatabaseMetaData databaseMetaData = con.getMetaData();
			ResultSet resultSet = databaseMetaData.getTables(null, null, null, null);
			while (resultSet.next()) {
				String schemaName = resultSet.getString("TABLE_SCHEM");
				String tableName = resultSet.getString("TABLE_NAME");
				if (schemaName != null) {
					model.addElement(schemaName + "." + tableName);
				} else {
					model.addElement(tableName);
				}
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Remove")) {
			int selectionIndex = tables.getSelectedIndex();
			if (selectionIndex >= 0 && selectionIndex < model.size()) {
				model.remove(selectionIndex);
			}
		}
	}

	public List<String> getTables() {
		List<String> tables = new ArrayList<String>();
		for (int i = 0; i < model.size(); i++) {
			tables.add(model.getElementAt(i));
		}
		return tables;
	}

}
