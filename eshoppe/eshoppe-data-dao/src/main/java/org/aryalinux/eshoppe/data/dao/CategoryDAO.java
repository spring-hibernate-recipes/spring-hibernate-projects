package org.aryalinux.eshoppe.data.dao;

import org.aryalinux.eshoppe.data.model.Category;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class CategoryDAO extends GenericDAO<Category, Integer> {

	public CategoryDAO() {
		super(Category.class);
	}

}
