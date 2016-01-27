package org.aryalinux.modelbuilder.model;

public class DatabaseProperties {
	private String driverClassName;
	private String username;
	private String password;
	private String databaseUrl;

	public DatabaseProperties(String driver, String user, String pwd, String url) {
		driverClassName = driver;
		username = user;
		password = pwd;
		databaseUrl = url;
	}

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabaseUrl() {
		return databaseUrl;
	}

	public void setDatabaseUrl(String databaseUrl) {
		this.databaseUrl = databaseUrl;
	}

}
