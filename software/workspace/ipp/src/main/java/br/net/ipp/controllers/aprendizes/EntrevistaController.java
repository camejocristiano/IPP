package br.net.ipp.controllers.aprendizes;

import java.util.ArrayList;
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

import br.net.ipp.daos.aprendizes.EntrevistaRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.models.aprendizes.Entrevista;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/sw")
public class EntrevistaController {

	private EntrevistaRepository entrevistaRepository;
	private JovemRepository jovemRepository;
	private EmpresaRepository empresaRepository;
	
	@Autowired
	public EntrevistaController (
			EntrevistaRepository entrevistaRepository,
			JovemRepository jovemRepository,
			EmpresaRepository empresaRepository
			) {
		this.entrevistaRepository = entrevistaRepository;
		this.jovemRepository = jovemRepository;
		this.empresaRepository = empresaRepository;
	}

	@GetMapping("/entrevista/form")
	public ModelAndView entrevista(Entrevista entrevista) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovens");
		return modelAndView;
	}

	@GetMapping("/entrevistaJovem/{id}")
	public ModelAndView entrevistaJovem(Entrevista entrevista, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("entrevista", entrevista);
		modelAndView.addObject("empresas", empresaRepository.findAll());
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping("/entrevista")
	public ModelAndView save(@Valid Entrevista entrevista, BindingResult bindingResult) {
		Long id = entrevista.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("entrevista", entrevista);
		} else {
			entrevistaRepository.save(entrevista);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("entrevista", entrevista);
		}		
		return modelAndView;
	}

	@GetMapping("/entrevista/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
		Entrevista entrevista = entrevistaRepository.findOne(id);
		modelAndView.addObject("entrevista", entrevista);
		modelAndView.addObject("empresas", empresaRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/entrevista/{id}")
	public ModelAndView update(@Valid Entrevista entrevista, BindingResult bindingResult) {
		Long id = entrevista.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("entrevista", entrevista);
		} else {
			entrevistaRepository.save(entrevista);
			modelAndView.addObject("entrevista", entrevista);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	@GetMapping("/entrevistasJovem/{id}")
	public ModelAndView entrevistasJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevistas");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (entrevistaRepository.findAllByJovem(jovem).size() > 0) {
			modelAndView.addObject("entrevistas", entrevistaRepository.findAllByJovem(jovem));
		} else {
			List<Entrevista> entrevistas = new ArrayList<Entrevista>();
			modelAndView.addObject("entrevistas", entrevistas);
		}
		return modelAndView;
	}
	
}
