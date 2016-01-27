package org.aryalinux.modelbuilder.task;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.aryalinux.modelbuilder.model.ProjectProperties;
import org.aryalinux.modelbuilder.model.Task;
import org.aryalinux.modelbuilder.ui.MainFrame;

public class CopyPOMTask extends Task {

	public CopyPOMTask() {
		super("Copying POM file.");
	}

	public void doTask() {
		try {
			ProjectProperties props = (ProjectProperties) getData();
			FileInputStream fileInputStream = new FileInputStream(
					MainFrame.settings.get("sample.project.location") + File.separator + "pom.xml");
			byte[] data = new byte[fileInputStream.available()];
			fileInputStream.read(data);
			String contents = new String(data);
			contents = contents.replace("<groupId>org.aryalinux.classicmodels</groupId>",
					"<groupId>" + props.getGroupId() + "</groupId>");
			contents = contents.replace("<artifactId>classicmodels</artifactId>",
					"<artifactId>" + props.getArtifactId() + "</artifactId>");
			contents = contents.replace("<name>classicmodels Maven Webapp</name>",
					"<name>" + props.getArtifactId() + " Maven Webapp</name>");
			contents = contents.replace("<finalName>classicmodels</finalName>",
					"<finalName>" + props.getArtifactId() + "</finalName>");
			FileOutputStream fileOutputStream = new FileOutputStream(
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "pom.xml");
			fileOutputStream.write(contents.getBytes());
			fileInputStream.close();
			fileOutputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
