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
import br.net.ipp.daos.aprendizes.SituacaoLaboralRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.SituacaoLaboral;

@Controller
@Transactional
@RequestMapping("/sw")
public class SituacaoLaboralController {

	private SituacaoLaboralRepository situacaoLaboralRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public SituacaoLaboralController(
			SituacaoLaboralRepository situacaoLaboralRepository,
			JovemRepository jovemRepository
			) {
		this.situacaoLaboralRepository = situacaoLaboralRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/situacaoLaboral/form")
	public ModelAndView situacaoLaboral(SituacaoLaboral situacaoLaboral) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/laborais/laboral");
		modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		return modelAndView;
	}
	
	@GetMapping("/situacaoLaboral/form/{id}")
	public ModelAndView situacaoLaboralJovem(SituacaoLaboral situacaoLaboral, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/laborais/laboral");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping("/situacaoLaboral")
	public ModelAndView save(@Valid SituacaoLaboral situacaoLaboral, BindingResult bindingResult) {
		Long id = situacaoLaboral.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		} else {
			situacaoLaboralRepository.save(situacaoLaboral);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		}		
		return modelAndView;
	}

	@GetMapping("/situacaoLaboral/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/laborais/laboral");
		SituacaoLaboral situacaoLaboral = situacaoLaboralRepository.findOne(id);
		modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		return modelAndView;
	}
	
	@PostMapping("/situacaoLaboral/{id}")
	public ModelAndView update(@Valid SituacaoLaboral situacaoLaboral, BindingResult bindingResult) {
		Long id = situacaoLaboral.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		} else {
			situacaoLaboralRepository.save(situacaoLaboral);
			modelAndView.addObject("situacaoLaboral", situacaoLaboral);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	@GetMapping("/situacaoLaboralJovem/{id}")
	public ModelAndView situacaoLaboralJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/laborais/laboral");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (situacaoLaboralRepository.findByJovem(jovem) != null) {
			modelAndView.addObject("situacaoLaboral", situacaoLaboralRepository.findByJovem(jovem));
		} else {
			SituacaoLaboral situacaoLaboral = new SituacaoLaboral();
			modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		}
		return modelAndView;
	}
	
}
