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

import br.net.ipp.daos.aprendizes.EntrevistaRepository;
import br.net.ipp.models.aprendizes.Entrevista;

@Controller
@Transactional
@RequestMapping("/entrevistas")
public class EntrevistaController {

	private EntrevistaRepository entrevistaRepository;
	
	@Autowired
	public void EntrevistaEndPoint(
			EntrevistaRepository entrevistaRepository
			) {
		this.entrevistaRepository = entrevistaRepository;
	}

	@GetMapping("/form")
	public ModelAndView entrevista(Entrevista entrevista) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/entrevistas/entrevista");
		modelAndView.addObject("entrevista", entrevista);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Entrevista entrevista, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("entrevista", entrevista);
		} else {
			entrevistaRepository.save(entrevista);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("entrevista", entrevista);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/entrevistas/entrevista");
		Entrevista entrevista = entrevistaRepository.findOne(id);
		modelAndView.addObject("entrevista", entrevista);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Entrevista entrevista, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("entrevista", entrevista);
		} else {
			entrevistaRepository.save(entrevista);
			modelAndView.addObject("entrevista", entrevista);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
