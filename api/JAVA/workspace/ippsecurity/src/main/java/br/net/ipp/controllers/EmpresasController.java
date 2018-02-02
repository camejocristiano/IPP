package br.net.ipp.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.services.CustomUserDetailService;

@Controller
@Transactional
@RequestMapping("/sw/empresas")
public class EmpresasController {

	private CustomUserDetailService customUserDetailService;
	private EmpresaRepository empresaRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private GestorRepository gestorRepository;
	
	@Autowired
	public EmpresasController(
			CustomUserDetailService customUserDetailService,
			EmpresaRepository empresaRepository,
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			GestorRepository gestorRepository
			) {
		this.customUserDetailService = customUserDetailService;
		this.empresaRepository = empresaRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.gestorRepository = gestorRepository;
	}
	
	@GetMapping("empresas")
	public ModelAndView empresas() {
		ModelAndView modelAndView = new ModelAndView("empresas/empresas");
		modelAndView.addObject("empresas", empresaRepository.findAll());
		return modelAndView;
	}

}
