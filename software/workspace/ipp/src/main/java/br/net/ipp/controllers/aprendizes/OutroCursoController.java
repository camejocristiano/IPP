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

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.aprendizes.OutroCursoRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.OutroCurso;

@Controller
@Transactional
@RequestMapping("/sw")
public class OutroCursoController {

	private OutroCursoRepository outroCursoRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public OutroCursoController(
			OutroCursoRepository outroCursoRepository,
			JovemRepository jovemRepository
			) {
		this.outroCursoRepository = outroCursoRepository;
		this.jovemRepository = jovemRepository;
	}
	
	@GetMapping("/outroCursoForm/{id}")
	public ModelAndView outroCursoJovem(OutroCurso outroCurso, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/habilidades/cursos/curso");
		modelAndView.addObject("outroCurso", outroCurso);
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping("/outroCurso")
	public ModelAndView save(@Valid OutroCurso outroCurso, BindingResult bindingResult) {
		Long id = outroCurso.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("outroCurso", outroCurso);
		} else {
			outroCursoRepository.save(outroCurso);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("outroCurso", outroCurso);
		}		
		return modelAndView;
	}

	@GetMapping("/outroCurso/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/habilidades/cursos/curso");
		OutroCurso outroCurso = outroCursoRepository.findOne(id);
		modelAndView.addObject("outroCurso", outroCurso);
		return modelAndView;
	}
	
	@PostMapping("/outroCurso/{id}")
	public ModelAndView update(@Valid OutroCurso outroCurso, BindingResult bindingResult) {
		Long id = outroCurso.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("outroCurso", outroCurso);
		} else {
			outroCursoRepository.save(outroCurso);
			modelAndView.addObject("outroCurso", outroCurso);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
