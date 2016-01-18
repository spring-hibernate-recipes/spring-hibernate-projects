package org.aryalinux.classicmodels.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(path = "hello.html")
	public ModelAndView hello() {
		return new ModelAndView("hello");
	}

	@RequestMapping(path = "products.html")
	public ModelAndView productPage() {
		return new ModelAndView("products");
	}

	@RequestMapping(path = "simpleForm.html")
	public ModelAndView simpleForm() {
		return new ModelAndView("simpleForm");
	}
}
