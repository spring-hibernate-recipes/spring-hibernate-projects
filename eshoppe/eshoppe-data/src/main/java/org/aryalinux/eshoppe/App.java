package org.aryalinux.eshoppe;

import java.util.Date;
import java.util.Iterator;

import org.aryalinux.eshoppe.model.Category;
import org.aryalinux.eshoppe.repositories.CategoryRepository;
import org.hibernate.SessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
		CategoryRepository categoryRepository = (CategoryRepository) applicationContext
				.getBean(CategoryRepository.class);
		Category category = new Category();
		category.setCreatedDate(new Date());
		category.setCreatedBy("chandrakant");
		category.setName("Men's Shoes");
		category.setDescription("Men's Shoes for all occassions. Casuals, formals, canvas, sports shoes, floaters and slippers");
		categoryRepository.save(category);
		Iterable<Category> iterable = categoryRepository.findAll();
		Iterator<Category> i = iterable.iterator();
		while(i.hasNext()) {
			System.out.println(i.next().getName());
		}
		SessionFactory factory = (SessionFactory) applicationContext.getBean("sessionFactory");
		applicationContext.close();
	}
}
