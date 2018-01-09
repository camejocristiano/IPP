package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.FamiliarRepository;
import br.net.ipp.models.aprendizes.Familiar;

@Controller
@Transactional
@RequestMapping("/familiares")
public class FamiliarController {

	private FamiliarRepository familiarRepository;
	
	@Autowired
	public void FamiliarEndPoint(
			FamiliarRepository familiarRepository
			) {
		this.familiarRepository = familiarRepository;
	}

	@GetMapping("/form")
	public ModelAndView familiar(Familiar familiar) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/familiares/familiar");
		modelAndView.addObject("familiar", familiar);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Familiar familiar, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("familiar", familiar);
		} else {
			familiarRepository.save(familiar);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("familiar", familiar);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/familiares/familiar");
		Familiar familiar = familiarRepository.findOne(id);
		modelAndView.addObject("familiar", familiar);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Familiar familiar, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("familiar", familiar);
		} else {
			familiarRepository.save(familiar);
			modelAndView.addObject("familiar", familiar);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
