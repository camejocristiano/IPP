/*package br.net.ipp.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.models.cursos.Curso;

@Controller
@Transactional
@RequestMapping("/sw")
public class CursosController {

	private CursoRepository cursoRepository;
	
	@Autowired
	public CursosController(
			CursoRepository cursoRepository
			) {
		this.cursoRepository = cursoRepository;
	}

	@GetMapping("/curso")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("cursos/home");
		modelAndView.addObject("cursos", cursoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/")
	public ModelAndView cursos() {
		ModelAndView modelAndView = new ModelAndView("cursos/cursos");
		modelAndView.addObject("cursos", cursoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/{id}")
	public ModelAndView curso(Curso curso, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/curso");
		curso = cursoRepository.findOne(id);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("cursos", cursoRepository.findAll());
		return modelAndView;
	}
	
}
*/