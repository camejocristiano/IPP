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

import br.net.ipp.daos.aprendizes.HabilidadesRepository;
import br.net.ipp.models.aprendizes.Habilidades;

@Controller
@Transactional
@RequestMapping("/habilidades")
public class HabilidadesController {

	private HabilidadesRepository habilidadesRepository;
	
	@Autowired
	public void HabilidadesEndPoint(
			HabilidadesRepository habilidadesRepository
			) {
		this.habilidadesRepository = habilidadesRepository;
	}

	@GetMapping("/form")
	public ModelAndView habilidades(Habilidades habilidades) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
		modelAndView.addObject("habilidades", habilidades);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Habilidades habilidades, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("habilidades", habilidades);
		} else {
			habilidadesRepository.save(habilidades);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("habilidades", habilidades);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
		Habilidades habilidades = habilidadesRepository.findOne(id);
		modelAndView.addObject("habilidades", habilidades);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Habilidades habilidades, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("habilidades", habilidades);
		} else {
			habilidadesRepository.save(habilidades);
			modelAndView.addObject("habilidades", habilidades);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
