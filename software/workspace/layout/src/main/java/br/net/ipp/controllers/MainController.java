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
		ModelAndView modelAndView = new ModelAndView("index");
		return modelAndView;
	}
	
	@GetMapping("/configuracoes")
	public ModelAndView configuracoes() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/home");
		return modelAndView;
	}
	
	@GetMapping("/aprendizes")
	public ModelAndView aprendizes() {
		ModelAndView modelAndView = new ModelAndView("aprendizes/home");
		return modelAndView;
	}
	
	@GetMapping("/cursos")
	public ModelAndView cursos() {
		ModelAndView modelAndView = new ModelAndView("cursos/home");
		return modelAndView;
	}
	
	@GetMapping("/curso")
	public ModelAndView curso() {
		ModelAndView modelAndView = new ModelAndView("cursos/curso");
		return modelAndView;
	}
	
	@GetMapping("/frequencias")
	public ModelAndView frequencias() {
		ModelAndView modelAndView = new ModelAndView("frequencias/home");
		return modelAndView;
	}
	
	@GetMapping("/empresas")
	public ModelAndView empresas() {
		ModelAndView modelAndView = new ModelAndView("empresas/home");
		return modelAndView;
	}
	
	@GetMapping("/financeiros")
	public ModelAndView financeiros() {
		ModelAndView modelAndView = new ModelAndView("financeiros/home");
		return modelAndView;
	}
	
}