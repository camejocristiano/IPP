package br.net.ipp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {
	
	@GetMapping("/logout")
	public ModelAndView logout() {
		ModelAndView modelAndView = new ModelAndView("");
		return modelAndView;
	}
	
}
