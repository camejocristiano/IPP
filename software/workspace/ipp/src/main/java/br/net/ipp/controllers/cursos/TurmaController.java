package br.net.ipp.controllers.cursos;

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

import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw/turma")
public class TurmaController {
	
private TurmaRepository turmaRepository;
private EnumService enumService;
	
	@Autowired
	public TurmaController(
			TurmaRepository turmaRepository,
			EnumService enumService
			) {
		this.turmaRepository = turmaRepository;
		this.enumService = new EnumService();
	}

	@PostMapping
	public ModelAndView save(@Valid Turma turma, BindingResult bindingResult) {
		Long id = turma.getCurso().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/cursos/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("turma", turma);
			List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
		} else {
			turmaRepository.save(turma);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("turma", turma);
			List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/turmas/turma");
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("turma", turma);
		List<String> tiposTurma = this.enumService.carregarTiposTurmaEnum();
		modelAndView.addObject("tiposTurma", tiposTurma);
		List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
		modelAndView.addObject("diaDaSemana", diaDaSemana);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Turma turma, BindingResult bindingResult) {
		Long id = turma.getCurso().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/cursos/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("turma", turma);
			List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
		} else {
			turmaRepository.save(turma);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("turma", turma);
			List<String> diaDaSemana = this.enumService.carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
		}	
		return modelAndView;
	}

	
}
