package org.aryalinux.celestia.commons.ui;

import java.util.ArrayList;
import java.util.List;

public class Form {
	private String action;
	private List<FormField> fields;

	public Form() {
		fields = new ArrayList<FormField>();
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public List<FormField> getFields() {
		return fields;
	}

	public void setFields(List<FormField> fields) {
		this.fields = fields;
	}

	public Form addField(String name, String label) {
		FormField field = new FormField();
		field.setName(name);
		field.setLabel(label);
		fields.add(field);
		return this;
	}
}
