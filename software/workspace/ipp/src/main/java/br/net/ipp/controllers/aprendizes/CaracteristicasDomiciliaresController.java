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

import br.net.ipp.daos.aprendizes.CaracteristicasDomiciliaresRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.CaracteristicasDomiciliares;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class CaracteristicasDomiciliaresController {

	private CaracteristicasDomiciliaresRepository caracteristicasDomiciliaresRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	
	@Autowired
	public CaracteristicasDomiciliaresController(
			CaracteristicasDomiciliaresRepository caracteristicasDomiciliaresRepository,
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.caracteristicasDomiciliaresRepository = caracteristicasDomiciliaresRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/caracteristicaDomiciliar/form")
	public ModelAndView caracteristicasDomiciliares(CaracteristicasDomiciliares caracteristicasDomiciliares) {
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens");
		return modelAndView;
	}
	
	@GetMapping("/caracteristicaDomiciliar/form/{id}")
	public ModelAndView caracteristicasDomiciliaresJovem(CaracteristicasDomiciliares caracteristicasDomiciliares, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
		modelAndView.addObject("jovem", jovem);
		List<String> auxiliosDoGoverno = this.enumService.carregarAuxiliosDoGoverno();
		modelAndView.addObject("auxiliosDoGoverno", auxiliosDoGoverno);
		List<String> escolaridades = this.enumService.carregarEscolaridades();
		modelAndView.addObject("escolaridades", escolaridades);
		return modelAndView;
	}

	@PostMapping("/caracteristicaDomiciliar")
	public ModelAndView save(@Valid CaracteristicasDomiciliares caracteristicasDomiciliares, BindingResult bindingResult) {
		Long id = caracteristicasDomiciliares.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
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

	@GetMapping("/caracteristicaDomiciliar/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
		CaracteristicasDomiciliares caracteristicasDomiciliares = caracteristicasDomiciliaresRepository.findOne(id);
		modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
		List<String> auxiliosDoGoverno = this.enumService.carregarAuxiliosDoGoverno();
		modelAndView.addObject("auxiliosDoGoverno", auxiliosDoGoverno);
		List<String> escolaridades = this.enumService.carregarEscolaridades();
		modelAndView.addObject("escolaridades", escolaridades);
		return modelAndView;
	}
	
	@PostMapping("/caracteristicaDomiciliar/{id}")
	public ModelAndView update(@Valid CaracteristicasDomiciliares caracteristicasDomiciliares, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
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
	
	@GetMapping("/caracteristicaDomiciliarJovem/{id}")
	public ModelAndView caracteristicaDomiciliarJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (caracteristicasDomiciliaresRepository.findByJovem(jovem) != null) {
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliaresRepository.findByJovem(jovem));
		} else {
			CaracteristicasDomiciliares caracteristicasDomiciliares = new CaracteristicasDomiciliares();
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
		}
		List<String> auxiliosDoGoverno = this.enumService.carregarAuxiliosDoGoverno();
		modelAndView.addObject("auxiliosDoGoverno", auxiliosDoGoverno);
		List<String> escolaridades = this.enumService.carregarEscolaridades();
		modelAndView.addObject("escolaridades", escolaridades);
		return modelAndView;
	}
	
}
