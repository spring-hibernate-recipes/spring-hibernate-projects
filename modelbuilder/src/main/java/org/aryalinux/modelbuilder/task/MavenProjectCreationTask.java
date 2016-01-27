package org.aryalinux.modelbuilder.task;

import java.io.File;

import org.aryalinux.modelbuilder.model.ProjectProperties;
import org.aryalinux.modelbuilder.model.Task;

public class MavenProjectCreationTask extends Task {
	public MavenProjectCreationTask() {
		super("Creating Maven Project");
	}

	public void doTask() {
		ProjectProperties projectProperties = (ProjectProperties) getData();
		String mavenPath = "D:\\apache-maven-3.3.9\\bin\\";
		String command = mavenPath + "mvn.cmd -B archetype:generate -DgroupId=GROUPID -DartifactId=ARTIFACTID -DarchetypeArtifactId=maven-archetype-webapp";
		command = command.replace("GROUPID", projectProperties.getGroupId());
		command = command.replace("ARTIFACTID", projectProperties.getArtifactId());
		try {
			Process p = Runtime.getRuntime().exec(command, null, new File(projectProperties.getLocation()));
			p.waitFor();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
