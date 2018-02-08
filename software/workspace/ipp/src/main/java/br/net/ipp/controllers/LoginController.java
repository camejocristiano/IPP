package br.net.ipp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
public class LoginController {

	@Autowired
	public LoginController() {}
	
	@GetMapping("/login")
	public ModelAndView login(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
	@PostMapping("/login")
	public ModelAndView logar(User user) {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	
}