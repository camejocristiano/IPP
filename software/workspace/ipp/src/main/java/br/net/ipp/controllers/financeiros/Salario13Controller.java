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

import br.net.ipp.daos.financeiros.Salario13Repository;
import br.net.ipp.models.financeiros.Salario13;

@Controller
@Transactional
@RequestMapping("/salarios13")
public class Salario13Controller {

	private Salario13Repository salario13Repository;
	
	@Autowired
	public void Salario13EndPoint(
			Salario13Repository salario13Repository
			) {
		this.salario13Repository = salario13Repository;
	}

	@GetMapping("/form")
	public ModelAndView salario13(Salario13 salario13) {
		ModelAndView modelAndView = new ModelAndView("financeiros/salarios13/salario13");
		modelAndView.addObject("salario13", salario13);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Salario13 salario13, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("salario13", salario13);
		} else {
			salario13Repository.save(salario13);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("salario13", salario13);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/salarios13/salario13");
		Salario13 salario13 = salario13Repository.findOne(id);
		modelAndView.addObject("salario13", salario13);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Salario13 salario13, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("salario13", salario13);
		} else {
			salario13Repository.save(salario13);
			modelAndView.addObject("salario13", salario13);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
