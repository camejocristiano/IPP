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

import br.net.ipp.daos.aprendizes.EscolaridadeRepository;
import br.net.ipp.models.aprendizes.Escolaridade;

@Controller
@Transactional
@RequestMapping("/escolaridades")
public class EscolaridadeController {

	private EscolaridadeRepository escolaridadeRepository;
	
	@Autowired
	public void EscolaridadeEndPoint(
			EscolaridadeRepository escolaridadeRepository
			) {
		this.escolaridadeRepository = escolaridadeRepository;
	}

	@GetMapping("/form")
	public ModelAndView escolaridade(Escolaridade escolaridade) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
		modelAndView.addObject("escolaridade", escolaridade);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Escolaridade escolaridade, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("escolaridade", escolaridade);
		} else {
			escolaridadeRepository.save(escolaridade);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("escolaridade", escolaridade);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
		Escolaridade escolaridade = escolaridadeRepository.findOne(id);
		modelAndView.addObject("escolaridade", escolaridade);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Escolaridade escolaridade, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("escolaridade", escolaridade);
		} else {
			escolaridadeRepository.save(escolaridade);
			modelAndView.addObject("escolaridade", escolaridade);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
