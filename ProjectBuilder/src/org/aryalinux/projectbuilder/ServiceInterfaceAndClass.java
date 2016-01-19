package org.aryalinux.projectbuilder;

public class ServiceInterfaceAndClass {
	private ModelClass modelClass;

	public ServiceInterfaceAndClass(ModelClass class1) {
		this.modelClass = class1;
	}

	public ModelClass getModelClass() {
		return modelClass;
	}

	public void setModelClass(ModelClass modelClass) {
		this.modelClass = modelClass;
	}

	public String toInterfaceString() {
		StringBuilder builder = new StringBuilder();
		builder.append("import java.util.Map;\n");
		builder.append("public interface " + modelClass.getName() + "Service {");
		builder.append("\tBaseResponse createNew" + modelClass.getName() + "(" + modelClass.getName() + "DTO dto);\n");
		builder.append("\tBaseResponse getById" + modelClass.getName() + "(" + Globals.getPKType(modelClass.getName())
				+ " id);\n");
		builder.append("\tBaseResponse getByParams" + modelClass.getName() + "(Map<String, Object> params);\n");
		builder.append("\tBaseResponse getAll" + modelClass.getName() + "();\n");
		builder.append("\tBaseResponse update" + modelClass.getName() + "(" + modelClass.getName() + "DTO dto);\n");
		builder.append("\tBaseResponse delete" + modelClass.getName() + "(" + Globals.getPKType(modelClass.getName())
				+ " id);\n");
		builder.append("}");
		return builder.toString();
	}
}
