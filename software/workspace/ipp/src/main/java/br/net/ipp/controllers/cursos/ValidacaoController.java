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
import br.net.ipp.daos.cursos.ValidacaoRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Validacao;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class ValidacaoController {

private ValidacaoRepository validacaoRepository;
private CursoRepository cursoRepository;
private EnumService enumService;
private UsuarioRepository usuarioRepository;

	@Autowired
	public void ValidacaoEndPoint(
			ValidacaoRepository validacaoRepository,
			EnumService enumService,
			CursoRepository cursoRepository,
			UsuarioRepository usuarioRepository
			) {
		this.validacaoRepository = validacaoRepository;
		this.enumService = new EnumService();
		this.cursoRepository = cursoRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/validacoes")
	public ModelAndView validacoes(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isValidacaoListar() == true) {
			if (usuarioSessao.isAdmin() == true) {
				modelAndView = new ModelAndView("cursos/validacoes/validacoes");
				modelAndView.addObject("validacoes", validacaoRepository.findAll());
			} else {
				modelAndView = new ModelAndView("redirect:/sw/homeCursos");
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/validacao")
	public ModelAndView save(@Valid Validacao validacao, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isValidacaoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/validacoes/validacao");
			if (bindingResult.hasErrors()) {
				Curso curso = cursoRepository.findOne(validacao.getCurso().getId());
				modelAndView.addObject("curso", curso);
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("validacao", validacao);
			} else {
				validacaoRepository.save(validacao);
				Curso curso = cursoRepository.findOne(validacao.getCurso().getId());
				modelAndView.addObject("curso", curso);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("validacao", validacao);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/loadValidacao/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isValidacaoVisualizar() == true) {
			Validacao validacao = validacaoRepository.findOne(id);
			modelAndView = new ModelAndView("cursos/validacoes/validacao");
			Curso curso = cursoRepository.findOne(validacao.getCurso().getId());
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("validacao", validacao);
			List<String> tiposDeValidacao = this.enumService.carregarTiposDeValidacao();
			modelAndView.addObject("tiposDeValidacao", tiposDeValidacao);
			List<String> statusValidacao = this.enumService.carregarStatusValidacao();
			modelAndView.addObject("statusValidacao", statusValidacao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/validacao/{id}")
	public ModelAndView update(@Valid Validacao validacao, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isValidacaoEditar() == true) {
			modelAndView = new ModelAndView("cursos/validacoes/validacao");
			if (bindingResult.hasErrors()) {
				Curso curso = cursoRepository.findOne(validacao.getCurso().getId());
				modelAndView.addObject("curso", curso);
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("validacao", validacao);
			} else {
				validacaoRepository.save(validacao);
				Curso curso = cursoRepository.findOne(validacao.getCurso().getId());
				modelAndView.addObject("curso", curso);
				modelAndView.addObject("validacao", validacao);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/validacoesCurso/{id}")
	public ModelAndView validacoesCurso(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isValidacaoListar() == true) {
			Curso curso = cursoRepository.findOne(id);
			modelAndView = new ModelAndView("cursos/validacoes/validacoes");
			modelAndView.addObject("validacoes", validacaoRepository.findByCurso(curso));
			modelAndView.addObject("curso", curso);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/validacaoCurso/{id}")
	public ModelAndView validacaoCurso(Validacao validacao, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isValidacaoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/validacoes/validacao");
			Curso curso = cursoRepository.findOne(id);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("validacao", validacao);
			List<String> tiposDeValidacao = this.enumService.carregarTiposDeValidacao();
			modelAndView.addObject("tiposDeValidacao", tiposDeValidacao);
			List<String> statusValidacao = this.enumService.carregarStatusValidacao();
			modelAndView.addObject("statusValidacao", statusValidacao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}