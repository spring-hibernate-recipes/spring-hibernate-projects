package org.aryalinux.eshoppe.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataUtil {
	private List<Character> alphaNumbers = new ArrayList<Character>();
	private List<Character> numbers = new ArrayList<Character>();
	private List<Character> alphabets = new ArrayList<Character>();
	private static Connection con;
	private Random random;

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/eshoppe", "root", "password@123");
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public DataUtil() {
		random = new Random(System.currentTimeMillis());
		try {
			for (char c = 'a'; c < 'z'; c++) {
				alphaNumbers.add(c);
				alphabets.add(c);
			}
			for (char c = '1'; c < '9'; c++) {
				alphaNumbers.add(c);
				numbers.add(c);
			}
			alphaNumbers.add('0');
			numbers.add('0');
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public String getString(int min, int max) {
		int len = random.nextInt(max - min) + min;
		String str = "";
		for (int i = 0; i < len; i++) {
			str = str + alphabets.get(random.nextInt(alphabets.size()));
		}
		return str;
	}

	public String getNumber(int digits) {
		int len = random.nextInt(digits);
		String str = "";
		for (int i = 0; i < len; i++) {
			str = str + numbers.get(random.nextInt(numbers.size()));
		}
		return str;
	}

	public String camel(String str) {
		return Character.toUpperCase(str.charAt(0)) + str.substring(1);
	}

	public String getName() {
		return camel(getString(5, 15)) + " " + camel(getString(10, 15));
	}

	public String getEmail() {
		return getString(5, 10) + getNumber(2) + "@" + getString(3, 5) + ".com";
	}

	public String getPhoneNumber() {
		String str = getNumber(10);
		if (str.startsWith("0")) {
			return '9' + str.substring(1);
		} else {
			return str;
		}
	}

	public Integer getRandomId(String tableName, String columnName) {
		try {
			Statement stat = con.createStatement();
			ResultSet res = stat.executeQuery("select " + columnName + " from " + tableName);
			List<Integer> ids = new ArrayList<Integer>();
			while (res.next()) {
				ids.add(res.getInt(1));
			}
			stat.close();
			res.close();
			if (ids.size() > 0) {
				return ids.get(random.nextInt(ids.size()));
			} else {
				return 0;
			}
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}

	}

	public String getLine() {
		String line = "";
		int words = random.nextInt(1000) + 20;
		for (int i = 0; i < words; i++) {
			if (line.length() > 250) {
				line = line.substring(0, 250);
				break;
			}
			line = line + getString(2, 10) + " ";
		}
		return line;
	}

	public String getAddress() {
		String doorNumber = getNumber(3);
		String cross = getNumber(2) + "th Cross";
		String main = getNumber(2) + "th Main";
		String city = camel(getString(10, 15));
		String state = camel(getString(15, 20));
		String zip = getNumber(6);
		return doorNumber + ", " + cross + ", " + main + ", " + city + ", " + state + ", Pin Code: " + zip;
	}

}
