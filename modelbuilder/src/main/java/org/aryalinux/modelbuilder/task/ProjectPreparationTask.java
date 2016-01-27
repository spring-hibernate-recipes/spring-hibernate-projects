package org.aryalinux.modelbuilder.task;

import java.io.File;

import org.aryalinux.modelbuilder.model.DatabaseProperties;
import org.aryalinux.modelbuilder.model.ProjectProperties;
import org.aryalinux.modelbuilder.model.Task;
import org.aryalinux.modelbuilder.ui.MainFrame;

public class ProjectPreparationTask extends Task {
	private DatabaseProperties databaseProperties;

	public void setDatabaseProperties(DatabaseProperties databaseProperties) {
		this.databaseProperties = databaseProperties;
	}

	public ProjectPreparationTask() {
		super("Preparing project. Creating directories, adding dependencies and generating xmls.");
	}

	public void doTask() {
		try {
			ProjectProperties props = (ProjectProperties) getData();
			FileUtil.createDirectory(props.getLocation() + File.separator + props.getArtifactId() + File.separator
					+ "src" + File.separator + "main" + File.separator + "java" + File.separator
					+ props.getGroupId().replace(".", File.separator) + File.separator + "model");
			FileUtil.createDirectory(props.getLocation() + File.separator + props.getArtifactId() + File.separator
					+ "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
					+ File.separator + "pages");
			FileUtil.createDirectory(props.getLocation() + File.separator + props.getArtifactId() + File.separator
					+ "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
					+ File.separator + "resources");
			FileUtil.copyFile(
					MainFrame.settings.get("sample.project.location") + File.separator
							+ "/src/main/webapp/WEB-INF/dispatcher-servlet.xml",
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
							+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
							+ File.separator + "dispatcher-servlet.xml");
			FileUtil.copyFile(MainFrame.settings.get("sample.project.location") + "/src/main/webapp/WEB-INF/web.xml",
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
							+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
							+ File.separator + "web.xml");
			FileUtil.replaceInFile(
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
							+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
							+ File.separator + "dispatcher-servlet.xml",
					"org.aryalinux.classicmodels", props.getGroupId());
			FileUtil.replaceInFile(
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
							+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
							+ File.separator + "dispatcher-servlet.xml",
					"com.mysql.jdbc.Driver", databaseProperties.getDriverClassName());
			FileUtil.replaceInFile(props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
					+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF" + File.separator
					+ "dispatcher-servlet.xml", "root", databaseProperties.getUsername());
			FileUtil.replaceInFile(
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
							+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
							+ File.separator + "dispatcher-servlet.xml",
					"password@123", databaseProperties.getPassword());
			FileUtil.replaceInFile(
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
							+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
							+ File.separator + "dispatcher-servlet.xml",
					"jdbc:mysql://localhost:3306/classicmodels", databaseProperties.getDatabaseUrl());

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
