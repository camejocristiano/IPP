package br.net.ipp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@Autowired
	public MainController() {}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw");
		return modelAndView;
	}
	
	@GetMapping("/sw")
	public ModelAndView indexSW() {
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}

}
