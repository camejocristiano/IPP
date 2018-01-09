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

import br.net.ipp.daos.aprendizes.DispensaRepository;
import br.net.ipp.models.aprendizes.Dispensa;

@Controller
@Transactional
@RequestMapping("/dispensas")
public class DispensaController {

	private DispensaRepository dispensaRepository;
	
	@Autowired
	public void DispensaEndPoint(
			DispensaRepository dispensaRepository
			) {
		this.dispensaRepository = dispensaRepository;
	}

	@GetMapping("/form")
	public ModelAndView dispensa(Dispensa dispensa) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/dispensas/dispensa");
		modelAndView.addObject("dispensa", dispensa);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Dispensa dispensa, BindingResult bindingResult) {
		Long id = (long) 1;
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
		ModelAndView modelAndView = new ModelAndView("aprendizes/dispensas/dispensa");
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
	
}
