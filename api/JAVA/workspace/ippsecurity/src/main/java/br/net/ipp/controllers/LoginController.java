package br.net.ipp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.CustomUserDetailService;

@Controller
public class LoginController {

	private CustomUserDetailService customUserDetailService;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public LoginController(
			CustomUserDetailService customUserDetailService,
			UsuarioRepository usuarioRepository
			) {
		this.customUserDetailService = customUserDetailService;
		this.usuarioRepository = usuarioRepository;
	}
	
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
