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

import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.models.empresas.Gestor;

@Controller
@Transactional
@RequestMapping("/sw/gestores")
public class GestorController {

	private GestorRepository gestorRepository;
	
	@Autowired
	public void GestorEndPoint(
			GestorRepository gestorRepository
			) {
		this.gestorRepository = gestorRepository;
	}

	@GetMapping("/form")
	public ModelAndView gestor(Gestor gestor) {
		ModelAndView modelAndView = new ModelAndView("empresas/gestores/gestor");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Gestor gestor, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/");
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

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/gestores/gestor");
		Gestor gestor = gestorRepository.findOne(id);
		modelAndView.addObject("gestor", gestor);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Gestor gestor, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/");
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
