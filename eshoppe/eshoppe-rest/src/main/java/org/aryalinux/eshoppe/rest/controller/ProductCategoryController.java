package org.aryalinux.eshoppe.rest.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.aryalinux.eshoppe.Constants;
import org.aryalinux.eshoppe.commons.request.NewCategoryRequest;
import org.aryalinux.eshoppe.commons.response.GetAllCategoriesResponse;
import org.aryalinux.eshoppe.commons.response.NewCategoryResponse;
import org.aryalinux.eshoppe.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(path = "/eshoppe")
public class ProductCategoryController {
	@Autowired
	private ProductCategoryService productCategoryService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.POST, path = "/productCategory")
	public NewCategoryResponse createNewCategory(@RequestParam("parentCategory") String parentCategory,
			@RequestParam("name") String name, @RequestParam("description") String desccription,
			@RequestParam("properties") String properties, @RequestParam("image") MultipartFile[] images) {
		NewCategoryRequest newCategoryRequest = new NewCategoryRequest();
		newCategoryRequest.setDescription(desccription);
		newCategoryRequest.setName(name);
		String[] props = properties.split(",");
		Set<String> propertiesList = new HashSet<String>();
		for (String prop : props) {
			propertiesList.add(prop.trim());
		}
		newCategoryRequest.setProperties(propertiesList);
		Set<String> imageList = new HashSet<String>();
		for (MultipartFile file : images) {
			if (file != null && file.getOriginalFilename() != null && !file.getOriginalFilename().equals("")) {
				imageList.add(file.getOriginalFilename());
				try {
					InputStream inputStream = file.getInputStream();
					FileOutputStream fileOutputStream = new FileOutputStream(
							Constants.IMAGE_LOCATION + File.separator + file.getOriginalFilename());
					int bytesRead = 0;
					while ((bytesRead = inputStream.read(Constants.buffer)) > 0) {
						fileOutputStream.write(Constants.buffer, 0, bytesRead);
					}
					fileOutputStream.close();
					inputStream.close();
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
		}
		newCategoryRequest.setImageUrls(imageList);
		newCategoryRequest.setCurrentImageUrl(imageList.iterator().next());
		newCategoryRequest.setParentCategoryId(Integer.parseInt(parentCategory));
		return productCategoryService.createNewCategory(newCategoryRequest);
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/category")
	public GetAllCategoriesResponse getAllCategories() {
		return productCategoryService.getAllCategories();
	}

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET, path = "/sayhello")
	public String sayHello(@RequestParam(name = "name") String name) {
		return "Hello " + name + "!";
	}
}
