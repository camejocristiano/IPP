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

import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.models.empresas.Empresa;

@Controller
@Transactional
@RequestMapping("/sw/empresas")
public class EmpresaController {

	private EmpresaRepository empresaRepository;
	
	@Autowired
	public void EmpresaEndPoint(
			EmpresaRepository empresaRepository
			) {
		this.empresaRepository = empresaRepository;
	}

	@GetMapping("/form")
	public ModelAndView empresa(Empresa empresa) {
		ModelAndView modelAndView = new ModelAndView("empresas/empresas/empresa");
		modelAndView.addObject("empresa", empresa);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Empresa empresa, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("empresa", empresa);
		} else {
			empresaRepository.save(empresa);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("empresa", empresa);
			this.load(empresa.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/empresas/empresa");
		Empresa empresa = empresaRepository.findOne(id);
		modelAndView.addObject("empresa", empresa);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Empresa empresa, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("empresa", empresa);
		} else {
			empresaRepository.save(empresa);
			modelAndView.addObject("empresa", empresa);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
