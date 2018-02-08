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

import br.net.ipp.daos.cursos.ArcoOcupacionalRepository;
import br.net.ipp.daos.cursos.CBORepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.models.cursos.CBO;
import br.net.ipp.models.cursos.Curso;

@Controller
@Transactional
@RequestMapping("/sw")
public class CBOController {

private CBORepository cboRepository;
private ArcoOcupacionalRepository arcoOcupacionalRepository;
private CursoRepository cursoRepository;

	@Autowired
	public CBOController(
			CBORepository cboRepository,
			CursoRepository cursoRepository,
			ArcoOcupacionalRepository arcoOcupacionalRepository
			) {
		this.cboRepository = cboRepository;
		this.cursoRepository = cursoRepository;
		this.arcoOcupacionalRepository = arcoOcupacionalRepository;
	}

	@GetMapping("/cbos")
	public ModelAndView cbos() {
		ModelAndView modelAndView = new ModelAndView("cursos/cbos/cbos");
		modelAndView.addObject("cbos", cboRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/cbos/form")
	public ModelAndView cbo(CBO cbo) {
		ModelAndView modelAndView = new ModelAndView("cursos/cbos/cbo");
		modelAndView.addObject("cbo", cbo);
		return modelAndView;
	}
	
	@GetMapping("/cbos/form/{id}")
	public ModelAndView cboCurso(CBO cbo, @PathVariable Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/cbos/cbo");
		Curso curso = cursoRepository.findOne(id);
		modelAndView.addObject("cbo", cbo);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("arcosOcupacionais", arcoOcupacionalRepository.findAll());
		return modelAndView;
	}

	@PostMapping("/cbos")
	public ModelAndView save(@Valid CBO cbo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/cursos/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("cbo", cbo);
		} else {
			cboRepository.save(cbo);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("cbo", cbo);
		}		
		return modelAndView;
	}

	@GetMapping("/cbos/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/cbos/cbo");
		CBO cbo = cboRepository.findOne(id);
		modelAndView.addObject("cbo", cbo);
		return modelAndView;
	}
	
	@PostMapping("/cbos/{id}")
	public ModelAndView update(@Valid CBO cbo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/cursos/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("cbo", cbo);
		} else {
			cboRepository.save(cbo);
			modelAndView.addObject("cbo", cbo);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
