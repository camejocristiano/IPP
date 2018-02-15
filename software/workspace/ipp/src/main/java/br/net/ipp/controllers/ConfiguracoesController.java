package br.net.ipp.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UsuarioRepository;

@Controller
@Transactional
@RequestMapping("/sw")
public class ConfiguracoesController {

	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public ConfiguracoesController(
			UsuarioRepository usuarioRepository
			) {
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/configuracoes")
	public ModelAndView configuracoes(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/home");
		modelAndView.addObject("usuarioSessao", usuarioRepository.findByUsername(userDetails.getUsername()));
		return modelAndView;
	}
	
}
