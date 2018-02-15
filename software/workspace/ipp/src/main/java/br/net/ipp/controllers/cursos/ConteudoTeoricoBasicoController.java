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

import br.net.ipp.daos.cursos.ConteudoTeoricoBasicoRepository;
import br.net.ipp.models.cursos.ConteudoTeoricoBasico;

@Controller
@Transactional
@RequestMapping("/sw")
public class ConteudoTeoricoBasicoController {

private ConteudoTeoricoBasicoRepository conteudoTeoricoBasicoRepository;

	@Autowired
	public void ConteudoTeoricoBasicoEndPoint(
			ConteudoTeoricoBasicoRepository conteudoTeoricoBasicoRepository
			) {
		this.conteudoTeoricoBasicoRepository = conteudoTeoricoBasicoRepository;
	}

	@GetMapping("/basicos")
	public ModelAndView basicos(ConteudoTeoricoBasico conteudoTeoricoBasico) {
		ModelAndView modelAndView = new ModelAndView("cursos/matrizes/basicos/basicos");
		modelAndView.addObject("basicos", conteudoTeoricoBasicoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/basicos/form")
	public ModelAndView conteudoTeoricoBasico(ConteudoTeoricoBasico conteudoTeoricoBasico) {
		ModelAndView modelAndView = new ModelAndView("cursos/matrizes/basicos/basico");
		modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
		return modelAndView;
	}

	@PostMapping("/basicos")
	public ModelAndView save(@Valid ConteudoTeoricoBasico conteudoTeoricoBasico, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/cursos/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
		} else {
			conteudoTeoricoBasicoRepository.save(conteudoTeoricoBasico);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
		}		
		return modelAndView;
	}

	@GetMapping("/basicos/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/matrizes/basicos/basico");
		ConteudoTeoricoBasico conteudoTeoricoBasico = conteudoTeoricoBasicoRepository.findOne(id);
		modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
		return modelAndView;
	}
	
	@PostMapping("/basicos/{id}")
	public ModelAndView update(@Valid ConteudoTeoricoBasico conteudoTeoricoBasico, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/cursos/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
		} else {
			conteudoTeoricoBasicoRepository.save(conteudoTeoricoBasico);
			modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
