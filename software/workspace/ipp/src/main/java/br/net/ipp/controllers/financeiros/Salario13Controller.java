package br.net.ipp.controllers.financeiros;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/sw")
public class Salario13Controller {

	private JovemRepository jovemRepository;
	
	@Autowired
	public Salario13Controller(
			JovemRepository jovemRepository
			) {
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/salarios13")
	public ModelAndView salario13() {
		ModelAndView modelAndView = new ModelAndView("financeiros/salarios/salarios");
		modelAndView.addObject("jovens", jovemRepository.findAll());
		return modelAndView;
	}
	
	/*@GetMapping("/salario13/form")
	public ModelAndView salario13(Salario13 salario13) {
		ModelAndView modelAndView = new ModelAndView("financeiros/salarios/salario");
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
*/
	@GetMapping("/salario13/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/salarios/salario");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}
	
/*	@PostMapping("/salario13/{id}")
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
	}*/
	
}
