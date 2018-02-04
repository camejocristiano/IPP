package br.net.ipp.controllers.aprendizes;

import java.util.ArrayList;
import java.util.Arrays;
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
import br.net.ipp.enums.Periodo;
import br.net.ipp.enums.TipoDeContratacao;
import br.net.ipp.models.aprendizes.DadosFinanceiros;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/dadosFinanceiros")
public class DadosFinanceirosController {

	private DadosFinanceirosRepository dadosFinanceirosRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void DadosFinanceirosEndPoint(
			DadosFinanceirosRepository dadosFinanceirosRepository,
			JovemRepository jovemRepository
			) {
		this.dadosFinanceirosRepository = dadosFinanceirosRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView dadosFinanceiros(DadosFinanceiros dadosFinanceiros) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView dadosFinanceiros(DadosFinanceiros dadosFinanceiros, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		List<String> tiposDeContratacoes = this.carregarTipoDeContratacao();
		modelAndView.addObject("tiposDeContratacoes", tiposDeContratacoes);
		List<String> periodos = this.carregarPeriodo();
		modelAndView.addObject("periodos", periodos);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid DadosFinanceiros dadosFinanceiros, BindingResult bindingResult) {
		Long id = dadosFinanceiros.getJovem().getId();
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
		List<String> tiposDeContratacoes = this.carregarTipoDeContratacao();
		modelAndView.addObject("tiposDeContratacoes", tiposDeContratacoes);
		List<String> periodos = this.carregarPeriodo();
		modelAndView.addObject("periodos", periodos);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid DadosFinanceiros dadosFinanceiros, BindingResult bindingResult) {
		Long id = dadosFinanceiros.getJovem().getId();
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
	
	public List<String> carregarTipoDeContratacao() {
		List<TipoDeContratacao> lista = Arrays.asList(TipoDeContratacao.values());
		List<String> tiposDeContratacoes = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeContratacoes.add(lista.get(i).name());
		}
		return tiposDeContratacoes;
	}
	
	public List<String> carregarPeriodo() {
		List<Periodo> lista = Arrays.asList(Periodo.values());
		List<String> periodos = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			periodos.add(lista.get(i).name());
		}
		return periodos;
	}
}
