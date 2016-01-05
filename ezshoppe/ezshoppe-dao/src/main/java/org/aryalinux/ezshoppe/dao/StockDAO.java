package org.aryalinux.ezshoppe.dao;

import org.aryalinux.ezshoppe.model.Stock;
import org.springframework.stereotype.Component;

@Component
public class StockDAO extends GenericDAO<Stock, Integer> {
	public StockDAO() {
		super(Stock.class);
	}
}
