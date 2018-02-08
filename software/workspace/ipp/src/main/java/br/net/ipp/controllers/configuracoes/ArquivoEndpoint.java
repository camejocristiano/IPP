package br.net.ipp.controllers.configuracoes;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.ArquivoRepository;

@Controller
@Transactional
@RequestMapping("/sw/arquivos")
public class ArquivoEndpoint {
	
	private ArquivoRepository arquivoRepository;
	
	@Autowired
	public void ArquivoEndPoint(ArquivoRepository arquivoRepository) {
		this.arquivoRepository = arquivoRepository;
	}
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/canais/canais");
		modelAndView.addObject("arquivos", arquivoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/arquivo")
	public ModelAndView agendamento() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/arquivos/arquivo");
		return modelAndView;
	}
	
	// post
	
	@GetMapping("/arquivos/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/arquivos/arquivo");
		modelAndView.addObject("arquivo", arquivoRepository.findOne(id));
		return modelAndView;
	}
	
	// put
}


