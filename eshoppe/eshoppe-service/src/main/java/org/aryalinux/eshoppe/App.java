package org.aryalinux.eshoppe;

import org.aryalinux.eshoppe.commons.request.CreateNewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.CreateNewCategoryResponse;
import org.aryalinux.eshoppe.service.ProductCategoryService;
import org.aryalinux.eshoppe.service.impl.ProductCategoryServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("service.xml");
		ProductCategoryService categoryService = applicationContext.getBean(ProductCategoryServiceImpl.class);
		CreateNewCategoryRequest categoryRequest = new CreateNewCategoryRequest();
		categoryRequest.setName("Electronics");
		categoryRequest.setDescription("Consumer Electronics");
		CreateNewCategoryResponse createNewCategoryResponse = categoryService.createNewCategory(categoryRequest);
		System.out.println(createNewCategoryResponse.getMessage());
		System.out.println(createNewCategoryResponse.getCategoryId());
		applicationContext.close();
	}
}
