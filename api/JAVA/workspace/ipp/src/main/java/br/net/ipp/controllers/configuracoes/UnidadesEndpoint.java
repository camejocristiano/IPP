package br.net.ipp.controllers.configuracoes;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.models.configuracoes.Unidade;

@Controller
public class UnidadesEndpoint {

	private UnidadeRepository unidadeDAO;

	@Autowired
	public void UnidadeEndPoint(UnidadeRepository unidadeDAO) {
		this.unidadeDAO = unidadeDAO;
	}

	@GetMapping("unidades")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/unidades/unidades");
		modelAndView.addObject("unidades", unidadeDAO.findAll());
		return modelAndView;
	}

	@GetMapping("/unidade")
	public ModelAndView unidade() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/unidades/unidade");
		return modelAndView;

	}

	@PostMapping("/unidades")
	public ModelAndView save(@Valid Unidade unidade) {
		ModelAndView modelAndView = null;
		String email = unidade.getEmail();
		unidadeDAO.save(unidade);	
		Unidade uni = unidadeDAO.findByEmail(email);
		if (uni != null) {
			modelAndView = new ModelAndView("configuracoes/unidades/unidade");
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("unidade", uni);
		} else {
			modelAndView = new ModelAndView("configuracoes/unidades/unidades");			
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("unidades", unidadeDAO.findAll());
		}		
		return modelAndView;
	}

	@GetMapping("/unidades/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/unidades/unidade");
		modelAndView.addObject("unidade", unidadeDAO.findOne(id));
		return modelAndView;
	}
	
	@PostMapping("/unidades/{id}")
	public ModelAndView update(@Valid Unidade unidade) {
		ModelAndView modelAndView = null;
		String email = unidade.getEmail();
		unidadeDAO.save(unidade);	
		Unidade uni = unidadeDAO.findByEmail(email);
		if (uni != null) {
			modelAndView = new ModelAndView("configuracoes/unidades/unidade");
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("unidade", uni);
		} else {
			modelAndView = new ModelAndView("configuracoes/unidades/unidades");			
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("unidades", unidadeDAO.findAll());
		}		
		return modelAndView;

	}

}
