package br.net.ipp.controllers.cursos;

import java.util.ArrayList;
import java.util.List;

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
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class MatriculaController {
	
private MatriculaRepository matriculaRepository;
private CursoRepository cursoRepository;
private TurmaRepository turmaRepository;
private JovemRepository jovemRepository;
private EnumService enumService;
	
	@Autowired
	public void MatriculaEndPoint(
			MatriculaRepository matriculaRepository,
			CursoRepository cursoRepository,
			TurmaRepository turmaRepository,
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.matriculaRepository = matriculaRepository;
		this.cursoRepository = cursoRepository;
		this.turmaRepository = turmaRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}

	@PostMapping("/matricula")
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

	@GetMapping("/matricula/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/matriculas/matricula");
		Matricula matricula = matriculaRepository.findOne(id);
		modelAndView.addObject("matricula", matricula);
		modelAndView.addObject("cursos", cursoRepository.findAll());
		modelAndView.addObject("turmas", turmaRepository.findAll());
		modelAndView.addObject("jovens", jovemRepository.findAll());
		List<String> statusDeMatricula = this.enumService.carregarStatusDeMatricula();
		modelAndView.addObject("statusDeMatricula", statusDeMatricula);
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
	
	@GetMapping("/matriculas/{id}")
	public ModelAndView matriculas(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/matriculas/matriculas");
		Curso curso = cursoRepository.findOne(id);
		List<Turma> turmas = turmaRepository.findAllByCurso(curso);
		List<Matricula> matriculas = new ArrayList<Matricula>();
		for (Turma turma : turmas) {
			List<Matricula> matric = matriculaRepository.findAllByTurma(turma);
			for (Matricula matricula : matric) {
				matriculas.add(matricula);
			}
		}
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("matriculas", matriculas);
		return modelAndView;
	}
	
	@GetMapping("/matriculasJovem/{id}")
	public ModelAndView matriculasJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/cursos/cursos");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		return modelAndView;
	}
	
}
