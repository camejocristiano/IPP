package br.net.ipp.controllers.cursos;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
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
private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void MatriculaEndPoint(
			MatriculaRepository matriculaRepository,
			CursoRepository cursoRepository,
			TurmaRepository turmaRepository,
			JovemRepository jovemRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository
			) {
		this.matriculaRepository = matriculaRepository;
		this.cursoRepository = cursoRepository;
		this.turmaRepository = turmaRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/matriculas")
	public ModelAndView matriculas(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isMatriculaListar() == true && usuarioSessao.isAdmin() == true) {
			modelAndView = new ModelAndView("cursos/matriculas/matriculas");
			modelAndView.addObject("matriculas", matriculaRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/matricula")
	public ModelAndView save(@Valid Matricula matricula, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isMatriculaCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/matriculas/matricula");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("matricula", matricula);
			} else {
				matriculaRepository.save(matricula);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("matricula", matricula);
			}		
		} else {
			Turma turma = turmaRepository.findOne(matricula.getTurma().getId());
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/matricula/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isMatriculaVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/matriculas/matricula");
			Matricula matricula = matriculaRepository.findOne(id);
			modelAndView.addObject("matricula", matricula);
			modelAndView.addObject("cursos", cursoRepository.findAll());
			modelAndView.addObject("turmas", turmaRepository.findAll());
			modelAndView.addObject("jovens", jovemRepository.findAll());
			List<String> statusDeMatricula = this.enumService.carregarStatusDeMatricula();
			modelAndView.addObject("statusDeMatricula", statusDeMatricula);
		} else {
			Matricula matricula = matriculaRepository.findOne(id);
			Turma turma = turmaRepository.findOne(matricula.getTurma().getId());
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/matricula/{id}")
	public ModelAndView update(@Valid Matricula matricula, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isMatriculaEditar() == true) {
			modelAndView = new ModelAndView("cursos/matriculas/matricula");
			Turma turma = turmaRepository.findOne(matricula.getTurma().getId());
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("matricula", matricula);
				modelAndView.addObject("curso", curso);
				modelAndView.addObject("turmas", turmaRepository.findAllByCurso(curso));
				modelAndView.addObject("jovens", jovemRepository.findAll());
				List<String> statusDeMatricula = this.enumService.carregarStatusDeMatricula();
				modelAndView.addObject("statusDeMatricula", statusDeMatricula);
			} else {
				matriculaRepository.save(matricula);
				modelAndView.addObject("matricula", matricula);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("curso", curso);
				modelAndView.addObject("turmas", turmaRepository.findAllByCurso(curso));
				modelAndView.addObject("jovens", jovemRepository.findAll());
				List<String> statusDeMatricula = this.enumService.carregarStatusDeMatricula();
				modelAndView.addObject("statusDeMatricula", statusDeMatricula);
			}	
		} else {
			Turma turma = turmaRepository.findOne(matricula.getTurma().getId());
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/matriculas/{id}")
	public ModelAndView matriculasCurso(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isMatriculaListar() == true) {
			modelAndView = new ModelAndView("cursos/matriculas/matriculas");
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
		} else {
			Curso curso = cursoRepository.findOne(id);
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/matriculasJovem/{id}")
	public ModelAndView matriculasJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isMatriculaListar() == true) {
			modelAndView = new ModelAndView("aprendizes/cursos/cursos");
			Jovem jovem = jovemRepository.findOne(id);
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		} else {
			Curso curso = cursoRepository.findOne(id);
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/matriculaShow/{id}")
	public ModelAndView matriculaShow(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isMatriculaVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/cursos/matricula");
			Matricula matricula = matriculaRepository.findOne(id);
			modelAndView.addObject("matricula", matricula);
			List<String> statusDeMatricula = this.enumService.carregarStatusDeMatricula();
			modelAndView.addObject("statusDeMatricula", statusDeMatricula);
		} else {
			Matricula matricula = matriculaRepository.findOne(id);
			Turma turma = turmaRepository.findOne(matricula.getTurma().getId());
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/novaMatricula/{id}")
	public ModelAndView matriculaCurso(Matricula matricula, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isMatriculaCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/matriculas/matricula");
			modelAndView.addObject("matricula", matricula);
			Curso curso = cursoRepository.findOne(id);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("turmas", turmaRepository.findAllByCurso(curso));
			modelAndView.addObject("jovens", jovemRepository.findAll());
			List<String> statusDeMatricula = this.enumService.carregarStatusDeMatricula();
			modelAndView.addObject("statusDeMatricula", statusDeMatricula);
		} else {
			Curso curso = cursoRepository.findOne(id);
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
