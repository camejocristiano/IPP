package br.net.ipp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.services.CustomUserDetailService;
import br.net.ipp.services.UserService;

@Controller
public class MainController {

	private UnidadeRepository unidadeRepository;
	private UsuarioRepository usuarioRepository;
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	private JovemRepository jovemRepository;
	private EmpresaRepository empresaRepository;
	private CustomUserDetailService customUserDetailService;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private GestorRepository gestorRepository;
	private UserService permissoesService;
	
	@Autowired
	public MainController(
			UnidadeRepository unidadeRepository, 
			UsuarioRepository usuarioRepository,
			GrupoDePermissoesRepository grupoDePermissoesRepository,
			JovemRepository jovemRepository,
			EmpresaRepository empresaRepository,
			CustomUserDetailService customUserDetailService,
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			GestorRepository gestorRepository,
			UserService permissoesService
			) {
		this.usuarioRepository = usuarioRepository;
		this.unidadeRepository = unidadeRepository;
		this.grupoDePermissoesRepository = grupoDePermissoesRepository;
		this.jovemRepository = jovemRepository;
		this.empresaRepository = empresaRepository;
		this.customUserDetailService = customUserDetailService;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.gestorRepository = gestorRepository;
		this.permissoesService = permissoesService;
	}
	
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
