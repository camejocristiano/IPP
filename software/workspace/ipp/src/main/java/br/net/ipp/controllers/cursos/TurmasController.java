package br.net.ipp.controllers.cursos;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.models.cursos.Curso;

@Controller
@Transactional
@RequestMapping("/sw/turmas")
public class TurmasController {
	
private TurmaRepository turmaRepository;
private CursoRepository cursoRepository;
	
	@Autowired
	public TurmasController(
			TurmaRepository turmaRepository,
			CursoRepository cursoRepository
			) {
		this.turmaRepository = turmaRepository;
		this.cursoRepository = cursoRepository;
	}

	@GetMapping("/{id}")
	public ModelAndView index(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/turmas/turmas");
		Curso curso = cursoRepository.findOne(id);
		modelAndView.addObject("turmas", turmaRepository.findAllByCurso(curso));
		modelAndView.addObject("curso", curso);
		return modelAndView;
	}
	
}
