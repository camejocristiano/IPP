/*package br.net.ipp.controllers.configuracoes;

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

import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.models.configuracoes.Unidade;

@Controller
@Transactional
@RequestMapping("/sw/unidades")
public class UnidadesEndpoint2 {

	private UnidadeRepository unidadeRepository;
	
	@Autowired
	public void UnidadeEndPoint(
			UnidadeRepository unidadeRepository
			) {
		this.unidadeRepository = unidadeRepository;
	}
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/unidades/unidades");
		modelAndView.addObject("unidades", unidadeRepository.findAll());
		return modelAndView;
	}

	@GetMapping("/form")
	public ModelAndView unidade(Unidade unidade) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/unidades/unidade");
		modelAndView.addObject("unidade", unidade);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Unidade unidade, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/configuracoes/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("unidade", unidade);
		} else {
			unidadeRepository.save(unidade);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("unidade", unidade);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/unidades/unidade");
		Unidade unidade = unidadeRepository.findOne(id);
		modelAndView.addObject("unidade", unidade);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Unidade unidade, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/configuracoes/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("unidade", unidade);
		} else {
			unidadeRepository.save(unidade);
			modelAndView.addObject("unidade", unidade);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
*/