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

import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.cursos.ArcoOcupacionalRepository;
import br.net.ipp.daos.cursos.CBORepository;
import br.net.ipp.daos.cursos.ConteudoTeoricoBasicoRepository;
import br.net.ipp.daos.cursos.ConteudoTeoricoEspecificoRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.daos.cursos.ValidacaoRepository;
import br.net.ipp.enums.Status;
import br.net.ipp.enums.StatusPAP;
import br.net.ipp.models.cursos.ArcoOcupacional;
import br.net.ipp.models.cursos.CBO;
import br.net.ipp.models.cursos.ConteudoTeoricoBasico;
import br.net.ipp.models.cursos.ConteudoTeoricoEspecifico;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;

@Controller
@Transactional
@RequestMapping("/cursos")
public class CursoController {

private CursoRepository cursoRepository;
private TurmaRepository turmaRepository;
private MatriculaRepository matriculaRepository;
private CBORepository cboRepository;
private UnidadeRepository unidadeRepository;
private ArcoOcupacionalRepository arcoOcupacionalRepository;
private ConteudoTeoricoBasicoRepository conteudoTeoricoBasicoRepository;
private ConteudoTeoricoEspecificoRepository conteudoTeoricoEspecificoRepository;
private ValidacaoRepository validacaoRepository;

	@Autowired
	public void CursoEndPoint(
			CursoRepository cursoRepository,
			TurmaRepository turmaRepository,
			MatriculaRepository matriculaRepository,
			CBORepository cboRepository,
			UnidadeRepository unidadeRepository,
			ArcoOcupacionalRepository arcoOcupacionalRepository,
			ConteudoTeoricoBasicoRepository conteudoTeoricoBasicoRepository,
			ConteudoTeoricoEspecificoRepository conteudoTeoricoEspecificoRepository,
			ValidacaoRepository validacaoRepository
			) {
		this.cursoRepository = cursoRepository;
		this.turmaRepository = turmaRepository;
		this.matriculaRepository = matriculaRepository;
		this.cboRepository = cboRepository;
		this.unidadeRepository = unidadeRepository;
		this.arcoOcupacionalRepository = arcoOcupacionalRepository;
		this.conteudoTeoricoBasicoRepository = conteudoTeoricoBasicoRepository;
		this.conteudoTeoricoEspecificoRepository = conteudoTeoricoEspecificoRepository;
		this.validacaoRepository = validacaoRepository;
		
		
	}

	@GetMapping("/form")
	public ModelAndView curso(Curso curso) {
		ModelAndView modelAndView = new ModelAndView("cursos/cursos/curso");
		modelAndView.addObject("curso", curso);
		List<String> status = carregarStatus();
		modelAndView.addObject("status", status);
		List<String> statusPAP = carregarStatusPAP();
		modelAndView.addObject("statusPAP", statusPAP);
		modelAndView.addObject("cBOs", cboRepository.findAll());
		modelAndView.addObject("unidades", unidadeRepository.findAll());
		
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Curso curso, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("curso", curso);
			List<String> status = carregarStatus();
			modelAndView.addObject("status", status);
			List<String> statusPAP = carregarStatusPAP();
			modelAndView.addObject("statusPAP", statusPAP);
			modelAndView.addObject("cBOs", cboRepository.findAll());			
			modelAndView.addObject("unidades", unidadeRepository.findAll());
		} else {
			cursoRepository.save(curso);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("curso", curso);
			List<String> status = carregarStatus();
			modelAndView.addObject("status", status);
			List<String> statusPAP = carregarStatusPAP();
			modelAndView.addObject("statusPAP", statusPAP);
			modelAndView.addObject("cBOs", cboRepository.findAll());
			modelAndView.addObject("unidades", unidadeRepository.findAll());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("cursos/cursos/curso");
		Curso curso = cursoRepository.findOne(id);
		modelAndView.addObject("curso", curso);
		List<Turma> turmas = turmaRepository.findAllByCurso(curso);
		modelAndView.addObject("turmas", turmas);
		modelAndView.addObject("cBOs", cboRepository.findAll());
		List<Matricula> matriculas = new ArrayList<Matricula>();
		for (Turma turma : turmas) {
			List<Matricula> mats  = matriculaRepository.findAllByTurma(turma);
			for (Matricula matricula : mats) {
				matriculas.add(matricula);
			}
		}
		modelAndView.addObject("matriculas", matriculas);
		List<String> status = carregarStatus();
		modelAndView.addObject("status", status);
		List<String> statusPAP = carregarStatusPAP();
		modelAndView.addObject("statusPAP", statusPAP);
		modelAndView.addObject("arcos", arcoOcupacionalRepository.findAll());
		if(curso.getArcoOcupacional() != null) {
			ArcoOcupacional arcoOcupacional = arcoOcupacionalRepository.findOne(curso.getArcoOcupacional().getId());
			List<CBO> cbos_arco = arcoOcupacional.getCbos();
			modelAndView.addObject("cbos_arco", cbos_arco);
		}
		modelAndView.addObject("unidades", unidadeRepository.findAll());
		List<ConteudoTeoricoBasico> basicos_curso = curso.getConteudosTeoricosBasicos();
		modelAndView.addObject("basicos_curso", basicos_curso);
		modelAndView.addObject("basicos", conteudoTeoricoBasicoRepository.findAll());
		List<ConteudoTeoricoEspecifico> especificos_curso = curso.getConteudosTeoricosEspecificos();
		modelAndView.addObject("especificos_curso", especificos_curso);
		modelAndView.addObject("especificos", conteudoTeoricoEspecificoRepository.findAll());
		modelAndView.addObject("validacoes", validacaoRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Curso curso, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("curso", curso);
			List<String> status = carregarStatus();
			modelAndView.addObject("status", status);
			List<String> statusPAP = carregarStatusPAP();
			modelAndView.addObject("statusPAP", statusPAP);
			modelAndView.addObject("cBOs", cboRepository.findAll());
			modelAndView.addObject("unidades", unidadeRepository.findAll());
		} else {
			cursoRepository.save(curso);
			modelAndView.addObject("curso", curso);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			List<String> status = carregarStatus();
			modelAndView.addObject("status", status);
			List<String> statusPAP = carregarStatusPAP();
			modelAndView.addObject("statusPAP", statusPAP);
			modelAndView.addObject("cBOs", cboRepository.findAll());
			modelAndView.addObject("unidades", unidadeRepository.findAll());
		}	
		return modelAndView;
	}
	
	public List<String> carregarStatus() {
		List<Status> lista = Arrays.asList(Status.values());
		List<String> status = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			status.add(lista.get(i).name());
		}
		return status;
	}
	
	public List<String> carregarStatusPAP() {
		List<StatusPAP> lista = Arrays.asList(StatusPAP.values());
		List<String> statusPAP = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			statusPAP.add(lista.get(i).name());
		}
		return statusPAP;
	}
	
}
