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

import br.net.ipp.daos.financeiros.ContaAReceberRepository;
import br.net.ipp.models.financeiros.ContaAReceber;

@Controller
@Transactional
@RequestMapping("/contasAReceber")
public class ContaAReceberController {

	private ContaAReceberRepository contaAReceberRepository;
	
	@Autowired
	public void ContaAReceberEndPoint(
			ContaAReceberRepository contaAReceberRepository
			) {
		this.contaAReceberRepository = contaAReceberRepository;
	}

	@GetMapping("/form")
	public ModelAndView contaAReceber(ContaAReceber contaAReceber) {
		ModelAndView modelAndView = new ModelAndView("financeiros/receber/receber");
		modelAndView.addObject("contaAReceber", contaAReceber);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid ContaAReceber contaAReceber, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("contaAReceber", contaAReceber);
		} else {
			contaAReceberRepository.save(contaAReceber);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("contaAReceber", contaAReceber);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/receber/receber");
		ContaAReceber contaAReceber = contaAReceberRepository.findOne(id);
		modelAndView.addObject("contaAReceber", contaAReceber);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid ContaAReceber contaAReceber, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("contaAReceber", contaAReceber);
		} else {
			contaAReceberRepository.save(contaAReceber);
			modelAndView.addObject("contaAReceber", contaAReceber);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
