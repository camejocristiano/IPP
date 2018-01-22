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

import br.net.ipp.daos.financeiros.BancoRepository;
import br.net.ipp.models.financeiros.Banco;

@Controller
@Transactional
@RequestMapping("/bancos")
public class BancoController {

	private BancoRepository bancoRepository;
	
	@Autowired
	public void BancoEndPoint(
			BancoRepository bancoRepository
			) {
		this.bancoRepository = bancoRepository;
	}

	@GetMapping("/form")
	public ModelAndView banco(Banco banco) {
		ModelAndView modelAndView = new ModelAndView("financeiros/bancos/banco");
		modelAndView.addObject("banco", banco);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Banco banco, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("banco", banco);
		} else {
			bancoRepository.save(banco);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("banco", banco);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/bancos/banco");
		Banco banco = bancoRepository.findOne(id);
		modelAndView.addObject("banco", banco);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Banco banco, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("banco", banco);
		} else {
			bancoRepository.save(banco);
			modelAndView.addObject("banco", banco);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
