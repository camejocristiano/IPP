package br.net.ipp.controllers.cursos;

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

import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.ValidacaoRepository;
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

	@Autowired
	public void ValidacaoEndPoint(
			ValidacaoRepository validacaoRepository,
			EnumService enumService,
			CursoRepository cursoRepository
			) {
		this.validacaoRepository = validacaoRepository;
		this.enumService = new EnumService();
		this.cursoRepository = cursoRepository;
	}

	@PostMapping("/validacao")
	public ModelAndView save(@Valid Validacao validacao, BindingResult bindingResult) {
		Long idCurso = validacao.getCurso().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/cursos/"+idCurso);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("validacao", validacao);
		} else {
			validacaoRepository.save(validacao);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("validacao", validacao);
		}		
		return modelAndView;
	}
	
	@GetMapping("/loadValidacao/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		Validacao validacao = validacaoRepository.findOne(id);
		ModelAndView modelAndView = new ModelAndView("cursos/validacoes/validacao");
		modelAndView.addObject("validacao", validacao);
		List<String> tiposDeValidacao = this.enumService.carregarTiposDeValidacao();
		modelAndView.addObject("tiposDeValidacao", tiposDeValidacao);
		List<String> statusValidacao = this.enumService.carregarStatusValidacao();
		modelAndView.addObject("statusValidacao", statusValidacao);
		return modelAndView;
	}
	
	@PostMapping("/validacao/{id}")
	public ModelAndView update(@Valid Validacao validacao, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/cursos/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("validacao", validacao);
		} else {
			validacaoRepository.save(validacao);
			modelAndView.addObject("validacao", validacao);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	@GetMapping("/validacoesCurso/{id}")
	public ModelAndView validacoesCurso(@PathVariable("id") Long id) {
		Curso curso = cursoRepository.findOne(id);
		ModelAndView modelAndView = new ModelAndView("cursos/validacoes/validacoes");
		modelAndView.addObject("validacoes", validacaoRepository.findByCurso(curso));
		modelAndView.addObject("curso", curso);
		return modelAndView;
	}
	
	@GetMapping("/validacaoCurso/{id}")
	public ModelAndView validacaoCurso(Validacao validacao, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/validacoes/validacao");
		Curso curso = cursoRepository.findOne(id);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("validacao", validacao);
		List<String> tiposDeValidacao = this.enumService.carregarTiposDeValidacao();
		modelAndView.addObject("tiposDeValidacao", tiposDeValidacao);
		List<String> statusValidacao = this.enumService.carregarStatusValidacao();
		modelAndView.addObject("statusValidacao", statusValidacao);
		return modelAndView;
	}
	
}