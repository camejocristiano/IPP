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

import br.net.ipp.daos.financeiros.VTRepository;
import br.net.ipp.models.financeiros.VT;

@Controller
@Transactional
@RequestMapping("/vts")
public class VTController {

	private VTRepository vTRepository;
	
	@Autowired
	public void VTEndPoint(
			VTRepository vTRepository
			) {
		this.vTRepository = vTRepository;
	}

	@GetMapping("/form")
	public ModelAndView vT(VT vT) {
		ModelAndView modelAndView = new ModelAndView("financeiros/vts/vt");
		modelAndView.addObject("vt", vT);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid VT vT, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("vt", vT);
		} else {
			vTRepository.save(vT);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("vt", vT);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/vts/vt");
		VT vT = vTRepository.findOne(id);
		modelAndView.addObject("vt", vT);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid VT vT, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("vt", vT);
		} else {
			vTRepository.save(vT);
			modelAndView.addObject("vt", vT);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
