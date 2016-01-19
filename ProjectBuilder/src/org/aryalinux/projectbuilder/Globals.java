package org.aryalinux.projectbuilder;

public class Globals {
	public static ProjectDatabase database;
	public static String presentProject;

	public static ModelClass getByName(String name) {
		for (ModelClass class1 : database.projects.get(presentProject).getModelClasses()) {
			if (class1.getName().equals(name)) {
				return class1;
			}
		}
		return null;
	}

	public static String getPKName(String name) {
		String pkName = null;
		for (ModelClass class1 : database.projects.get(presentProject).getModelClasses()) {
			if (class1.getName().equals(name)) {
				for (Property property : class1.getProperties()) {
					if (property.isPrimaryKey()) {
						pkName = property.getName();
					}
				}
			}
		}
		return pkName;
	}

	public static String getPKType(String name) {
		String pkType = null;
		for (ModelClass class1 : database.projects.get(presentProject).getModelClasses()) {
			if (class1.getName().equals(name)) {
				for (Property property : class1.getProperties()) {
					if (property.isPrimaryKey()) {
						pkType = property.getJavaDataType();
					}
				}
			}
		}
		return pkType;
	}
}
