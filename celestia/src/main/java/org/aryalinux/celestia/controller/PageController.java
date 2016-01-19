package org.aryalinux.celestia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(path = "index")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	@RequestMapping(path = "dashboard", method = RequestMethod.GET)
	public ModelAndView dashboard() {
		return new ModelAndView("dashboard");
	}

}
