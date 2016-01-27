package org.aryalinux.modelbuilder.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileUtil {
	public static final void copyFile(String src, String dest) {
		try {
			FileInputStream fileInputStream = new FileInputStream(src);
			byte[] data = new byte[fileInputStream.available()];
			fileInputStream.read(data);

			FileOutputStream fileOutputStream = new FileOutputStream(dest);
			fileOutputStream.write(data);
			fileInputStream.close();
			fileOutputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final void createDirectory(String dirName) {
		new File(dirName).mkdirs();
	}

	public static final void replaceInFile(String filename, String textToFind, String textToReplace) {
		try {
			FileInputStream fileInputStream = new FileInputStream(filename);
			byte[] data = new byte[fileInputStream.available()];
			fileInputStream.read(data);
			fileInputStream.close();

			String str = new String(data);

			str = str.replace(textToFind, textToReplace);

			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			fileOutputStream.write(str.getBytes());
			fileOutputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static final void writeFile(String filename, String data) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(filename);
			fileOutputStream.write(data.getBytes());
			fileOutputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
