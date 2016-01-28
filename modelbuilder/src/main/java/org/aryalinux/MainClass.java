package org.aryalinux;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;

import org.aryalinux.modelbuilder.task.FileUtil;
import org.aryalinux.modelbuilder.ui.MainFrame;
import org.aryalinux.modelbuilder.ui.SettingsDialog;

public class MainClass {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		new MainFrame();
		if (!new File(System.getProperty("user.home") + File.separator + ".modelbuilder").exists()) {
			File settingsDir = new File(System.getProperty("user.home") + File.separator + ".modelbuilder");
			settingsDir.mkdirs();
			FileOutputStream fileOutputStream = new FileOutputStream(
					settingsDir.getAbsolutePath() + File.separator + "settings.dat");
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			SettingsDialog settingsDialog = new SettingsDialog(MainFrame.mainFrame);
			settingsDialog.showDialog();
			Map<String, String> settings = settingsDialog.getSettings();
			objectOutputStream.writeObject(settings);
			objectOutputStream.close();
			fileOutputStream.close();
			MainFrame.settings = settings;
			FileUtil.copyRecursive(settings.get("sample.project.location"), settingsDir.getAbsolutePath());
			settings.put("sample.project.location", settingsDir.getAbsolutePath() + File.separator
					+ new File(settings.get("sample.project.location")).getName());
		} else {
			File settingsDir = new File(System.getProperty("user.home") + File.separator + ".modelbuilder");
			ObjectInputStream inputStream = new ObjectInputStream(
					new FileInputStream(settingsDir.getAbsolutePath() + File.separator + "settings.dat"));
			MainFrame.settings = (Map<String, String>) inputStream.readObject();
			inputStream.close();
		}
	}
}
