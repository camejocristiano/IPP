package br.net.ipp.controllers.cursos;

import java.util.ArrayList;
import java.util.Arrays;
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

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.enums.DiaDaSemana;
import br.net.ipp.enums.TipoTurmaEnum;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Turma;

@Controller
@Transactional
@RequestMapping("/turmas")
public class TurmaController {
	
private TurmaRepository turmaRepository;
private CursoRepository cursoRepository;
private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void TurmaEndPoint(
			TurmaRepository turmaRepository,
			CursoRepository cursoRepository,
			UsuarioRepository usuarioRepository
			) {
		this.turmaRepository = turmaRepository;
		this.cursoRepository = cursoRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/form")
	public ModelAndView escolaridadeNull() {
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos");
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView turma(Turma turma, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/turmas/turma");
		Curso curso = cursoRepository.findOne(id);
		List<String> diaDaSemana = carregarDiaDaSemana();
		modelAndView.addObject("diaDaSemana", diaDaSemana);
		List<String> tiposTurma = carregarTiposTurmaEnum();
		modelAndView.addObject("tiposTurma", tiposTurma);
		turma = new Turma();
		turma.setCurso(curso);
		modelAndView.addObject("curso", curso);
		modelAndView.addObject("turma", turma);
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Turma turma, BindingResult bindingResult) {
		Long id = turma.getCurso().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("turma", turma);
			List<String> diaDaSemana = carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
		} else {
			turmaRepository.save(turma);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("turma", turma);
			List<String> diaDaSemana = carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/turmas/turma");
		Turma turma = turmaRepository.findOne(id);
		modelAndView.addObject("turma", turma);
		List<String> tiposTurma = carregarTiposTurmaEnum();
		modelAndView.addObject("tiposTurma", tiposTurma);
		List<String> diaDaSemana = carregarDiaDaSemana();
		modelAndView.addObject("diaDaSemana", diaDaSemana);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Turma turma, BindingResult bindingResult) {
		Long id = turma.getCurso().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/cursos/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("turma", turma);
			List<String> diaDaSemana = carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
		} else {
			turmaRepository.save(turma);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("turma", turma);
			List<String> diaDaSemana = carregarDiaDaSemana();
			modelAndView.addObject("diaDaSemana", diaDaSemana);
		}	
		return modelAndView;
	}
	
	public List<String> carregarDiaDaSemana() {
		List<DiaDaSemana> lista = Arrays.asList(DiaDaSemana.values());
		List<String> diaDaSemana = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			diaDaSemana.add(lista.get(i).name());
		}
		return diaDaSemana;
	}
	
	public List<String> carregarTiposTurmaEnum() {
		List<TipoTurmaEnum> lista = Arrays.asList(TipoTurmaEnum.values());
		List<String> tiposTurma = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposTurma.add(lista.get(i).name());
		}
		return tiposTurma;
	}
	
}
