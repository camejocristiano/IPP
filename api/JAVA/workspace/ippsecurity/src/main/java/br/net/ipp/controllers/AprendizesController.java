package br.net.ipp.controllers;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.services.CustomUserDetailService;

@Controller
@Transactional
@RequestMapping("/sw/aprendizes")
public class AprendizesController {

	private CustomUserDetailService customUserDetailService;
	private JovemRepository jovemRepository;
	
	@Autowired
	public AprendizesController(
			CustomUserDetailService customUserDetailService,
			JovemRepository jovemRepository
			) {
		this.customUserDetailService = customUserDetailService;
		this.jovemRepository = jovemRepository;
	}
	
	@GetMapping("aprendizes")
	public ModelAndView aprendizes() {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens");
		modelAndView.addObject("jovens", jovemRepository.findAll());
		return modelAndView;
	}
	
}
