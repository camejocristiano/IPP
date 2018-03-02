package br.net.ipp.controllers.cursos;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.ArcoOcupacionalRepository;
import br.net.ipp.daos.cursos.CBORepository;
import br.net.ipp.daos.cursos.ConteudoTeoricoBasicoRepository;
import br.net.ipp.daos.cursos.ConteudoTeoricoEspecificoRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.daos.cursos.ValidacaoRepository;
import br.net.ipp.enums.Status;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.ArcoOcupacional;
import br.net.ipp.models.cursos.CBO;
import br.net.ipp.models.cursos.ConteudoTeoricoBasico;
import br.net.ipp.models.cursos.ConteudoTeoricoEspecifico;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
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
private EnumService enumService;
private UsuarioRepository usuarioRepository;

	@Autowired
	public CursoController(
			CursoRepository cursoRepository,
			TurmaRepository turmaRepository,
			MatriculaRepository matriculaRepository,
			CBORepository cboRepository,
			UnidadeRepository unidadeRepository,
			ArcoOcupacionalRepository arcoOcupacionalRepository,
			ConteudoTeoricoBasicoRepository conteudoTeoricoBasicoRepository,
			ConteudoTeoricoEspecificoRepository conteudoTeoricoEspecificoRepository,
			ValidacaoRepository validacaoRepository,
			UsuarioRepository usuarioRepository
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
		this.enumService = new EnumService();	
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/homeCursos")
	public ModelAndView homeCursos(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("cursos/home");
		modelAndView.addObject("usuarioSessao", usuarioRepository.findByUsername(userDetails.getUsername()));
		return modelAndView;
	}

	@GetMapping("/homeCurso/{id}")
	public ModelAndView homeCurso(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("cursos/cursos/home");
		modelAndView.addObject("usuarioSessao", usuarioRepository.findByUsername(userDetails.getUsername()));
		modelAndView.addObject("curso", cursoRepository.findOne(id));
		return modelAndView;
	}
	
	@GetMapping("/cursos")
	public ModelAndView cursos(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCursoListar() == true) {
			modelAndView = new ModelAndView("cursos/cursos/cursos");
			if (usuarioSessao.isAdmin() == true) {
				modelAndView.addObject("cursos", cursoRepository.findAll());
			} else {
				modelAndView.addObject("cursos", cursoRepository.findAllByStatus(Status.ATIVO));
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/curso/form")
	public ModelAndView curso(Curso curso, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCursoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/cursos/curso");
			modelAndView.addObject("curso", curso);
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> statusPAP = enumService.carregarStatusPAP();
			modelAndView.addObject("statusPAP", statusPAP);
			modelAndView.addObject("cBOs", cboRepository.findAll());
			modelAndView.addObject("arcos", arcoOcupacionalRepository.findAll());
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			modelAndView.addObject("basicos", conteudoTeoricoBasicoRepository.findAll());
			modelAndView.addObject("especificos", conteudoTeoricoEspecificoRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/curso")
	public ModelAndView save(@Valid Curso curso, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCursoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/cursos/curso");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! OKK");
				modelAndView.addObject("curso", curso);
			} else {
				cursoRepository.save(curso);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("curso", curso);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/curso/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCursoVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/cursos/curso");
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
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> statusPAP = enumService.carregarStatusPAP();
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
			modelAndView.addObject("basicos", conteudoTeoricoBasicoRepository.findAll());
			modelAndView.addObject("especificos", conteudoTeoricoEspecificoRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/curso/{id}")
	public ModelAndView update(@Valid Curso curso, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCursoVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/cursos/curso");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("curso", curso);
			} else {
				cursoRepository.save(curso);
				modelAndView.addObject("curso", curso);
				modelAndView = new ModelAndView("cursos/cursos/curso");
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
				List<String> status = enumService.carregarStatus();
				modelAndView.addObject("status", status);
				List<String> statusPAP = enumService.carregarStatusPAP();
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
				modelAndView.addObject("basicos", conteudoTeoricoBasicoRepository.findAll());
				modelAndView.addObject("especificos", conteudoTeoricoEspecificoRepository.findAll());
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
