package br.net.ipp.controllers.cursos;

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

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class TurmaController {
	
private TurmaRepository turmaRepository;
private EnumService enumService;
private CursoRepository cursoRepository;
private UsuarioRepository usuarioRepository;
	
	@Autowired
	public TurmaController(
			TurmaRepository turmaRepository,
			EnumService enumService,
			CursoRepository cursoRepository,
			UsuarioRepository usuarioRepository
			) {
		this.turmaRepository = turmaRepository;
		this.enumService = new EnumService();
		this.cursoRepository = cursoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/turmas/{id}")
	public ModelAndView index(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isTurmaListar() == true) {
			modelAndView = new ModelAndView("cursos/turmas/turmas");
			Curso curso = cursoRepository.findOne(id);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("turmas", turmaRepository.findAllByCurso(curso));
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
		} else {
			Curso curso = cursoRepository.findOne(id);
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/turma")
	public ModelAndView save(@Valid Turma turma, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isTurmaCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/turmas/turma");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("turma", turma);
				List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
				modelAndView.addObject("diaDaSemana", diaDaSemana);
				List<String> tiposTurma = this.enumService.carregarTiposTurmaEnum();
				modelAndView.addObject("tiposTurma", tiposTurma);
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
				Curso curso = cursoRepository.findOne(turma.getCurso().getId());
				modelAndView.addObject("curso", curso);
			} else {
				turmaRepository.save(turma);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("turma", turma);
				List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
				modelAndView.addObject("diaDaSemana", diaDaSemana);
				List<String> tiposTurma = this.enumService.carregarTiposTurmaEnum();
				modelAndView.addObject("tiposTurma", tiposTurma);
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
				Curso curso = cursoRepository.findOne(turma.getCurso().getId());
				modelAndView.addObject("curso", curso);
			}		
		} else {
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/turma/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isTurmaVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/turmas/turma");
			Turma turma = turmaRepository.findOne(id);
			modelAndView.addObject("turma", turma);
			List<String> tiposTurma = this.enumService.carregarTiposTurmaEnum();
			modelAndView.addObject("tiposTurma", tiposTurma);
			List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			modelAndView.addObject("curso", curso);
		} else {
			Turma turma = turmaRepository.findOne(id);
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/turma/{id}")
	public ModelAndView update(@Valid Turma turma, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isTurmaEditar() == true) {
			modelAndView = new ModelAndView("cursos/turmas/turma");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("turma", turma);
				List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
				modelAndView.addObject("diaDaSemana", diaDaSemana);
				List<String> tiposTurma = this.enumService.carregarTiposTurmaEnum();
				modelAndView.addObject("tiposTurma", tiposTurma);
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
				Curso curso = cursoRepository.findOne(turma.getCurso().getId());
				modelAndView.addObject("curso", curso);
			} else {
				turmaRepository.save(turma);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("turma", turma);
				List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
				modelAndView.addObject("diaDaSemana", diaDaSemana);
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
				Curso curso = cursoRepository.findOne(turma.getCurso().getId());
				modelAndView.addObject("curso", curso);
			}	
		} else {
			Curso curso = cursoRepository.findOne(turma.getCurso().getId());
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/turmaForm/{id}")
	public ModelAndView turma(Turma turma, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isTurmaCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/turmas/turma");
			Curso curso = cursoRepository.findOne(id);
			List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
			List<String> tiposTurma = this.enumService.carregarTiposTurmaEnum();
			modelAndView.addObject("tiposTurma", tiposTurma);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			turma = new Turma();
			turma.setCurso(curso);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("turma", turma);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
		} else {
			Curso curso = cursoRepository.findOne(id);
			modelAndView = new ModelAndView("redirect:/sw/homeCurso/"+curso.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
