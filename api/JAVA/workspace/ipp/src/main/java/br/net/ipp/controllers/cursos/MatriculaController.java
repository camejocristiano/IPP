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

import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.models.cursos.Matricula;

@Controller
@Transactional
@RequestMapping("/matriculas")
public class MatriculaController {
	
private MatriculaRepository matriculaRepository;
	
	@Autowired
	public void MatriculaEndPoint(
			MatriculaRepository matriculaRepository
			) {
		this.matriculaRepository = matriculaRepository;
	}

	@GetMapping("/form")
	public ModelAndView matricula(Matricula matricula) {
		ModelAndView modelAndView = new ModelAndView("cursos/matriculas/matricula");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Matricula matricula, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("matricula", matricula);
		} else {
			matriculaRepository.save(matricula);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("matricula", matricula);
			this.load(matricula.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/matriculas/matricula");
		Matricula matricula = matriculaRepository.findOne(id);
		modelAndView.addObject("matricula", matricula);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Matricula matricula, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("matricula", matricula);
		} else {
			matriculaRepository.save(matricula);
			modelAndView.addObject("matricula", matricula);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
