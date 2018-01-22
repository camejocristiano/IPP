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

import br.net.ipp.daos.aprendizes.FamiliarRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.enums.EstadoCivil;
import br.net.ipp.models.aprendizes.Familiar;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/familiares")
public class FamiliarController {

	private FamiliarRepository familiarRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void FamiliarEndPoint(
			FamiliarRepository familiarRepository,
			JovemRepository jovemRepository
			) {
		this.familiarRepository = familiarRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView familiar(Familiar familiar) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiar");
		modelAndView.addObject("familiar", familiar);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView familiarJovem(Familiar familiar, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiar");
		modelAndView.addObject("familiar", familiar);
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		List<String> estadosCivis = this.carregarEstadosCivis();
		modelAndView.addObject("estadosCivis", estadosCivis);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Familiar familiar, BindingResult bindingResult) {
		Long id = familiar.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("familiar", familiar);
		} else {
			familiarRepository.save(familiar);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("familiar", familiar);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiar");
		Familiar familiar = familiarRepository.findOne(id);
		modelAndView.addObject("familiar", familiar);
		List<String> estadosCivis = this.carregarEstadosCivis();
		modelAndView.addObject("estadosCivis", estadosCivis);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Familiar familiar, BindingResult bindingResult) {
		Long id = familiar.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("familiar", familiar);
		} else {
			familiarRepository.save(familiar);
			modelAndView.addObject("familiar", familiar);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	public List<String> carregarEstadosCivis() {
		List<EstadoCivil> lista = Arrays.asList(EstadoCivil.values());
		List<String> estadosCivis = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			estadosCivis.add(lista.get(i).name());
		}
		return estadosCivis;
	}
	
}
