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

import br.net.ipp.daos.frequencias.PAPRepository;
import br.net.ipp.models.frequencias.PAP;

@Controller
@Transactional
@RequestMapping("/paps")
public class PAPController {

	private PAPRepository pAPRepository;
	
	@Autowired
	public void PAPEndPoint(
			PAPRepository pAPRepository
			) {
		this.pAPRepository = pAPRepository;
	}

	@GetMapping("/form")
	public ModelAndView pitEPip(PAP pap) {
		ModelAndView modelAndView = new ModelAndView("paps/paps/pap");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid PAP pap, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("paps/paps/pap");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("pap", pap);
		} else {
			pAPRepository.save(pap);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("pap", pap);
			this.load(pap.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("paps/paps/pap");
		PAP pap = pAPRepository.findOne(id);
		modelAndView.addObject("pap", pap);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid PAP pap, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("paps/paps/pap");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("pap", pap);
		} else {
			pAPRepository.save(pap);
			modelAndView.addObject("pap", pap);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
