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

import br.net.ipp.daos.aprendizes.FichaSocialRepository;
import br.net.ipp.models.aprendizes.FichaSocial;

@Controller
@Transactional
@RequestMapping("/fichasSociais")
public class FichaSocialController {

	private FichaSocialRepository fichaSocialRepository;
	
	@Autowired
	public void FichaSocialEndPoint(
			FichaSocialRepository fichaSocialRepository
			) {
		this.fichaSocialRepository = fichaSocialRepository;
	}

	@GetMapping("/form")
	public ModelAndView fichaSocial(FichaSocial fichaSocial) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		modelAndView.addObject("fichaSocial", fichaSocial);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid FichaSocial fichaSocial, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		} else {
			fichaSocialRepository.save(fichaSocial);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		FichaSocial fichaSocial = fichaSocialRepository.findOne(id);
		modelAndView.addObject("fichaSocial", fichaSocial);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid FichaSocial fichaSocial, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		} else {
			fichaSocialRepository.save(fichaSocial);
			modelAndView.addObject("fichaSocial", fichaSocial);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
