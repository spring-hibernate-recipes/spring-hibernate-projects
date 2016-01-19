package org.aryalinux.projectbuilder;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

public class MainClass {
	public static final String projectDatabase = "d:\\projectDatabase.dat";

	public static void initDatabase() throws Exception {
		File file = new File(projectDatabase);
		if (file.exists()) {
			ProjectDatabase database = null;
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
			database = (ProjectDatabase) in.readObject();
			Globals.database = database;
			in.close();
		} else {
			ProjectDatabase database = new ProjectDatabase();
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
			out.writeObject(database);
			Globals.database = database;
			out.close();
		}
	}

	public static void main(String[] args) throws Exception {
		initDatabase();
		JFrame test = new JFrame("Celestia");
		test.setVisible(true);
		PropertyDialog dialog = new PropertyDialog(test);
		if (dialog.getProperty() == null) {
			System.out.println("NULL");
		} else {
			System.out.println(dialog.getProperty().getName());
		}
	}
}
