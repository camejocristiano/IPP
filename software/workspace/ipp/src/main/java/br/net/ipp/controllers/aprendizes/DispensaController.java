package br.net.ipp.controllers.aprendizes;

import java.util.ArrayList;
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
import br.net.ipp.models.aprendizes.Dispensa;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class DispensaController {

	private DispensaRepository dispensaRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	
	@Autowired
	public DispensaController (
			DispensaRepository dispensaRepository,
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.dispensaRepository = dispensaRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/dispensa/form")
	public ModelAndView dispensa(Dispensa dispensa) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovens");
		return modelAndView;
	}
	
	@GetMapping("/dispensaJovem/{id}")
	public ModelAndView dispensaJovem(Dispensa dispensa, @PathVariable("id") Long id) {
		Jovem jovem = jovemRepository.findOne(id);
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
		modelAndView.addObject("dispensa", dispensa);
		modelAndView.addObject("jovem", jovem);
		List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
		modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		return modelAndView;
	}

	@PostMapping("/dispensa")
	public ModelAndView save(@Valid Dispensa dispensa, BindingResult bindingResult) {
		Long id = dispensa.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
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

	@GetMapping("/dispensa/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
		Dispensa dispensa = dispensaRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(dispensa.getJovem().getId());
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("dispensa", dispensa);
		return modelAndView;
	}
	
	@PostMapping("/dispensa/{id}")
	public ModelAndView update(@Valid Dispensa dispensa, BindingResult bindingResult) {
		Long id = dispensa.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
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
	
	@GetMapping("/dispensasJovem/{id}")
	public ModelAndView dispensasJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensas");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (dispensaRepository.findAllByJovem(jovem) != null) {
			modelAndView.addObject("dispensas", dispensaRepository.findAllByJovem(jovem));
		} else {
			List<Dispensa> dispensas = new ArrayList<Dispensa>();
			modelAndView.addObject("dispensas", dispensas);
		}
		return modelAndView;
	}
	
}
