package org.aryalinux.modelbuilder.task;

import java.io.File;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.aryalinux.modelbuilder.model.ColumnProperties;
import org.aryalinux.modelbuilder.model.ProjectProperties;
import org.aryalinux.modelbuilder.model.TableProperties;
import org.aryalinux.modelbuilder.model.Task;

@SuppressWarnings("unchecked")
public class ModelClassGenerationTask extends Task {
	private ProjectProperties projectProperties;

	public ModelClassGenerationTask() {
		super("Generating Model Classes");
	}

	public void setProjectProperties(ProjectProperties projectProperties) {
		this.projectProperties = projectProperties;
	}

	@Override
	public void doTask() {
		List<TableProperties> props = (List<TableProperties>) getData();
		String packageName = projectProperties.getGroupId() + ".model";
		String dirName = FileUtil.path(projectProperties.getLocation(), projectProperties.getArtifactId(), "src",
				"main", "java", packageName.replace(".", File.separator));
		for (TableProperties tp : props) {
			Set<String> imports = new HashSet<String>();
			imports.add("javax.persistence.Table");
			imports.add("javax.persistence.Entity");
			StringBuilder sb = new StringBuilder();
			sb.append("package " + packageName + ";\n\n");
			sb.append("// imports\n");
			sb.append("@Entity\n");
			sb.append("@Table(name=\"" + tp.getName() + "\")\n");
			sb.append("public class " + tp.getName() + " {\n");
			for (ColumnProperties columnProperties : tp.getColumnProperties()) {
				if (columnProperties.isPrimary()) {
					sb.append("\t@Id\n");
					imports.add("javax.persistence.Id");
					sb.append("\t@Column(");
					sb.append("columnDefinition=\"");
					sb.append(columnProperties.getDataType());
					if (columnProperties.getLength() != 16777215 && columnProperties.getLength() != 65535
							&& !(columnProperties.getDataType().contains("DATE")
									|| columnProperties.getDataType().contains("DOUBLE"))) {
						sb.append("(" + columnProperties.getLength() + ")");
					}
					sb.append("\")\n");
					imports.add("javax.persistence.Column");
				} else if (!columnProperties.isJoinColumn()) {
					sb.append("\t@Column(");
					sb.append("columnDefinition=\"");
					sb.append(columnProperties.getDataType());
					if (columnProperties.getLength() != 16777215 && columnProperties.getLength() != 65535
							&& !(columnProperties.getDataType().contains("DATE")
									|| columnProperties.getDataType().contains("DOUBLE"))) {
						sb.append("(" + columnProperties.getLength() + ")");
					}
					sb.append("\")\n");
					imports.add("javax.persistence.Column");
				} else if (columnProperties.isJoinColumn()) {
					if (columnProperties.getJoinType() == 11) {
						sb.append("\t@OneToOne\n");
						imports.add("javax.persistence.OneToOne");
					} else if (columnProperties.getJoinType() == 19) {
						sb.append("\t@OneToMany\n");
						imports.add("javax.persistence.OneToMany");
					} else if (columnProperties.getJoinType() == 99) {
						sb.append("\t@ManyToMany\n");
						imports.add("javax.persistence.ManyToMany");
					}
					sb.append("\t@JoinColumn(name=\"" + columnProperties.getName() + "\")\n");
					imports.add("javax.persistence.JoinColumn");
				}
				if (columnProperties.getJavaType().equals("Date")) {
					imports.add("java.util.Date");
				}
				sb.append("\tprivate " + columnProperties.getJavaType() + " " + columnProperties.getName() + ";\n");
			}
			sb.append("\n");
			for (ColumnProperties columnProperties : tp.getColumnProperties()) {
				sb.append("\tpublic void " + toMethod(columnProperties.getName(), "set") + "("
						+ columnProperties.getJavaType() + " " + columnProperties.getName() + ") {\n");
				sb.append("\t\tthis." + columnProperties.getName() + " = " + columnProperties.getName() + ";\n");
				sb.append("\t}\n\n");
				sb.append("\tpublic " + columnProperties.getJavaType() + " "
						+ toMethod(columnProperties.getName(), "get") + "() {\n");
				sb.append("\t\treturn " + columnProperties.getName() + ";\n");
				sb.append("\t}\n\n");
			}
			sb.append("}\n");
			String str = sb.toString();
			String imps = "";
			for (String imp : imports) {
				imps += "import " + imp + ";\n";
			}
			str = str.replace("// imports", imps);
			FileUtil.writeFile(dirName + File.separator + tp.getName() + ".java", str);
			FileUtil.replaceInFile(
					FileUtil.path(projectProperties.getLocation(), projectProperties.getArtifactId(), "src", "main",
							"webapp", "WEB-INF") + "dispatcher-servlet.xml",
					"				<!-- entities -->", "				<!-- entities -->\n				<entry key=\""
							+ tp.getName() + "\" value=\"" + packageName + "." + tp.getName() + "\"></entry>");
		}
	}

	private String toMethod(String propName, String prefix) {
		return prefix + Character.toUpperCase(propName.charAt(0)) + propName.substring(1);
	}
}
