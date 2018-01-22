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

import br.net.ipp.daos.aprendizes.FichaSocialRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.enums.SituacaoDaMoradia;
import br.net.ipp.enums.TipoDeConstrucao;
import br.net.ipp.enums.TipoDeMoradia;
import br.net.ipp.models.aprendizes.FichaSocial;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/fichasSociais")
public class FichaSocialController {

	private FichaSocialRepository fichaSocialRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void FichaSocialEndPoint(
			FichaSocialRepository fichaSocialRepository,
			JovemRepository jovemRepository
			) {
		this.fichaSocialRepository = fichaSocialRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView fichaSocial(FichaSocial fichaSocial) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		modelAndView.addObject("fichaSocial", fichaSocial);
		List<String> tiposDeMoradia = this.carregarTipoMoradia();
		modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
		List<String> situacoesDeMoradia = this.carregarSituacaoDaMoradia();
		modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
		List<String> tiposDeConstrucao = this.carregarTipoDeConstrucao();
		modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView fichaSocialJovem(FichaSocial fichaSocial, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		modelAndView.addObject("fichaSocial", fichaSocial);
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		List<String> tiposDeMoradia = this.carregarTipoMoradia();
		modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
		List<String> situacoesDeMoradia = this.carregarSituacaoDaMoradia();
		modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
		List<String> tiposDeConstrucao = this.carregarTipoDeConstrucao();
		modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid FichaSocial fichaSocial, BindingResult bindingResult) {
		Long id = fichaSocial.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		} else {
			fichaSocialRepository.save(fichaSocial);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/social");
		FichaSocial fichaSocial = fichaSocialRepository.findOne(id);
		modelAndView.addObject("fichaSocial", fichaSocial);
		List<String> tiposDeMoradia = this.carregarTipoMoradia();
		modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
		List<String> situacoesDeMoradia = this.carregarSituacaoDaMoradia();
		modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
		List<String> tiposDeConstrucao = this.carregarTipoDeConstrucao();
		modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid FichaSocial fichaSocial, BindingResult bindingResult) {
		Long id = fichaSocial.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("fichaSocial", fichaSocial);
		} else {
			fichaSocialRepository.save(fichaSocial);
			modelAndView.addObject("fichaSocial", fichaSocial);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	public List<String> carregarTipoMoradia() {
		List<TipoDeMoradia> lista = Arrays.asList(TipoDeMoradia.values());
		List<String> tiposDeMoradia = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeMoradia.add(lista.get(i).name());
		}
		return tiposDeMoradia;
	}
	
	public List<String> carregarSituacaoDaMoradia() {
		List<SituacaoDaMoradia> lista = Arrays.asList(SituacaoDaMoradia.values());
		List<String> situacoesDaMoradia = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			situacoesDaMoradia.add(lista.get(i).name());
		}
		return situacoesDaMoradia;
	}
	
	public List<String> carregarTipoDeConstrucao() {
		List<TipoDeConstrucao> lista = Arrays.asList(TipoDeConstrucao.values());
		List<String> tiposDeConstrucao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeConstrucao.add(lista.get(i).name());
		}
		return tiposDeConstrucao;
	}
	
}
