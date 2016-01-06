package org.aryalinux;

import java.util.ArrayList;
import java.util.Date;

import org.aryalinux.ezshoppe.dao.ProductCategoryDAO;
import org.aryalinux.ezshoppe.model.ProductCategory;
import org.aryalinux.ezshoppe.service.CategoryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	static CategoryService categoryService = null;
	static ProductCategoryDAO categoryDAO = null;

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("service.xml");
		categoryService = applicationContext.getBean(CategoryService.class);
		categoryDAO = applicationContext.getBean(ProductCategoryDAO.class);
		saveProductCategory("Grocery and Staples", "Grocery and Staples", null, 1);
		saveProductCategory("Bread dairy and eggs", "Bread dairy and eggs", null, 1);
		saveProductCategory("Beverages", "Beverages", null, 1);
		saveProductCategory("Dal and Pulses", "Dal and Pulses", 2, 0);
		saveProductCategory("Rice", "Rice", 2, 0);
		saveProductCategory("Jowar, Bajra and Ragi", "Jowar, Bajra and Ragi", 2, 0);
		saveProductCategory("Dry Fruits", "Dry Fruits", 1, 0);
		saveProductCategory("Combos", "Combos", 1, 0);
		saveProductCategory("Decorative Vegetables", "Decorative Vegetables", 1, 0);
		saveProductCategory("Imported", "Imported", 1, 0);
		//saveProductCategory("Organic Fruits And Vegetables", "Organic Fruits And Vegetables", 1, 0);
		applicationContext.close();
	}

	private static void saveProductCategory(String name, String label, Integer parentId, int topLevel) {
		ProductCategory category = new ProductCategory();
		category.setName(name);
		category.setLabel(label);
		category.setCreatedDate(new Date());
		category.setUpdatedDate(new Date());
		category.setTopLevel(topLevel);
		category.setChildren(new ArrayList<ProductCategory>());
		if (parentId != null) {
			ProductCategory parent = categoryDAO.getById(parentId);
			parent.getChildren().add(category);
			categoryDAO.update(parent);
		} else {
			categoryDAO.create(category);
		}
	}
}
