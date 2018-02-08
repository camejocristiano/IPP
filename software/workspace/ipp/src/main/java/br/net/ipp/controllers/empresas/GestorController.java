package br.net.ipp.controllers.empresas;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Gestor;

@Controller
@Transactional
@RequestMapping("/sw")
public class GestorController {

	private GestorRepository gestorRepository;
	private EmpresaRepository empresaRepository;
	
	@Autowired
	public GestorController(
			GestorRepository gestorRepository,
			EmpresaRepository empresaRepository
			) {
		this.gestorRepository = gestorRepository;
		this.empresaRepository = empresaRepository;
	}

	@GetMapping("/gestor/form")
	public ModelAndView gestor(Gestor gestor) {
		ModelAndView modelAndView = new ModelAndView("empresas/gestores/gestor");
		return modelAndView;
	}

	@PostMapping("/gestor")
	public ModelAndView save(@Valid Gestor gestor, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/empresas");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("gestor", gestor);
		} else {
			gestorRepository.save(gestor);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("gestor", gestor);
			this.load(gestor.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/gestor/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/gestores/gestor");
		Gestor gestor = gestorRepository.findOne(id);
		modelAndView.addObject("gestor", gestor);
		return modelAndView;
	}
	
	@GetMapping("/gestorEmpresa/{id}")
	public ModelAndView gestorEmpresa(Gestor gestor, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/gestores/gestor");
		Empresa empresa = empresaRepository.findOne(id);
		modelAndView.addObject("empresa", empresa);
		modelAndView.addObject("gestor", gestor);
		return modelAndView;
	}

	/*
	 * 
	 *  Gestores da Empresa.id
	 */
	@GetMapping("/gestores/{id}")
	public ModelAndView gestoresEmpresa(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/gestores/gestores");
		Empresa empresa = empresaRepository.findOne(id);
		modelAndView.addObject("empresa", empresa);
		modelAndView.addObject("gestores", gestorRepository.findByEmpresa(empresa));
		return modelAndView;
	}

	@PostMapping("/gestor/{id}")
	public ModelAndView update(@Valid Gestor gestor, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/empresas");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("gestor", gestor);
		} else {
			gestorRepository.save(gestor);
			modelAndView.addObject("gestor", gestor);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
