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

import br.net.ipp.daos.financeiros.ContaAPagarRepository;
import br.net.ipp.models.financeiros.ContaAPagar;

@Controller
@Transactional
@RequestMapping("/contasAPagar")
public class ContaAPagarController {

	private ContaAPagarRepository contaAPagarRepository;
	
	@Autowired
	public void ContaAPagarEndPoint(
			ContaAPagarRepository contaAPagarRepository
			) {
		this.contaAPagarRepository = contaAPagarRepository;
	}

	@GetMapping("/form")
	public ModelAndView contaAPagar(ContaAPagar contaAPagar) {
		ModelAndView modelAndView = new ModelAndView("financeiros/pagar/pagar");
		modelAndView.addObject("contaAPagar", contaAPagar);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid ContaAPagar contaAPagar, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("contaAPagar", contaAPagar);
		} else {
			contaAPagarRepository.save(contaAPagar);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("contaAPagar", contaAPagar);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/pagar/pagar");
		ContaAPagar contaAPagar = contaAPagarRepository.findOne(id);
		modelAndView.addObject("contaAPagar", contaAPagar);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid ContaAPagar contaAPagar, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("contaAPagar", contaAPagar);
		} else {
			contaAPagarRepository.save(contaAPagar);
			modelAndView.addObject("contaAPagar", contaAPagar);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
