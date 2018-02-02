package br.net.ipp.controllers.empresas;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.models.empresas.Contato;

@Controller
@Transactional
@RequestMapping("/sw/contatos")
public class ContatoController {

	private ContatoRepository contatoRepository;
	
	@Autowired
	public void EmpresaEndPoint(
			ContatoRepository contatoRepository
			) {
		this.contatoRepository = contatoRepository;
	}

	@GetMapping("/form")
	public ModelAndView contato(Contato contato) {
		ModelAndView modelAndView = new ModelAndView("empresas/contatos/contato");
		modelAndView.addObject("contato", contato);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Contato contato, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Talvez o email já exista!");
			modelAndView.addObject("contato", contato);
		} else {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        contato.setPassword(passwordEncoder.encode(contato.getPassword()));
			contatoRepository.save(contato);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("contato", contato);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/contatos/contato");
		Contato contato = contatoRepository.findOne(id);
		modelAndView.addObject("contato", contato);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Contato contato, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("contato", contato);
		} else {
			contatoRepository.save(contato);
			modelAndView.addObject("contato", contato);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
