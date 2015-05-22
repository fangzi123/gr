package com.cyou.gr.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cyou.gr.web.comm._BaseController;

@RequestMapping("/calendar")
@Controller
public class CalendarController extends _BaseController{
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("docList", 1);
		return "calendar";
	}
	
}
