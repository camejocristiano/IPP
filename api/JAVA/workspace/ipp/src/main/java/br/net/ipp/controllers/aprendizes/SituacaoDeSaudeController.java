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

import br.net.ipp.daos.aprendizes.SituacaoDeSaudeRepository;
import br.net.ipp.models.aprendizes.SituacaoDeSaude;

@Controller
@Transactional
@RequestMapping("/situacoesDeSaude")
public class SituacaoDeSaudeController {

	private SituacaoDeSaudeRepository situacaoDeSaudeRepository;
	
	@Autowired
	public void SituacaoDeSaudeEndPoint(
			SituacaoDeSaudeRepository situacaoDeSaudeRepository
			) {
		this.situacaoDeSaudeRepository = situacaoDeSaudeRepository;
	}

	@GetMapping("/form")
	public ModelAndView situacaoDeSaude(SituacaoDeSaude situacaoDeSaude) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/saude/saude");
		modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid SituacaoDeSaude situacaoDeSaude, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		} else {
			situacaoDeSaudeRepository.save(situacaoDeSaude);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/saude/saude");
		SituacaoDeSaude situacaoDeSaude = situacaoDeSaudeRepository.findOne(id);
		modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid SituacaoDeSaude situacaoDeSaude, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
		} else {
			situacaoDeSaudeRepository.save(situacaoDeSaude);
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
