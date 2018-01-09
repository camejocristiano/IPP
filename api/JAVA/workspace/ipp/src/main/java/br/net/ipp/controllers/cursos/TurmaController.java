package br.net.ipp.controllers.cursos;

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

import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.models.cursos.Turma;

@Controller
@Transactional
@RequestMapping("/turmas")
public class TurmaController {
	
private TurmaRepository turmaRepository;
	
	@Autowired
	public void TurmaEndPoint(
			TurmaRepository turmaRepository
			) {
		this.turmaRepository = turmaRepository;
	}

	@GetMapping("/form")
	public ModelAndView turma(Turma turma) {
		ModelAndView modelAndView = new ModelAndView("cursos/turmas/turma");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Turma turma, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("turma", turma);
		} else {
			turmaRepository.save(turma);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("turma", turma);
			this.load(turma.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/turmas/turma");
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("turma", turma);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Turma turma, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("turma", turma);
		} else {
			turmaRepository.save(turma);
			modelAndView.addObject("turma", turma);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
