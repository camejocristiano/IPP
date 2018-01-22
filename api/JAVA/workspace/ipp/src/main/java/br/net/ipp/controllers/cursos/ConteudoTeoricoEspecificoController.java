package br.net.ipp.controllers.cursos;

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

import br.net.ipp.daos.cursos.ConteudoTeoricoEspecificoRepository;
import br.net.ipp.models.cursos.ConteudoTeoricoEspecifico;

@Controller
@Transactional
@RequestMapping("/conteudoTeoricoEspecificos")
public class ConteudoTeoricoEspecificoController {

private ConteudoTeoricoEspecificoRepository conteudoTeoricoEspecificoRepository;

	@Autowired
	public void ConteudoTeoricoEspecificoEndPoint(
			ConteudoTeoricoEspecificoRepository conteudoTeoricoEspecificoRepository
			) {
		this.conteudoTeoricoEspecificoRepository = conteudoTeoricoEspecificoRepository;
	}

	@GetMapping("/form")
	public ModelAndView conteudoTeoricoEspecifico(ConteudoTeoricoEspecifico conteudoTeoricoEspecifico) {
		ModelAndView modelAndView = new ModelAndView("cursos/matrizes/especificos/especifico");
		modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid ConteudoTeoricoEspecifico conteudoTeoricoEspecifico, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
		} else {
			conteudoTeoricoEspecificoRepository.save(conteudoTeoricoEspecifico);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/matrizes/especificos/especifico");
		ConteudoTeoricoEspecifico conteudoTeoricoEspecifico = conteudoTeoricoEspecificoRepository.findOne(id);
		modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid ConteudoTeoricoEspecifico conteudoTeoricoEspecifico, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
		} else {
			conteudoTeoricoEspecificoRepository.save(conteudoTeoricoEspecifico);
			modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
