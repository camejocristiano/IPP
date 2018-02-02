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

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/sw/jovens")
public class JovemController {

	private JovemRepository jovemRepository;
	@Autowired

	public void JovemEndPoint(
			JovemRepository jovemRepository
			) {
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/form")
	public ModelAndView jovem(Jovem jovem) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Jovem jovem, BindingResult bindingResult) {
		Long id = null;
		ModelAndView modelAndView = null;
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("redirect:/jovens/");
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("jovem", jovem);
		} else {
			jovemRepository.save(jovem);
			Jovem jov = jovemRepository.findByUsername(jovem.getUsername());
			id = jov.getId();
			modelAndView = new ModelAndView("redirect:/jovens/"+id);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("jovem", jovem);		
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Jovem jovem, BindingResult bindingResult) {
		Long id = jovem.getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("jovem", jovem);
		} else {
			jovemRepository.save(jovem);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("jovem", jovem);
		}	
		return modelAndView;
	}

}
