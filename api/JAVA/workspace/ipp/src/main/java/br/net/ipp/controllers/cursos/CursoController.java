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

import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.models.cursos.Curso;

@Controller
@Transactional
@RequestMapping("/cursos")
public class CursoController {

private CursoRepository cursoRepository;
private TurmaRepository turmaRepository;
private MatriculaRepository matriculaRepository;
	
	@Autowired
	public void CursoEndPoint(
			CursoRepository cursoRepository,
			TurmaRepository turmaRepository,
			MatriculaRepository matriculaRepository
			) {
		this.cursoRepository = cursoRepository;
		this.turmaRepository = turmaRepository;
		this.matriculaRepository = matriculaRepository;
	}

	@GetMapping("/form")
	public ModelAndView curso(Curso curso) {
		ModelAndView modelAndView = new ModelAndView("cursos/cursos/curso");
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("turmas", turmaRepository.findAll());
		modelAndView.addObject("matriculas", matriculaRepository.findAll());
		
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Curso curso, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("curso", curso);
		} else {
			cursoRepository.save(curso);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("curso", curso);
			this.load(curso.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/cursos/curso");
		Curso curso = cursoRepository.findOne(id);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("turmas", turmaRepository.findAll());
		modelAndView.addObject("matriculas", matriculaRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Curso curso, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("curso", curso);
		} else {
			cursoRepository.save(curso);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
