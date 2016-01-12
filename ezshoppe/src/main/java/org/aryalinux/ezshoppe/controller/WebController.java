package org.aryalinux.ezshoppe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@RequestMapping(path = { "/", "/index.html" })
	public ModelAndView homePage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

	@RequestMapping(path = { "/newCategory.html" })
	public ModelAndView newCategory(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("newCategory");
		return modelAndView;
	}

	@RequestMapping(path = { "/categories.html" })
	public ModelAndView categories(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("categories");
		return modelAndView;
	}

	@RequestMapping(path = { "/categoryDashboard.html" })
	public ModelAndView categoryDashboard(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("categoryDashboard");
		return modelAndView;
	}

	@RequestMapping(path = { "/product.html" })
	public ModelAndView productForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView("product");
		return modelAndView;
	}
}
