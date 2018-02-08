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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.cursos.ArcoOcupacionalRepository;
import br.net.ipp.daos.cursos.CBORepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.models.cursos.ArcoOcupacional;
import br.net.ipp.models.cursos.CBO;
import br.net.ipp.models.cursos.Curso;

@Controller
@Transactional
@RequestMapping("/sw")
public class ArcoOcupacionalController {

private ArcoOcupacionalRepository arcoOcupacionalRepository;
private CursoRepository cursoRepository;
private CBORepository cBORepository;

	@Autowired
	public void ArcoOcupacionalEndPoint(
			ArcoOcupacionalRepository arcoOcupacionalRepository,
			CursoRepository cursoRepository,
			CBORepository cBORepository
			) {
		this.arcoOcupacionalRepository = arcoOcupacionalRepository;
		this.cursoRepository = cursoRepository;
		this.cBORepository = cBORepository;
	}

	@GetMapping("/arco/form")
	public ModelAndView arcoOcupacional(ArcoOcupacional arcoOcupacional) {
		ModelAndView modelAndView = new ModelAndView("cursos/arcos/arco");
		modelAndView.addObject("arcoOcupacional", arcoOcupacional);
		modelAndView.addObject("cbos", cBORepository.findAll());
		return modelAndView;
	}

	@GetMapping("/arcos")
	public ModelAndView arcos() {
		ModelAndView modelAndView = new ModelAndView("cursos/arcos/arcos");
		modelAndView.addObject("arcos", arcoOcupacionalRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/arco/form/{id}")
	public ModelAndView arcoOcupacionalCurso(ArcoOcupacional arcoOcupacional, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/arcos/arco");
		Curso curso = cursoRepository.findOne(id);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("arcoOcupacional", arcoOcupacional);
		modelAndView.addObject("cbos", cBORepository.findAll());
		return modelAndView;
	}

	@PostMapping("/arco")
	public ModelAndView save(@Valid ArcoOcupacional arcoOcupacional, BindingResult bindingResult, @RequestParam("curso") String curso) {
		Long idCurso = Long.parseLong(curso.toString());
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos/"+idCurso);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("arcoOcupacional", arcoOcupacional);
		} else {
			arcoOcupacionalRepository.save(arcoOcupacional);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("arcoOcupacional", arcoOcupacional);
		}		
		return modelAndView;
	}

	@GetMapping("/arco/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/arcos/arco");
		ArcoOcupacional arcoOcupacional = arcoOcupacionalRepository.findOne(id);
		Curso curso = cursoRepository.findByArcoOcupacional(arcoOcupacional);
		modelAndView.addObject("arcoOcupacional", arcoOcupacional);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("cbos", cBORepository.findAll());
		List<CBO> cbos_arco = arcoOcupacional.getCbos();
		modelAndView.addObject("cbos_arco", cbos_arco);
		return modelAndView;
	}
	
	@PostMapping("/arco/{id}")
	public ModelAndView update(@Valid ArcoOcupacional arcoOcupacional, BindingResult bindingResult, @PathVariable("id") Long id) {
		Long idCurso = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos/"+idCurso);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("arcoOcupacional", arcoOcupacional);
		} else {
			arcoOcupacionalRepository.save(arcoOcupacional);
			modelAndView.addObject("arcoOcupacional", arcoOcupacional);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
}
