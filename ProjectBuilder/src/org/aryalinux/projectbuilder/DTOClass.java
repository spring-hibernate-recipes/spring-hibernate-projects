package org.aryalinux.projectbuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class DTOClass {
	private ModelClass modelClass;
	private List<String> packages;

	public DTOClass(ModelClass class1) {
		this.modelClass = class1;
		packages = new ArrayList<>();
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("public class " + modelClass.getName() + "DTO {\n");
		for (Property property : modelClass.getProperties()) {
			builder.append("\tprivate " + property.getJavaDataType() + " " + property.getName() + ";\n");
		}
		for (Entry<String, String> reference : modelClass.getReferences().entrySet()) {
			String className = reference.getValue();
			String propertyName = reference.getKey();
			String pkName = Globals.getPKName(className);
			String pkType = Globals.getPKType(className);
			String propName = Character.toLowerCase(propertyName.charAt(0)) + propertyName.substring(1) + "_" + pkName;
			builder.append("\tprivate " + pkType + " " + propName + ";");
		}
		for (Entry<String, String> aggregate : modelClass.getAggregates().entrySet()) {
			builder.append("\tprivate List<" + aggregate.getValue() + "DTO> " + aggregate.getKey() + ";\n");
			packages.add("java.util.List");
		}
		for (Property property : modelClass.getProperties()) {
			String name = property.getName();
			builder.append("\tpublic void set" + Character.toUpperCase(name.charAt(0)) + name.substring(1) + "("
					+ property.getJavaDataType() + " " + name + ") {\n");
			builder.append("\t\tthis." + name + " = " + name + ";\n");
			builder.append("\t}\n");
			builder.append("\tpublic " + property.getJavaDataType() + " get" + Character.toUpperCase(name.charAt(0))
					+ name.substring(1) + "() {\n");
			builder.append("\t\treturn this." + name + ";\n");
			builder.append("\t}\n");
		}
		for (Entry<String, String> reference : modelClass.getReferences().entrySet()) {
			String className = reference.getValue();
			String propertyName = reference.getKey();
			String pkName = Globals.getPKName(className);
			String pkType = Globals.getPKType(className);
			String propName = Character.toLowerCase(propertyName.charAt(0)) + propertyName.substring(1) + "_" + pkName;
			builder.append("\tpublic void set" + Character.toUpperCase(propName.charAt(0)) + propName.substring(1) + "("
					+ pkType + " val) {\n");
			builder.append("\t\tthis." + propName + " = val;\n");
			builder.append("\t}\n");
			builder.append("\tpublic " + pkType + " get" + Character.toUpperCase(propName.charAt(0)) + propName.substring(1) + "() {\n");
			builder.append("\t\treturn this." + propName + ";\n");
			builder.append("\t}\n");
		}
		for (Entry<String, String> aggregate : modelClass.getAggregates().entrySet()) {
			String name = aggregate.getKey();
			builder.append("\tpublic void set" + Character.toUpperCase(name.charAt(0)) + name.substring(1) + "("
					+ "List<" + aggregate.getValue() + "DTO> " + name + ") {\n");
			builder.append("\t\tthis." + name + " = " + name + ";\n");
			builder.append("\t}\n");
			builder.append("\tpublic List<" + aggregate.getValue() + "DTO> get" + Character.toUpperCase(name.charAt(0))
					+ name.substring(1) + "() {\n");
			builder.append("\t\treturn this." + name + ";\n");
			builder.append("\t}\n");
		}
		builder.append("}");
		StringBuilder packageBuilder = new StringBuilder();
		for (String str : packages) {
			packageBuilder.append("import " + str + ";\n");
		}
		return packageBuilder.toString() + "\n" + builder.toString();
	}
}
