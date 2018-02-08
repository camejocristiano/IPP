package br.net.ipp.controllers.empresas;

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

import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.SetorRepository;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Setor;

@Controller
@Transactional
@RequestMapping("/sw")
public class SetorController {

	private SetorRepository setorRepository;
	private EmpresaRepository empresaRepository;
	
	@Autowired
	public SetorController (
			SetorRepository setorRepository,
			EmpresaRepository empresaRepository
			) {
		this.setorRepository = setorRepository;
		this.empresaRepository = empresaRepository;
	}

	@GetMapping("/setor/form")
	public ModelAndView setor(Setor setor) {
		ModelAndView modelAndView = new ModelAndView("empresas/setores/setor");
		modelAndView.addObject("setor", setor);
		return modelAndView;
	}

	@PostMapping("/setor")
	public ModelAndView save(@Valid Setor setor, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/empresas");
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

	@GetMapping("/setores/{id}")
	public ModelAndView setoresEmpresa(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/setores/setores");
		Empresa empresa = empresaRepository.findOne(id);
		List<Setor> setores = setorRepository.findByEmpresa(empresa);
		modelAndView.addObject("empresa", empresa);
		modelAndView.addObject("setores", setores);
		return modelAndView;
	}
	
	@GetMapping("/setorEmpresa/{id}")
	public ModelAndView setorEmpresa(Setor setor, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/setores/setor");
		Empresa empresa = empresaRepository.findOne(id);
		modelAndView.addObject("empresa", empresa);
		modelAndView.addObject("setor", setor);
		return modelAndView;
	}
	
	@GetMapping("/setor/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/setores/setor");
		Setor setor = setorRepository.findOne(id);
		modelAndView.addObject("setor", setor);
		return modelAndView;
	}
	
	@PostMapping("/setor/{id}")
	public ModelAndView update(@Valid Setor setor, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/empresas");
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
