package br.net.ipp.controllers.frequencias;

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

import br.net.ipp.daos.frequencias.PIORepository;
import br.net.ipp.models.frequencias.PIO;

@Controller
@Transactional
@RequestMapping("/pios")
public class PIOController {

	private PIORepository pIORepository;
	
	@Autowired
	public void PIOEndPoint(
			PIORepository pIORepository
			) {
		this.pIORepository = pIORepository;
	}

	@GetMapping("/form")
	public ModelAndView pitEPip(PIO pio) {
		ModelAndView modelAndView = new ModelAndView("pios/pios/pio");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid PIO pio, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("pios/pios/pio");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("pio", pio);
		} else {
			pIORepository.save(pio);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("pio", pio);
			this.load(pio.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("pios/pios/pio");
		PIO pio = pIORepository.findOne(id);
		modelAndView.addObject("pio", pio);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid PIO pio, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("pios/pios/pio");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("pio", pio);
		} else {
			pIORepository.save(pio);
			modelAndView.addObject("pio", pio);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
