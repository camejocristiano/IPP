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

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Matricula;

@Controller
@Transactional
@RequestMapping("/matriculas")
public class MatriculaController {
	
private MatriculaRepository matriculaRepository;
private CursoRepository cursoRepository;
private TurmaRepository turmaRepository;
private JovemRepository jovemRepository;
	
	@Autowired
	public void MatriculaEndPoint(
			MatriculaRepository matriculaRepository,
			CursoRepository cursoRepository,
			TurmaRepository turmaRepository,
			JovemRepository jovemRepository			
			) {
		this.matriculaRepository = matriculaRepository;
		this.cursoRepository = cursoRepository;
		this.turmaRepository = turmaRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form/{id}")
	public ModelAndView matriculaCurso(Matricula matricula, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/matriculas/matricula");
		modelAndView.addObject("matricula", matricula);
		Curso curso = cursoRepository.findOne(id);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("turmas", turmaRepository.findAllByCurso(curso));
		modelAndView.addObject("jovens", jovemRepository.findAll());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Matricula matricula, BindingResult bindingResult) {
		Long id = matricula.getTurma().getCurso().getId();
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
		modelAndView.addObject("cursos", cursoRepository.findAll());
		modelAndView.addObject("turmas", turmaRepository.findAll());
		modelAndView.addObject("jovens", jovemRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Matricula matricula, BindingResult bindingResult) {
		Long id = matricula.getTurma().getCurso().getId();
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
