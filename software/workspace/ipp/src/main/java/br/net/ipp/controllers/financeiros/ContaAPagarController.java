package br.net.ipp.controllers.financeiros;

import java.util.List;

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
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class ContaAPagarController {

	private ContaAPagarRepository contaAPagarRepository;
	private EnumService enumService;
	
	@Autowired
	public void ContaAPagarEndPoint(
			ContaAPagarRepository contaAPagarRepository,
			EnumService enumService
			) {
		this.contaAPagarRepository = contaAPagarRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/contas")
	public ModelAndView contas() {
		ModelAndView modelAndView = new ModelAndView("financeiros/pagar/contas");
		modelAndView.addObject("contas", contaAPagarRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/conta/form")
	public ModelAndView contaAPagar(ContaAPagar contaAPagar) {
		ModelAndView modelAndView = new ModelAndView("financeiros/pagar/pagar");
		modelAndView.addObject("contaAPagar", contaAPagar);
		List<String> tiposDeParceria = this.enumService.carregarTiposDeParceria();
		modelAndView.addObject("tiposDeParceria", tiposDeParceria);
		List<String> regioes = this.enumService.carregarRegioes();
		modelAndView.addObject("regioes", regioes);
		List<String> tiposDeEmpresa = this.enumService.carregarTiposDeEmpresa();
		modelAndView.addObject("tiposDeEmpresa", tiposDeEmpresa);
		return modelAndView;
	}

	@PostMapping("/conta")
	public ModelAndView save(@Valid ContaAPagar contaAPagar, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/financeiros/");
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

	@GetMapping("/conta/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/pagar/pagar");
		ContaAPagar contaAPagar = contaAPagarRepository.findOne(id);
		modelAndView.addObject("contaAPagar", contaAPagar);
		List<String> tiposDeParceria = this.enumService.carregarTiposDeParceria();
		modelAndView.addObject("tiposDeParceria", tiposDeParceria);
		List<String> regioes = this.enumService.carregarRegioes();
		modelAndView.addObject("regioes", regioes);
		List<String> tiposDeEmpresa = this.enumService.carregarTiposDeEmpresa();
		modelAndView.addObject("tiposDeEmpresa", tiposDeEmpresa);
		return modelAndView;
	}
	
	@PostMapping("/conta/{id}")
	public ModelAndView update(@Valid ContaAPagar contaAPagar, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/financeiros/");
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
