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

import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.daos.empresas.SetorRepository;
import br.net.ipp.models.empresas.Empresa;

@Controller
@Transactional
@RequestMapping("/sw")
public class EmpresaController {

	private EmpresaRepository empresaRepository;
	private GestorRepository gestorRepository;
	private SetorRepository setorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	
	@Autowired
	public EmpresaController(
			EmpresaRepository empresaRepository,
			GestorRepository gestorRepository,
			SetorRepository setorRepository,
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository
			) {
		this.empresaRepository = empresaRepository;
		this.gestorRepository = gestorRepository;
		this.setorRepository = setorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
	}

	@GetMapping("/empresa")
	public ModelAndView home(Empresa empresa) {
		ModelAndView modelAndView = new ModelAndView("empresas/empresas/empresa");
		modelAndView.addObject("empresa", empresa);
		return modelAndView;
	}
	
	@PostMapping("/empresa")
	public ModelAndView save(@Valid Empresa empresa, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/empresas/");
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

	@GetMapping("/empresa/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/empresas/home");
		Empresa empresa = empresaRepository.findOne(id);
		modelAndView.addObject("empresa", empresa);
		modelAndView.addObject("gestores", gestorRepository.findAll());
		modelAndView.addObject("setores", setorRepository.findAll());
		modelAndView.addObject("contatos", contatoRepository.findAll());
		modelAndView.addObject("representantes", representanteLegalRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/loadEmpresa/{id}")
	public ModelAndView loadEmpresa(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("empresas/empresas/empresa");
		Empresa empresa = empresaRepository.findOne(id);
		modelAndView.addObject("empresa", empresa);
		modelAndView.addObject("gestores", gestorRepository.findAll());
		modelAndView.addObject("setores", setorRepository.findAll());
		modelAndView.addObject("contatos", contatoRepository.findAll());
		modelAndView.addObject("representantes", representanteLegalRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/empresa/{id}")
	public ModelAndView update(@Valid Empresa empresa, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/empresas/");
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
