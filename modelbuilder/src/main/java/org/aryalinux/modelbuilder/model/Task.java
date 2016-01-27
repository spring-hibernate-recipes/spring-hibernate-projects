package org.aryalinux.modelbuilder.model;

public abstract class Task {
	private Object data;
	private String name;

	public Task(String name) {
		this.name = name;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void doTask();
}
