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

import br.net.ipp.daos.cursos.ValidacaoRepository;
import br.net.ipp.models.cursos.Validacao;

@Controller
@Transactional
@RequestMapping("/validacoes")
public class ValidacaoController {

private ValidacaoRepository validacaoRepository;

	@Autowired
	public void ValidacaoEndPoint(
			ValidacaoRepository validacaoRepository
			) {
		this.validacaoRepository = validacaoRepository;
	}

	@GetMapping("/form")
	public ModelAndView validacao(Validacao validacao) {
		ModelAndView modelAndView = new ModelAndView("validacoes/validacoes/validacao");
		modelAndView.addObject("validacao", validacao);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Validacao validacao, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:");
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

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("validacoes/validacoes/validacao");
		Validacao validacao = validacaoRepository.findOne(id);
		modelAndView.addObject("validacao", validacao);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Validacao validacao, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:");
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
	
}
