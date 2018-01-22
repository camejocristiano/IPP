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

import br.net.ipp.daos.aprendizes.AvaliacaoPIORepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.enums.Periodo;
import br.net.ipp.enums.TipoDeContratacao;
import br.net.ipp.models.aprendizes.AvaliacaoPIO;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/avaliacoesPIOs")
public class AvaliacaoPIOController {

	private AvaliacaoPIORepository avaliacaoPIORepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void AvaliacaoPIOEndPoint(
			AvaliacaoPIORepository avaliacaoPIORepository,
			JovemRepository jovemRepository
			) {
		this.avaliacaoPIORepository = avaliacaoPIORepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView avaliacaoPIO(AvaliacaoPIO avaliacaoPIO) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/pios/pio");
		modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView avaliacaoPIO(AvaliacaoPIO avaliacaoPIO, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/pios/pio");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid AvaliacaoPIO avaliacaoPIO, BindingResult bindingResult) {
		Long id = avaliacaoPIO.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
		} else {
			avaliacaoPIORepository.save(avaliacaoPIO);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
		AvaliacaoPIO avaliacaoPIO = avaliacaoPIORepository.findOne(id);
		modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid AvaliacaoPIO avaliacaoPIO, BindingResult bindingResult) {
		Long id = avaliacaoPIO.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
		} else {
			avaliacaoPIORepository.save(avaliacaoPIO);
			modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
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
