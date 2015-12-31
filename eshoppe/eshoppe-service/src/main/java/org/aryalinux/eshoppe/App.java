package org.aryalinux.eshoppe;

import org.aryalinux.eshoppe.commons.request.NewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.NewCategoryResponse;
import org.aryalinux.eshoppe.service.ProductCategoryService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("service.xml");
		ProductCategoryService categoryService = (ProductCategoryService) applicationContext
				.getBean("productCategoryServiceImpl");
		NewCategoryRequest request1 = new NewCategoryRequest();
		request1.setName("Electronics");
		request1.setDescription("Consumer Electronics");
		NewCategoryResponse response1 = categoryService.createNewCategory(request1);
		System.out.println(response1);
		NewCategoryRequest categoryRequest = new NewCategoryRequest();
		categoryRequest.setName("Smartphones");
		categoryRequest.setDescription("Smartphones");
		categoryRequest.getProperties().add("Operating System");
		categoryRequest.getProperties().add("Brand");
		categoryRequest.getProperties().add("Storage");
		categoryRequest.getProperties().add("RAM");
		categoryRequest.getProperties().add("Processor");
		categoryRequest.setParentCategoryId(response1.getCategoryId());
		NewCategoryResponse createNewCategoryResponse = categoryService.createNewCategory(categoryRequest);
		System.out.println(createNewCategoryResponse);
		applicationContext.close();
	}
}
