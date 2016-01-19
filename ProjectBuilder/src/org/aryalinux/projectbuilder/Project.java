package org.aryalinux.projectbuilder;

import java.util.ArrayList;
import java.util.List;

public class Project {
	private String artifactId;
	private String groupId;
	private List<ModelClass> modelClasses;
	private List<DAOClass> daoClasses;
	private List<ServiceInterfaceAndClass> serviceInterfaceAndClasses;

	public Project() {
		modelClasses = new ArrayList<>();
		daoClasses = new ArrayList<>();
		serviceInterfaceAndClasses = new ArrayList<>();
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<ModelClass> getModelClasses() {
		return modelClasses;
	}

	public void setModelClasses(List<ModelClass> modelClasses) {
		this.modelClasses = modelClasses;
	}

	public List<DAOClass> getDaoClasses() {
		return daoClasses;
	}

	public void setDaoClasses(List<DAOClass> daoClasses) {
		this.daoClasses = daoClasses;
	}

	public List<ServiceInterfaceAndClass> getServiceInterfaceAndClasses() {
		return serviceInterfaceAndClasses;
	}

	public void setServiceInterfaceAndClasses(List<ServiceInterfaceAndClass> serviceInterfaceAndClasses) {
		this.serviceInterfaceAndClasses = serviceInterfaceAndClasses;
	}

	public void addModelClass(ModelClass class1) {
		this.modelClasses.add(class1);
		this.daoClasses.add(new DAOClass(class1));
		this.serviceInterfaceAndClasses.add(new ServiceInterfaceAndClass(class1));
	}
}
