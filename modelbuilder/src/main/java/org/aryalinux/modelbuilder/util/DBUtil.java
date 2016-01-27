package org.aryalinux.modelbuilder.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

import org.aryalinux.modelbuilder.model.DatabaseProperties;
import org.aryalinux.modelbuilder.model.TableProperties;

public class DBUtil {
	public static TableProperties getTableProperties(DatabaseProperties databaseProperties, String tableName) {
		TableProperties properties = new TableProperties();
		try {
			Class.forName(databaseProperties.getDriverClassName());
			Connection con = DriverManager.getConnection(databaseProperties.getDatabaseUrl(),
					databaseProperties.getUsername(), databaseProperties.getPassword());
			DatabaseMetaData databaseMetaData = con.getMetaData();
			ResultSet resultSet = databaseMetaData.getTables(null, null, tableName, null);
			while (resultSet.next()) {
				
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
		return properties;
	}
}
