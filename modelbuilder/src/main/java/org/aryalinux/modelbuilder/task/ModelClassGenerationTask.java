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
			sb.append("public class " + tp.getEntityClassName() + " {\n");
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
					sb.append("\"");
					sb.append(", name=\"" + columnProperties.getTableColumnName() + "\"");
					sb.append(")\n");
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
					sb.append("\"");
					sb.append(", name=\"" + columnProperties.getTableColumnName() + "\"");
					sb.append(")\n");
					imports.add("javax.persistence.Column");
				} else if (columnProperties.isJoinColumn()) {
					int joinType = columnProperties.getJoinType();
					if (joinType == 11) {
						sb.append("\t@OneToOne");
						imports.add("javax.persistence.OneToOne");
					} else if (joinType == 19) {
						sb.append("\t@OneToMany");
						imports.add("javax.persistence.OneToMany");
					} else if (joinType == 91) {
						sb.append("\t@ManyToOne");
						imports.add("javax.persistence.ManyToOne");
					}
					if (joinType == 11 || joinType == 91 || joinType == 19) {
						if (columnProperties.getCascadeType() != null || columnProperties.getFetchType() != null) {
							sb.append("(");
							if (columnProperties.getCascadeType() != null) {
								sb.append("cascade=CascadeType." + columnProperties.getCascadeType());
								imports.add("javax.persistence.CascadeType");
							}
							if (columnProperties.getFetchType() != null) {
								if (columnProperties.getCascadeType() != null) {
									sb.append(", ");
								}
								sb.append("fetch=FetchType." + columnProperties.getFetchType());
								imports.add("javax.persistence.FetchType");
							}
							sb.append(")");
						}
					}
					sb.append("\n");
					sb.append("\t@JoinColumn(name=\"" + columnProperties.getTableColumnName() + "\")\n");
					imports.add("javax.persistence.JoinColumn");
				}
				if (columnProperties.getJavaType().equals("Date")) {
					imports.add("java.util.Date");
				}
				sb.append("\tprivate " + columnProperties.getJavaType() + " " + columnProperties.getPropertyName()
						+ ";\n");
			}
			sb.append("\n");
			for (ColumnProperties columnProperties : tp.getColumnProperties()) {
				sb.append("\tpublic void " + toMethod(columnProperties.getPropertyName(), "set") + "("
						+ columnProperties.getJavaType() + " " + columnProperties.getPropertyName() + ") {\n");
				sb.append("\t\tthis." + columnProperties.getPropertyName() + " = " + columnProperties.getPropertyName()
						+ ";\n");
				sb.append("\t}\n\n");
				sb.append("\tpublic " + columnProperties.getJavaType() + " "
						+ toMethod(columnProperties.getPropertyName(), "get") + "() {\n");
				sb.append("\t\treturn " + columnProperties.getPropertyName() + ";\n");
				sb.append("\t}\n\n");
			}
			sb.append("}\n");
			String str = sb.toString();
			String imps = "";
			for (String imp : imports) {
				imps += "import " + imp + ";\n";
			}
			str = str.replace("// imports", imps);
			FileUtil.writeFile(dirName + File.separator + tp.getEntityClassName() + ".java", str);
			FileUtil.replaceInFile(
					FileUtil.path(projectProperties.getLocation(), projectProperties.getArtifactId(), "src", "main",
							"webapp", "WEB-INF") + "dispatcher-servlet.xml",
					"				<!-- entities -->",
					"				<!-- entities -->\n				<entry key=\"" + tp.getRestResource()
							+ "\" value=\"" + packageName + "." + tp.getEntityClassName() + "\"></entry>");
		}
	}

	private String toMethod(String propName, String prefix) {
		return prefix + Character.toUpperCase(propName.charAt(0)) + propName.substring(1);
	}
}
