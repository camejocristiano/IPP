package br.net.ipp.controllers.financeiros;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;

@Controller
@Transactional
@RequestMapping("/sw")
public class VTController {

	private JovemRepository jovemRepository;
	
	@Autowired
	public void VTEndPoint(
			JovemRepository jovemRepository
			) {
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/vts")
	public ModelAndView vTs() {
		ModelAndView modelAndView = new ModelAndView("financeiros/vts/vts");
		modelAndView.addObject("jovens", jovemRepository.findAll());
		return modelAndView;
	}
	
/*	@GetMapping("/vt/form")
	public ModelAndView vT(VT vT) {
		ModelAndView modelAndView = new ModelAndView("financeiros/vts/vt");
		modelAndView.addObject("vt", vT);
		return modelAndView;
	}

	@PostMapping("/vt")
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
	}*/

	@GetMapping("/vt/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/vts/vt");
		modelAndView.addObject("jovem", jovemRepository.findOne(id));
		return modelAndView;
	}
	
	/*@PostMapping("/vt/{id}")
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
	}*/
	
}
