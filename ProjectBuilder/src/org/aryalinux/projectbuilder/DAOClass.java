package org.aryalinux.projectbuilder;

import java.util.ArrayList;
import java.util.List;

public class DAOClass {
	private ModelClass modelClass;
	private List<String> packages;

	public DAOClass() {
		packages = new ArrayList<>();
	}

	public DAOClass(ModelClass modelClass) {
		this.modelClass = modelClass;
	}

	public ModelClass getModelClass() {
		return modelClass;
	}

	public void setModelClass(ModelClass modelClass) {
		this.modelClass = modelClass;
	}

	public List<String> getPackages() {
		return packages;
	}

	public void setPackages(List<String> packages) {
		this.packages = packages;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		String primaryKeyClass = null;
		for (Property property : modelClass.getProperties()) {
			if (property.isPrimaryKey()) {
				primaryKeyClass = property.getJavaDataType();
			}
		}
		builder.append("@Component\n");
		packages.add("org.springframework.stereotype.Component");
		builder.append("public class " + modelClass.getName() + "DAO extends GenericDAO<" + modelClass.getName() + ", "
				+ primaryKeyClass + ">{\n");
		builder.append("\tpublic " + modelClass.getName() + "DAO() {\n");
		builder.append("\t\tthis.clazz = " + modelClass.getName() + ".class;\n");
		builder.append("\t}");
		builder.append("}");
		return builder.toString();
	}
}
