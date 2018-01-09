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

import br.net.ipp.daos.aprendizes.HistoricoRepository;
import br.net.ipp.models.aprendizes.Historico;

@Controller
@Transactional
@RequestMapping("/historicos")
public class HistoricoController {

	private HistoricoRepository historicoRepository;
	
	@Autowired
	public void HistoricoEndPoint(
			HistoricoRepository historicoRepository
			) {
		this.historicoRepository = historicoRepository;
	}

	@GetMapping("/form")
	public ModelAndView historico(Historico historico) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/historico");
		modelAndView.addObject("historico", historico);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Historico historico, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("historico", historico);
		} else {
			historicoRepository.save(historico);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("historico", historico);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/historicos/historico");
		Historico historico = historicoRepository.findOne(id);
		modelAndView.addObject("historico", historico);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Historico historico, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("historico", historico);
		} else {
			historicoRepository.save(historico);
			modelAndView.addObject("historico", historico);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
