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
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
@Transactional
@RequestMapping("/sw")
public class RepresentanteLegalController {

	private RepresentanteLegalRepository representanteLegalRepository;
	private EmpresaRepository empresaRepository;
	
	@Autowired
	public void EmpresaEndPoint(
			RepresentanteLegalRepository representanteLegalRepository,
			EmpresaRepository empresaRepository
			) {
		this.representanteLegalRepository = representanteLegalRepository;
		this.empresaRepository = empresaRepository;
	}

	@GetMapping("/representantes/form")
	public ModelAndView representanteLegal(RepresentanteLegal representanteLegal) {
		ModelAndView modelAndView = new ModelAndView("empresas/representantes/representante");
		modelAndView.addObject("representanteLegal", representanteLegal);
		return modelAndView;
	}

	@GetMapping("/representantes/{id}")
	public ModelAndView representantesEmpresa(RepresentanteLegal representanteLegal, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/representantes/representantes");
		Empresa empresa = empresaRepository.findOne(id);
		modelAndView.addObject("representantes", representanteLegalRepository.findByEmpresa(empresa));
		modelAndView.addObject("empresa", empresa);
		return modelAndView;
	}
	
	@PostMapping("/representante")
	public ModelAndView save(@Valid RepresentanteLegal representanteLegal, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/empresas");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("representanteLegal", representanteLegal);
		} else {
			representanteLegalRepository.save(representanteLegal);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("representanteLegal", representanteLegal);
		}		
		return modelAndView;
	}

	/*
	 * Metodo GET - Formulário de Representante Legal com id da empresa  
	 *  
	 */
	@GetMapping("/representanteEmpresa/{id}")
	public ModelAndView load(RepresentanteLegal representanteLegal, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/representantes/representante");
		modelAndView.addObject("representanteLegal", representanteLegal);
		Empresa empresa = empresaRepository.findOne(id);
		modelAndView.addObject("empresa", empresa);
		return modelAndView;
	}
	
	@GetMapping("/representante/{id}")
	public ModelAndView loadRepresentante(RepresentanteLegal representanteLegal, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/representantes/representante");
		modelAndView.addObject("representanteLegal", representanteLegalRepository.findOne(id));
		return modelAndView;
	}
	
	@PostMapping("/representante/{id}")
	public ModelAndView update(@Valid RepresentanteLegal representanteLegal, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/empresas");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("representanteLegal", representanteLegal);
		} else {
			representanteLegalRepository.save(representanteLegal);
			modelAndView.addObject("representanteLegal", representanteLegal);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
