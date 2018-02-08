package br.net.ipp.controllers.cursos;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw/turmaForm")
public class TurmaFormController {
	
private CursoRepository cursoRepository;
private UsuarioRepository usuarioRepository;
private EnumService enumService;
	
	@Autowired
	public TurmaFormController(
			CursoRepository cursoRepository,
			UsuarioRepository usuarioRepository,
			EnumService enumService
			) {
		this.cursoRepository = cursoRepository;
		this.usuarioRepository = usuarioRepository;
		this.enumService = new EnumService();
	}
	
	@GetMapping("/{id}")
	public ModelAndView turma(Turma turma, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/turmas/turma");
		Curso curso = cursoRepository.findOne(id);
		List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
		modelAndView.addObject("diaDaSemana", diaDaSemana);
		List<String> tiposTurma = this.enumService.carregarTiposTurmaEnum();
		modelAndView.addObject("tiposTurma", tiposTurma);
		turma = new Turma();
		turma.setCurso(curso);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("turma", turma);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}

}
