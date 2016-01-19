package org.aryalinux.projectbuilder;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProjectDatabase implements Serializable {
	private static final long serialVersionUID = 1L;
	public Map<String, Project> projects = new LinkedHashMap<>();
}
