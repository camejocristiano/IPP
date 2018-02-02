package br.net.ipp.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.services.CustomUserDetailService;

@Controller
@Transactional
@RequestMapping("/sw/configuracoes")
public class ConfiguracoesController {

	private CustomUserDetailService customUserDetailService;
	private UnidadeRepository unidadeRepository;
	private UsuarioRepository usuarioRepository;
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	
	@Autowired
	public ConfiguracoesController(
			CustomUserDetailService customUserDetailService,
			UnidadeRepository unidadeRepository, 
			UsuarioRepository usuarioRepository,
			GrupoDePermissoesRepository grupoDePermissoesRepository
			) {
		this.customUserDetailService = customUserDetailService;
		this.usuarioRepository = usuarioRepository;
		this.unidadeRepository = unidadeRepository;
		this.grupoDePermissoesRepository = grupoDePermissoesRepository;
	}
	
	@GetMapping("configuracoes")
	public ModelAndView configuracoes() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/configuracoes");
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		modelAndView.addObject("unidades", unidadeRepository.findAll());
		modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
		return modelAndView;
	}
	
}
