package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceDAO extends GenericDAO<Price, Integer> {
	public PriceDAO() {
		super(Price.class);
	}
}
