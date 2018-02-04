package br.net.ipp.controllers.financeiros;

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

import br.net.ipp.daos.financeiros.VRRepository;
import br.net.ipp.models.financeiros.VR;

@Controller
@Transactional
@RequestMapping("/vrs")
public class VRController {

	private VRRepository vRRepository;
	
	@Autowired
	public void VREndPoint(
			VRRepository vRRepository
			) {
		this.vRRepository = vRRepository;
	}

	@GetMapping("/form")
	public ModelAndView vR(VR vR) {
		ModelAndView modelAndView = new ModelAndView("financeiros/vrs/vr");
		modelAndView.addObject("vr", vR);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid VR vR, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("vr", vR);
		} else {
			vRRepository.save(vR);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("vr", vR);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/vrs/vr");
		VR vR = vRRepository.findOne(id);
		modelAndView.addObject("vr", vR);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid VR vR, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("vr", vR);
		} else {
			vRRepository.save(vR);
			modelAndView.addObject("vr", vR);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
