package br.net.ipp.controllers.empresas;

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

import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
@Transactional
@RequestMapping("/representantes")
public class RepresentanteLegalController {

	private RepresentanteLegalRepository representanteLegalRepository;
	
	@Autowired
	public void EmpresaEndPoint(
			RepresentanteLegalRepository representanteLegalRepository
			) {
		this.representanteLegalRepository = representanteLegalRepository;
	}

	@GetMapping("/form")
	public ModelAndView representanteLegal(RepresentanteLegal representanteLegal) {
		ModelAndView modelAndView = new ModelAndView("empresas/representantes/representante");
		modelAndView.addObject("representanteLegal", representanteLegal);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid RepresentanteLegal representanteLegal, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("representanteLegal", representanteLegal);
		} else {
			representanteLegalRepository.save(representanteLegal);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("representanteLegal", representanteLegal);
			this.load(representanteLegal.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/representantes/representante");
		RepresentanteLegal representanteLegal = representanteLegalRepository.findOne(id);
		modelAndView.addObject("representanteLegal", representanteLegal);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid RepresentanteLegal representanteLegal, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("representanteLegal", representanteLegal);
		} else {
			representanteLegalRepository.save(representanteLegal);
			modelAndView.addObject("representanteLegal", representanteLegal);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
