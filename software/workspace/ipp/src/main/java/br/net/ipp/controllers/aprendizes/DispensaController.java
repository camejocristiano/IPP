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

import br.net.ipp.daos.aprendizes.DispensaRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.enums.MotivoDaDispensa;
import br.net.ipp.models.aprendizes.Dispensa;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/dispensas")
public class DispensaController {

	private DispensaRepository dispensaRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void DispensaEndPoint(
			DispensaRepository dispensaRepository,
			JovemRepository jovemRepository
			) {
		this.dispensaRepository = dispensaRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView dispensa(Dispensa dispensa) {
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens");
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView dispensaJovem(Dispensa dispensa, @PathVariable("id") Long id) {
		Jovem jovem = jovemRepository.findOne(id);
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
		modelAndView.addObject("dispensa", dispensa);
		modelAndView.addObject("jovem", jovem);
		List<String> motivosDaDispensa = this.carregarMotivoDaDispensa();
		modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Dispensa dispensa, BindingResult bindingResult) {
		Long id = dispensa.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("dispensa", dispensa);
		} else {
			dispensaRepository.save(dispensa);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("dispensa", dispensa);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
		Dispensa dispensa = dispensaRepository.findOne(id);
		modelAndView.addObject("dispensa", dispensa);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Dispensa dispensa, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("dispensa", dispensa);
		} else {
			dispensaRepository.save(dispensa);
			modelAndView.addObject("dispensa", dispensa);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	public List<String> carregarMotivoDaDispensa() {
		List<MotivoDaDispensa> lista = Arrays.asList(MotivoDaDispensa.values());
		List<String> motivoDaDispensa = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			motivoDaDispensa.add(lista.get(i).name());
		}
		return motivoDaDispensa;
	}
	
}
