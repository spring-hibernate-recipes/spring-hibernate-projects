package org.aryalinux.celestia.commons.ui;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private List<String> columns;
	private boolean hasCheckboxColum;
	private boolean hasDeleteColumn;
	private boolean hasEditColumn;

	public Table() {
		columns = new ArrayList<String>();
	}

	public List<String> getColumns() {
		return columns;
	}

	public void setColumns(List<String> columns) {
		this.columns = columns;
	}

	public boolean isHasCheckboxColum() {
		return hasCheckboxColum;
	}

	public void setHasCheckboxColum(boolean hasCheckboxColum) {
		this.hasCheckboxColum = hasCheckboxColum;
	}

	public boolean isHasDeleteColumn() {
		return hasDeleteColumn;
	}

	public void setHasDeleteColumn(boolean hasDeleteColumn) {
		this.hasDeleteColumn = hasDeleteColumn;
	}

	public boolean isHasEditColumn() {
		return hasEditColumn;
	}

	public void setHasEditColumn(boolean hasEditColumn) {
		this.hasEditColumn = hasEditColumn;
	}

}
