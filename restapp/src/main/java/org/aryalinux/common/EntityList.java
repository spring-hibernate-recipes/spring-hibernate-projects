package org.aryalinux.common;

import java.util.ArrayList;
import java.util.List;

public class EntityList {
	private List<Object> entities;
	private List<Integer> operations;
	private Integer primaryEntityIndex;
	public static final Integer SAVE = 1;
	public static final Integer UPDATE = 2;
	public static final Integer DELETE = 3;

	public EntityList() {
		entities = new ArrayList<Object>();
		operations = new ArrayList<Integer>();
	}

	public List<Object> getEntities() {
		return entities;
	}

	public List<Integer> getOperations() {
		return operations;
	}

	public Integer getPrimaryEntityIndex() {
		return primaryEntityIndex;
	}

	public EntityList add(Object ref) {
		entities.add(ref);
		operations.add(SAVE);
		return this;
	}

	public EntityList addPrimary(Object ref) {
		entities.add(ref);
		operations.add(SAVE);
		primaryEntityIndex = entities.size();
		return this;
	}

	public EntityList add(Object ref, Integer operation) {
		entities.add(ref);
		operations.add(operation);
		return this;
	}
}
