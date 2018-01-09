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

import br.net.ipp.daos.frequencias.PITEPIPRepository;
import br.net.ipp.models.frequencias.PITEPIP;

@Controller
@Transactional
@RequestMapping("/pitsepips")
public class PITEPIPController {

	private PITEPIPRepository pITEPIPRepository;
	
	@Autowired
	public void PITEPIPEndPoint(
			PITEPIPRepository pITEPIPRepository
			) {
		this.pITEPIPRepository = pITEPIPRepository;
	}

	@GetMapping("/form")
	public ModelAndView pitEPip(PITEPIP pitepip) {
		ModelAndView modelAndView = new ModelAndView("pitsepips/pitsepips/pitepip");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid PITEPIP pitepip, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("pitsepips/pitsepips/pitepip");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("pitepip", pitepip);
		} else {
			pITEPIPRepository.save(pitepip);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("pitepip", pitepip);
			this.load(pitepip.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("pitsepips/pitsepips/pitepip");
		PITEPIP pitepip = pITEPIPRepository.findOne(id);
		modelAndView.addObject("pitepip", pitepip);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid PITEPIP pitepip, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("pitsepips/pitsepips/pitepip");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("pitepip", pitepip);
		} else {
			pITEPIPRepository.save(pitepip);
			modelAndView.addObject("pitepip", pitepip);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
