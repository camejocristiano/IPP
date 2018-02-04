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

import br.net.ipp.daos.empresas.SetorRepository;
import br.net.ipp.models.empresas.Setor;

@Controller
@Transactional
@RequestMapping("/setores")
public class SetorController {

	private SetorRepository setorRepository;
	
	@Autowired
	public void SetorEndPoint(
			SetorRepository setorRepository
			) {
		this.setorRepository = setorRepository;
	}

	@GetMapping("/form")
	public ModelAndView setor(Setor setor) {
		ModelAndView modelAndView = new ModelAndView("empresas/setores/setor");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Setor setor, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("setor", setor);
		} else {
			setorRepository.save(setor);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("setor", setor);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/setores/setor");
		Setor setor = setorRepository.findOne(id);
		modelAndView.addObject("setor", setor);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Setor setor, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("setor", setor);
		} else {
			setorRepository.save(setor);
			modelAndView.addObject("setor", setor);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
