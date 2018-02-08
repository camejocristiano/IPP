package br.net.ipp.controllers.cursos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw/novaMatricula")
public class NovaMatriculaController {
	
private CursoRepository cursoRepository;
private TurmaRepository turmaRepository;
private JovemRepository jovemRepository;
private EnumService enumService;
	
	@Autowired
	public void MatriculaEndPoint(
			CursoRepository cursoRepository,
			TurmaRepository turmaRepository,
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.cursoRepository = cursoRepository;
		this.turmaRepository = turmaRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/{id}")
	public ModelAndView matriculaCurso(Matricula matricula, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/matriculas/matricula");
		modelAndView.addObject("matricula", matricula);
		Curso curso = cursoRepository.findOne(id);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("turmas", turmaRepository.findAllByCurso(curso));
		modelAndView.addObject("jovens", jovemRepository.findAll());
		List<String> statusDeMatricula = this.enumService.carregarStatusDeMatricula();
		modelAndView.addObject("statusDeMatricula", statusDeMatricula);
		return modelAndView;
	}
	
}
