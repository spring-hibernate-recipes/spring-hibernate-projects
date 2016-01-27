package org.aryalinux.modelbuilder.ui;

import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.aryalinux.modelbuilder.model.DatabaseProperties;

@SuppressWarnings("serial")
public class DBPropertiesPanel extends GenericPanel {
	private JTextField driverClassName;
	private JTextField username;
	private JPasswordField password;
	private JTextField databaseUrl;
	private JButton testConnection;

	public DBPropertiesPanel() {
		driverClassName = new JTextField("com.mysql.jdbc.Driver");
		username = new JTextField("root");
		password = new JPasswordField("password@123");
		databaseUrl = new JTextField(60);
		databaseUrl.setText("jdbc:mysql://localhost:3306/classicmodels");
		testConnection = new JButton("Test");

		addComponents();
	}

	private void addComponents() {
		gbc.fill = GridBagConstraints.BOTH;
		gbc.anchor = GridBagConstraints.WEST;

		add(new JLabel("Driver Class"), 0, 0, 2, 1);
		add(new JLabel("Username"), 0, 2, 2, 1);
		add(new JLabel("Password"), 0, 4, 2, 1);
		add(new JLabel("Database URL"), 0, 6, 2, 1);

		add(driverClassName, 0, 1, 2, 1);
		add(username, 0, 3, 2, 1);
		add(password, 0, 5, 2, 1);
		add(databaseUrl, 0, 7, 1, 1);

		gbc.fill = GridBagConstraints.NONE;

		add(testConnection, 1, 7, 1, 1);
	}

	public DatabaseProperties getDatabaseProperties() {
		DatabaseProperties databaseProperties = new DatabaseProperties(driverClassName.getText(), username.getText(),
				new String(password.getPassword()), databaseUrl.getText());
		return databaseProperties;
	}
}
