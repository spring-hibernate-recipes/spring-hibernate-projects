package org.aryalinux.modelbuilder.task;

import java.io.File;

import org.aryalinux.modelbuilder.model.ProjectProperties;
import org.aryalinux.modelbuilder.model.Task;

public class ProjectPreparationTask extends Task {
	public ProjectPreparationTask() {
		super("Preparing project. Creating directories, adding dependencies and generating xmls.");
	}

	public void doTask() {
		try {
			ProjectProperties props = (ProjectProperties) getData();
			FileUtil.createDirectory(props.getLocation() + File.separator + props.getArtifactId() + File.separator
					+ "src" + File.separator + "main" + File.separator + "java" + File.separator
					+ props.getGroupId().replace(".", File.separator) + File.separator + props.getArtifactId()
					+ File.separator + "model");
			FileUtil.createDirectory(props.getLocation() + File.separator + props.getArtifactId() + File.separator
					+ "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
					+ File.separator + "pages");
			FileUtil.createDirectory(props.getLocation() + File.separator + props.getArtifactId() + File.separator
					+ "src" + File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
					+ File.separator + "resources");
			FileUtil.copyFile("D:\\workspace\\classicmodels\\src\\main\\webapp\\WEB-INF\\dispatcher-servlet.xml",
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
							+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
							+ File.separator + "dispatcher-servlet.xml");
			FileUtil.copyFile("D:\\workspace\\classicmodels\\src\\main\\webapp\\WEB-INF\\web.xml",
					props.getLocation() + File.separator + props.getArtifactId() + File.separator + "src"
							+ File.separator + "main" + File.separator + "webapp" + File.separator + "WEB-INF"
							+ File.separator + "web.xml");
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
