package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.DadosFinanceirosRepository;
import br.net.ipp.models.aprendizes.DadosFinanceiros;

@Controller
@Transactional
@RequestMapping("/dadosFinanceiros")
public class DadosFinanceirosController {

	private DadosFinanceirosRepository dadosFinanceirosRepository;
	
	@Autowired
	public void DadosFinanceirosEndPoint(
			DadosFinanceirosRepository dadosFinanceirosRepository
			) {
		this.dadosFinanceirosRepository = dadosFinanceirosRepository;
	}

	@GetMapping("/form")
	public ModelAndView dadosFinanceiros(DadosFinanceiros dadosFinanceiros) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid DadosFinanceiros dadosFinanceiros, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		} else {
			dadosFinanceirosRepository.save(dadosFinanceiros);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		DadosFinanceiros dadosFinanceiros = dadosFinanceirosRepository.findOne(id);
		modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid DadosFinanceiros dadosFinanceiros, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		} else {
			dadosFinanceirosRepository.save(dadosFinanceiros);
			modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
