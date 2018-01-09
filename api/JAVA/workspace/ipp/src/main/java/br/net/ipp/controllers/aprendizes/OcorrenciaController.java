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

import br.net.ipp.daos.aprendizes.OcorrenciaRepository;
import br.net.ipp.models.aprendizes.Ocorrencia;

@Controller
@Transactional
@RequestMapping("/ocorrencias")
public class OcorrenciaController {

	private OcorrenciaRepository ocorrenciaRepository;
	
	@Autowired
	public void OcorrenciaEndPoint(
			OcorrenciaRepository ocorrenciaRepository
			) {
		this.ocorrenciaRepository = ocorrenciaRepository;
	}

	@GetMapping("/form")
	public ModelAndView ocorrencia(Ocorrencia ocorrencia) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/ocorrencias/ocorrencia");
		modelAndView.addObject("ocorrencia", ocorrencia);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Ocorrencia ocorrencia, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("ocorrencia", ocorrencia);
		} else {
			ocorrenciaRepository.save(ocorrencia);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("ocorrencia", ocorrencia);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/ocorrencias/ocorrencia");
		Ocorrencia ocorrencia = ocorrenciaRepository.findOne(id);
		modelAndView.addObject("ocorrencia", ocorrencia);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Ocorrencia ocorrencia, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("ocorrencia", ocorrencia);
		} else {
			ocorrenciaRepository.save(ocorrencia);
			modelAndView.addObject("ocorrencia", ocorrencia);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
