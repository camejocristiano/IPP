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

import br.net.ipp.daos.aprendizes.CaracteristicasDomiciliaresRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.enums.AuxilioDoGoverno;
import br.net.ipp.enums.Escolaridade;
import br.net.ipp.models.aprendizes.CaracteristicasDomiciliares;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/caracteristicasDomiciliares")
public class CaracteristicasDomiciliaresController {

	private CaracteristicasDomiciliaresRepository caracteristicasDomiciliaresRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void CaracteristicasDomiciliaresEndPoint(
			CaracteristicasDomiciliaresRepository caracteristicasDomiciliaresRepository,
			JovemRepository jovemRepository
			) {
		this.caracteristicasDomiciliaresRepository = caracteristicasDomiciliaresRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView caracteristicasDomiciliares(CaracteristicasDomiciliares caracteristicasDomiciliares) {
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens");
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView caracteristicasDomiciliaresJovem(CaracteristicasDomiciliares caracteristicasDomiciliares, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
		modelAndView.addObject("jovem", jovem);
		List<String> auxiliosDoGoverno = this.carregarAuxiliosDoGoverno();
		modelAndView.addObject("auxiliosDoGoverno", auxiliosDoGoverno);
		List<String> escolaridades = this.carregarEscolaridades();
		modelAndView.addObject("escolaridades", escolaridades);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid CaracteristicasDomiciliares caracteristicasDomiciliares, BindingResult bindingResult) {
		Long id = caracteristicasDomiciliares.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
		} else {
			caracteristicasDomiciliaresRepository.save(caracteristicasDomiciliares);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
		CaracteristicasDomiciliares caracteristicasDomiciliares = caracteristicasDomiciliaresRepository.findOne(id);
		modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
		List<String> auxiliosDoGoverno = this.carregarAuxiliosDoGoverno();
		modelAndView.addObject("auxiliosDoGoverno", auxiliosDoGoverno);
		List<String> escolaridades = this.carregarEscolaridades();
		modelAndView.addObject("escolaridades", escolaridades);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid CaracteristicasDomiciliares caracteristicasDomiciliares, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
		} else {
			caracteristicasDomiciliaresRepository.save(caracteristicasDomiciliares);
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	public List<String> carregarEscolaridades() {
		List<Escolaridade> lista = Arrays.asList(Escolaridade.values());
		List<String> escolaridades = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			escolaridades.add(lista.get(i).name());
		}
		return escolaridades;
	}
	
	public List<String> carregarAuxiliosDoGoverno() {
		List<AuxilioDoGoverno> lista = Arrays.asList(AuxilioDoGoverno.values());
		List<String> auxiliosDoGoverno = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			auxiliosDoGoverno.add(lista.get(i).name());
		}
		return auxiliosDoGoverno;
	}
	
}
