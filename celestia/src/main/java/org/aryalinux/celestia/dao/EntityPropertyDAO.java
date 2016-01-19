package org.aryalinux.celestia.dao;

import org.aryalinux.celestia.model.EntityProperty;
import org.springframework.stereotype.Component;

@Component
public class EntityPropertyDAO extends GenericDAO<EntityProperty, Integer> {
	public EntityPropertyDAO() {
		super(EntityProperty.class);
	}
}
