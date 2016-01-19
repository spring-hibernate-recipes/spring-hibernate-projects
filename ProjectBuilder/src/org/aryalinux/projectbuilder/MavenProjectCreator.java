package org.aryalinux.projectbuilder;

public class MavenProjectCreator {
	private String groupId;
	private String artifactId;
	private String archetypeArtifactId;

	public MavenProjectCreator() {
		this(null, null, null);
	}

	public MavenProjectCreator(String groupId, String artifactId) {
		this(groupId, artifactId, null);
	}

	public MavenProjectCreator(String groupId, String artifactId, String archetypeArtifactId) {
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.archetypeArtifactId = archetypeArtifactId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getArchetypeArtifactId() {
		return archetypeArtifactId;
	}

	public void setArchetypeArtifactId(String archetypeArtifactId) {
		this.archetypeArtifactId = archetypeArtifactId;
	}

	public void execute() {
		try {
			Runtime runtime = Runtime.getRuntime();
			runtime.exec("mvn -B -DgroupId=" + groupId + " -DartifactId" + artifactId + " -DarchetypeArtifactId="
					+ archetypeArtifactId);
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}
}
