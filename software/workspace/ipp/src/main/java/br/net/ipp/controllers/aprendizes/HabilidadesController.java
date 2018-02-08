package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.HabilidadesRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.models.aprendizes.Habilidades;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class HabilidadesController {

	private HabilidadesRepository habilidadesRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	
	@Autowired
	public HabilidadesController(
			HabilidadesRepository habilidadesRepository,
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.habilidadesRepository = habilidadesRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/habilidade/form")
	public ModelAndView habilidades(Habilidades habilidades) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
		modelAndView.addObject("habilidades", habilidades);
		List<String> habilidadesManuais = this.enumService.carregarHabilidadesManuais();
		modelAndView.addObject("habilidadesManuais", habilidadesManuais);
		return modelAndView;
	}
	
	@GetMapping("/habilidade/form/{id}")
	public ModelAndView habilidadesJovem(Habilidades habilidades, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
		modelAndView.addObject("habilidades", habilidades);
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		List<String> habilidadesManuais = this.enumService.carregarHabilidadesManuais();
		modelAndView.addObject("habilidadesManuais", habilidadesManuais);
		return modelAndView;
	}

	@PostMapping("/habilidade")
	public ModelAndView save(@Valid Habilidades habilidades, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
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

	@GetMapping("/habilidade/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
		Habilidades habilidades = habilidadesRepository.findOne(id);
		modelAndView.addObject("habilidades", habilidades);
		List<String> habilidadesManuais = this.enumService.carregarHabilidadesManuais();
		modelAndView.addObject("habilidadesManuais", habilidadesManuais);
		return modelAndView;
	}
	
	@PostMapping("/habilidade/{id}")
	public ModelAndView update(@Valid Habilidades habilidades, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
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
	
	@GetMapping("/habilidadeJovem/{id}")
	public ModelAndView habilidadeJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (habilidadesRepository.findByJovem(jovem) != null) {
			modelAndView.addObject("habilidades", habilidadesRepository.findByJovem(jovem));			
		} else {
			Habilidades habilidades = new Habilidades();
			modelAndView.addObject("habilidades", habilidades);
		}
		List<String> habilidadesManuais = this.enumService.carregarHabilidadesManuais();
		modelAndView.addObject("habilidadesManuais", habilidadesManuais);
		return modelAndView;
	}
	
}
