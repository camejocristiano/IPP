package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.EscolaridadeRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.Escolaridade;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/sw")
public class EscolaridadeController {

	private EscolaridadeRepository escolaridadeRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public void EscolaridadeEndPoint(
			EscolaridadeRepository escolaridadeRepository,
			JovemRepository jovemRepository
			) {
		this.escolaridadeRepository = escolaridadeRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/escolaridade/form")
	public ModelAndView escolaridadeNull(Jovem jovem) {
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/form");
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}
	
	@GetMapping("/escolaridade/form/{id}")
	public ModelAndView escolaridade(Escolaridade escolaridade, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("escolaridade", escolaridade);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping("/escolaridade")
	public ModelAndView save(@Valid Escolaridade escolaridade, BindingResult bindingResult) {
		Long id = escolaridade.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("escolaridade", escolaridade);
		} else {
			escolaridadeRepository.save(escolaridade);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("escolaridade", escolaridade);
		}		
		return modelAndView;
	}

	@GetMapping("/escolaridade/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
		Escolaridade escolaridade = escolaridadeRepository.findOne(id);
		modelAndView.addObject("escolaridade", escolaridade);
		return modelAndView;
	}
	
	@PostMapping("/escolaridade/{id}")
	public ModelAndView update(@Valid Escolaridade escolaridade, BindingResult bindingResult) {
		Long id = escolaridade.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("escolaridade", escolaridade);
		} else {
			escolaridadeRepository.save(escolaridade);
			modelAndView.addObject("escolaridade", escolaridade);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	@GetMapping("/escolaridadeJovem/{id}")
	public ModelAndView escolaridadeJovem(@PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (escolaridadeRepository.findByJovem(jovem) != null) {
			modelAndView.addObject("escolaridade", escolaridadeRepository.findByJovem(jovem));
		} else {
			Escolaridade escolaridade = new Escolaridade();
			modelAndView.addObject("escolaridade", escolaridade);
		}
		return modelAndView;
	}
	
}
