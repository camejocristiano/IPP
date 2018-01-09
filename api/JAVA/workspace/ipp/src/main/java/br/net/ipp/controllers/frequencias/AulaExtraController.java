package br.net.ipp.controllers.frequencias;

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

import br.net.ipp.daos.frequencias.AulaExtraRepository;
import br.net.ipp.models.frequencias.AulaExtra;

@Controller
@Transactional
@RequestMapping("/aulasextras")
public class AulaExtraController {

	private AulaExtraRepository aulaExtraRepository;
	
	@Autowired
	public void AulaExtraEndPoint(
			AulaExtraRepository aulaExtraRepository
			) {
		this.aulaExtraRepository = aulaExtraRepository;
	}

	@GetMapping("/form")
	public ModelAndView aulaExtra(AulaExtra aulaextra) {
		ModelAndView modelAndView = new ModelAndView("aulasextras/aulasextras/aulaextra");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid AulaExtra aulaextra, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("aulasextras/aulasextras/aulaextra");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("aulaextra", aulaextra);
		} else {
			aulaExtraRepository.save(aulaextra);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("aulaextra", aulaextra);
			this.load(aulaextra.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aulasextras/aulasextras/aulaextra");
		AulaExtra aulaextra = aulaExtraRepository.findOne(id);
		modelAndView.addObject("aulaextra", aulaextra);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid AulaExtra aulaextra, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("aulasextras/aulasextras/aulaextra");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("aulaextra", aulaextra);
		} else {
			aulaExtraRepository.save(aulaextra);
			modelAndView.addObject("aulaextra", aulaextra);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
