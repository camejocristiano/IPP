package br.net.ipp.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.models.financeiros.Parametro;

@Controller
@Transactional
@RequestMapping("/sw")
public class FinanceirosController {

	
	@Autowired
	public FinanceirosController() {}
	
	@GetMapping("/financeiros")
	public ModelAndView financeiros(Parametro parametro) {
		ModelAndView modelAndView = new ModelAndView("financeiros/home");
		return modelAndView;
	}

}
