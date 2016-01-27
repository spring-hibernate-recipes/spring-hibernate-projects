package org.aryalinux.modelbuilder.ui;

import java.awt.GridBagConstraints;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTextField;

import org.aryalinux.modelbuilder.model.DatabaseProperties;
import org.aryalinux.modelbuilder.model.ProjectProperties;
import org.aryalinux.modelbuilder.model.TableProperties;

@SuppressWarnings("serial")
public class ProjectPropertiesPanel extends GenericPanel {
	private JTextField groupId;
	private JTextField artifactId;
	private FileControl projectPath;

	private DatabaseProperties databaseProperties;
	private List<TableProperties> tableProperties;
	private ProjectProperties projectProperties;

	public ProjectPropertiesPanel() {
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.WEST;

		groupId = new JTextField(50);
		artifactId = new JTextField(50);
		projectPath = new FileControl(this);
		projectPath.setDirectoriesOnly(true);

		add(new JLabel("Group ID"), 0, 0, 1, 1);
		add(new JLabel("Artifact ID"), 0, 2, 1, 1);
		add(new JLabel("Project Location"), 0, 4, 1, 1);

		add(groupId, 0, 1, 1, 1);
		add(artifactId, 0, 3, 1, 1);
		add(projectPath, 0, 5, 1, 1);
	}

	public DatabaseProperties getDatabaseProperties() {
		return databaseProperties;
	}

	public void setDatabaseProperties(DatabaseProperties databaseProperties) {
		this.databaseProperties = databaseProperties;
	}

	public List<TableProperties> getTableProperties() {
		return tableProperties;
	}

	public void setTableProperties(List<TableProperties> tableProperties) {
		this.tableProperties = tableProperties;
	}

	public ProjectProperties getProjectProperties() {
		projectProperties = new ProjectProperties();
		projectProperties.setGroupId(groupId.getText());
		projectProperties.setArtifactId(artifactId.getText());
		projectProperties.setLocation(projectPath.getPath());
		return projectProperties;
	}

	public void setProjectProperties(ProjectProperties projectProperties) {
		this.projectProperties = projectProperties;
	}

}
