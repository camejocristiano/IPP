package br.net.ipp.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.empresas.EmpresaRepository;

@Controller
@Transactional
@RequestMapping("/sw")
public class EmpresasController {

	private EmpresaRepository empresaRepository;
	
	@Autowired
	public EmpresasController(
			EmpresaRepository empresaRepository
			) {
		this.empresaRepository = empresaRepository;
	}
	
	@GetMapping("/empresas")
	public ModelAndView empresas() {
		ModelAndView modelAndView = new ModelAndView("empresas/empresas/empresas");
		modelAndView.addObject("empresas", empresaRepository.findAll());
		return modelAndView;
	}

}
