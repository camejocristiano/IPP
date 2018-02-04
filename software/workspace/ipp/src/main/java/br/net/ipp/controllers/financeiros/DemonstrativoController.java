package br.net.ipp.controllers.financeiros;

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

import br.net.ipp.daos.financeiros.DemonstrativoRepository;
import br.net.ipp.models.financeiros.Demonstrativo;

@Controller
@Transactional
@RequestMapping("/demonstrativos")
public class DemonstrativoController {

	private DemonstrativoRepository demonstrativoRepository;
	
	@Autowired
	public void DemonstrativoEndPoint(
			DemonstrativoRepository demonstrativoRepository
			) {
		this.demonstrativoRepository = demonstrativoRepository;
	}

	@GetMapping("/form")
	public ModelAndView demonstrativo(Demonstrativo demonstrativo) {
		ModelAndView modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativo");
		modelAndView.addObject("demonstrativo", demonstrativo);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Demonstrativo demonstrativo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		} else {
			demonstrativoRepository.save(demonstrativo);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativo");
		Demonstrativo demonstrativo = demonstrativoRepository.findOne(id);
		modelAndView.addObject("demonstrativo", demonstrativo);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Demonstrativo demonstrativo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		} else {
			demonstrativoRepository.save(demonstrativo);
			modelAndView.addObject("demonstrativo", demonstrativo);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
