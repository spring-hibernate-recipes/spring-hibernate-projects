package org.aryalinux.celestia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
	@RequestMapping(path = "dashboard.html")
	public ModelAndView hello() {
		return new ModelAndView("dashboard");
	}
}
