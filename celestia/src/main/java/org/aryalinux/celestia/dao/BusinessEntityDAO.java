package org.aryalinux.celestia.dao;

import org.aryalinux.celestia.model.BusinessEntity;

public class BusinessEntityDAO extends GenericDAO<BusinessEntity, Integer> {
	public BusinessEntityDAO() {
		super(BusinessEntity.class);
	}
}
