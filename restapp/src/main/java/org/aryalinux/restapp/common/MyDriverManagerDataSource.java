package org.aryalinux.restapp.common;

import org.apache.commons.codec.binary.Base64;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

class MyDriverManagerDataSource extends DriverManagerDataSource {
	private String decode(String encryptedPassword) {
		byte[] decodedBytes = Base64.decodeBase64(encryptedPassword.getBytes());
		return new String(decodedBytes);
	}

	public void setPassword(String password) {
		super.setPassword(decode(password));
	}
}
