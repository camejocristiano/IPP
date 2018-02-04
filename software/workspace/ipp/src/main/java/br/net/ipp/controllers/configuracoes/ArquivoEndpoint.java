package br.net.ipp.controllers.configuracoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.ArquivoRepository;

@RestController
public class ArquivoEndpoint {
	
	private ArquivoRepository arquivoDAO;
	
	@Autowired
	public void ArquivoEndPoint(ArquivoRepository arquivoDAO) {
		this.arquivoDAO = arquivoDAO;
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
		modelAndView.addObject("arquivo", arquivoDAO.findOne(id));
		return modelAndView;
	}
	
	// put
}


