package org.aryalinux.eshoppe;

import java.util.List;
import java.util.Random;

import org.aryalinux.eshoppe.data.dao.CategoryDAO;
import org.aryalinux.eshoppe.data.dao.ProductDAO;
import org.aryalinux.eshoppe.data.model.Price;
import org.aryalinux.eshoppe.data.model.Product;
import org.aryalinux.eshoppe.data.model.ProductCategory;
import org.aryalinux.eshoppe.utils.DataUtil;
import org.aryalinux.eshoppe.utils.ObjectGenerator;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	static DataUtil du = new DataUtil();

	public static void main(String[] args) {
		ObjectGenerator objectGenerator = new ObjectGenerator();
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("data-dao.xml");
		List categories = objectGenerator.createObjects(ProductCategory.class, 50);
		CategoryDAO categoryDAO = applicationContext.getBean(CategoryDAO.class);
		ProductDAO productDAO = applicationContext.getBean(ProductDAO.class);
		for (Object o : categories) {
			ProductCategory category = (ProductCategory) o;
			System.out.println(category.getName());
			System.out.println(category.getDescription());
			System.out.println(category.getCreatedDate());
			category.setActive(1);
			int parentId = du.getRandomId("productCategories", "id");

			if (parentId != 0 && new Random().nextBoolean()) {
				ProductCategory category2 = new ProductCategory();
				category2.setId(parentId);
				category.setParent(category2);
			}
			System.out.println(categoryDAO.create((ProductCategory) o));
		}
		List products = objectGenerator.createObjects(Product.class, 1000);
		for (Object o : products) {
			Product p = (Product) o;
			p.setActive(1);
			ProductCategory category = new ProductCategory();
			p.setCategory(category);
			category.setId(du.getRandomId("productCategories", "id"));
			Price price = (Price) objectGenerator.createObject(Price.class);
			price.setProduct(p);
			p.setPrice(price);
			productDAO.create(p);
		}
		applicationContext.close();
	}
}
