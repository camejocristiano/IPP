package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.DadosFinanceirosRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.DadosFinanceiros;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class DadosFinanceirosController {

	private DadosFinanceirosRepository dadosFinanceirosRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	
	@Autowired
	public DadosFinanceirosController (
			DadosFinanceirosRepository dadosFinanceirosRepository,
			JovemRepository jovemRepository,
			EnumService enumService	
			) {
		this.dadosFinanceirosRepository = dadosFinanceirosRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/dadosFinanceiros/form")
	public ModelAndView dadosFinanceiros(DadosFinanceiros dadosFinanceiros) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		return modelAndView;
	}
	
	@GetMapping("/dadosFinanceirosJovem/{id}")
	public ModelAndView dadosFinanceiros(DadosFinanceiros dadosFinanceiros, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		Jovem jovem = jovemRepository.findOne(id);
		if (dadosFinanceirosRepository.findByJovem(jovem) != null) {
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findByJovem(jovem));
		} else {
			modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		}
		List<String> tiposDeContratacoes = this.enumService.carregarTipoDeContratacao();
		modelAndView.addObject("tiposDeContratacoes", tiposDeContratacoes);
		List<String> periodos = this.enumService.carregarPeriodo();
		modelAndView.addObject("periodos", periodos);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping("/dadosFinanceiros")
	public ModelAndView save(@Valid DadosFinanceiros dadosFinanceiros, BindingResult bindingResult) {
		Long id = dadosFinanceiros.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
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

	@GetMapping("/dadosFinanceiros/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		DadosFinanceiros dadosFinanceiros = dadosFinanceirosRepository.findOne(id);
		modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		List<String> tiposDeContratacoes = this.enumService.carregarTipoDeContratacao();
		modelAndView.addObject("tiposDeContratacoes", tiposDeContratacoes);
		List<String> periodos = this.enumService.carregarPeriodo();
		modelAndView.addObject("periodos", periodos);
		return modelAndView;
	}
	
	@PostMapping("/dadosFinanceiros/{id}")
	public ModelAndView update(@Valid DadosFinanceiros dadosFinanceiros, BindingResult bindingResult) {
		Long id = dadosFinanceiros.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
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
