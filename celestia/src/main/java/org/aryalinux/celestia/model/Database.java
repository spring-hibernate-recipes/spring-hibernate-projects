package org.aryalinux.celestia.model;

public class Database extends BaseEntity {
	private String driverClassName;
	private String url;
	private String username;
	private String password;
	private String showSql;
	private String hbm2ddl;
	private String dialect;

	public String getDriverClassName() {
		return driverClassName;
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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

	public String getShowSql() {
		return showSql;
	}

	public void setShowSql(String showSql) {
		this.showSql = showSql;
	}

	public String getHbm2ddl() {
		return hbm2ddl;
	}

	public void setHbm2ddl(String hbm2ddl) {
		this.hbm2ddl = hbm2ddl;
	}

	public String getDialect() {
		return dialect;
	}

	public void setDialect(String dialect) {
		this.dialect = dialect;
	}

}