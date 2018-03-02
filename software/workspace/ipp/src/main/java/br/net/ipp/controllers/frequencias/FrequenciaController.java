package br.net.ipp.controllers.frequencias;

import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.cursos.TurmaRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.daos.frequencias.FrequenciaRepository;
import br.net.ipp.enums.DiaDaSemana;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.models.frequencias.Frequencia;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class FrequenciaController {

	private UsuarioRepository usuarioRepository;
	Calendar c = Calendar.getInstance();
	private FrequenciaRepository frequenciaRepository;
	private MatriculaRepository matriculaRepository;
	private TurmaRepository turmaRepository;
	private EnumService enumService;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	
	@Autowired
	public FrequenciaController(
			UsuarioRepository usuarioRepository,
			FrequenciaRepository frequenciaRepository,
			MatriculaRepository matriculaRepository,
			TurmaRepository turmaRepository,
			EnumService enumService,
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			GestorRepository gestorRepository
			) {
		this.usuarioRepository = usuarioRepository;
		this.frequenciaRepository = frequenciaRepository;
		this.matriculaRepository = matriculaRepository;
		this.turmaRepository = turmaRepository;
		this.enumService = new EnumService();
		this.gestorRepository = gestorRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.contatoRepository = contatoRepository;
	}
	
	/**
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/frequencias")
	public ModelAndView frequencias(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			if (usuarioSessao.isAdmin() == true) {
				modelAndView = new ModelAndView("frequencias/home");
			} else {
				modelAndView = new ModelAndView("redirect:/sw/frequencias/turmas");
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/frequencias/total")
	public ModelAndView frequenciasGeral(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			if (usuarioSessao.isAdmin() == true) {
				modelAndView = new ModelAndView("frequencias/frequencias");
				modelAndView.addObject("frequencias", frequenciaRepository.findAll());
			} else {
				modelAndView = new ModelAndView("redirect:/sw/frequencias/turmas");
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/frequencias/turmas")
	public ModelAndView frequenciasTurmasOrientador(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			modelAndView = new ModelAndView("frequencias/turmas/turmas");
			if (usuarioSessao.isAdmin() == true) {
				modelAndView.addObject("turmas", turmaRepository.findAll());
			} else {
				modelAndView.addObject("turmas", turmaRepository.findAllByOrientadorTurma((Usuario) usuarioSessao));
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * @param idTurma
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/frequencias/dia/{id}")
	public ModelAndView frequenciasTurmaDia(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			modelAndView = new ModelAndView("frequencias/turmas/turma");
			Turma turma = turmaRepository.findOne(id);
			modelAndView.addObject("turma", turma);
			List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
			modelAndView.addObject("matriculas", matriculas);
			List<String> turnos = this.enumService.carregarTurnos();
			modelAndView.addObject("turnos", turnos);
			List<String> dias = this.enumService.carregarDiaDaSemana();
			modelAndView.addObject("dias", dias);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * @param idTurma
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/frequencias/mes/{id}")
	public ModelAndView frequenciasTurmaMes(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			modelAndView = new ModelAndView("frequencias/turmas/mes");
			Turma turma = turmaRepository.findOne(id);
			HashMap<Matricula, List<Frequencia>> hash = new HashMap<Matricula, List<Frequencia>>();
			List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
			List<Frequencia> frequencia = null;
			for (Matricula matricula : matriculas) {
				List<Frequencia> frequencias = frequenciaRepository.findByMatriculaAndMes(matricula, c.get(Calendar.MONTH)+1);
				hash.put(matricula, frequencias);
				frequencia = frequenciaRepository.findByMatriculaAndMes(matricula, c.get(Calendar.MONTH)+1);
			}
			Integer total = 0;
			modelAndView.addObject("total", total );
			modelAndView.addObject("totall", total );
			modelAndView.addObject("hash", hash);
			modelAndView.addObject("turma", turma);
			modelAndView.addObject("frequencias", frequencia);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * @param idTurma
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/frequencias/ano/{id}")
	public ModelAndView frequenciasTurmaAno(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			modelAndView = new ModelAndView("frequencias/turmas/mes");
			Turma turma = turmaRepository.findOne(id);
			HashMap<Matricula, List<Frequencia>> hash = new HashMap<Matricula, List<Frequencia>>();
			List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
			List<Frequencia> frequencia = null;
			for (Matricula matricula : matriculas) {
				List<Frequencia> frequencias = frequenciaRepository.findByMatriculaAndAno(matricula, c.get(Calendar.YEAR));
				hash.put(matricula, frequencias);
				frequencia = frequenciaRepository.findByMatriculaAndAno(matricula, c.get(Calendar.YEAR));
			}
			Integer total = 0;
			modelAndView.addObject("total", total );
			modelAndView.addObject("hash", hash);
			modelAndView.addObject("frequencias", frequencia);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * @param idTurma
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/frequencias/geral/{id}")
	public ModelAndView frequenciasTurmaCurso(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			modelAndView = new ModelAndView("frequencias/turmas/mes");
			Turma turma = turmaRepository.findOne(id);
			HashMap<Matricula, List<Frequencia>> hash = new HashMap<Matricula, List<Frequencia>>();
			List<Matricula> matriculas = matriculaRepository.findAllByTurma(turma);
			List<Frequencia> frequencia = null;
			for (Matricula matricula : matriculas) {
				List<Frequencia> frequencias = frequenciaRepository.findByMatricula(matricula);
				hash.put(matricula, frequencias);
				frequencia = frequenciaRepository.findByMatricula(matricula);
			}
			Integer total = 0;
			modelAndView.addObject("total", total );
			modelAndView.addObject("hash", hash);
			modelAndView.addObject("frequencias", frequencia);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * @param idJovem
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/frequencias/jovem/mes/{id}")
	public ModelAndView frequenciasJovemMes(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			modelAndView = new ModelAndView("frequencias/jovens/mes");
			Matricula matricula = matriculaRepository.findOne(id);
			List<Frequencia> frequencias = frequenciaRepository.findByMatriculaAndMes(matricula, c.get(Calendar.MONTH)+1);
			Integer total = 0;
			modelAndView.addObject("total", total );
			modelAndView.addObject("matricula", matricula);
			modelAndView.addObject("frequencias", frequencias);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	
	//list/frequencias/curso/{idJovem}		ADM/Usuario(Orientador)/Gestor
	@GetMapping("/frequencias/jovem/curso/{idJovem}")
	public ModelAndView frequenciasJovemCurso(@PathVariable Long idJovem, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaListar() == true) {
			// Implementar
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * @param idTurma
	 * @param userDetails
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/frequencia/turma/{id}")
	public ModelAndView frequenciasCadastrarTurma(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaCadastrar() == true) {
			modelAndView = new ModelAndView("redirect:/sw/frequencias/turmas");
			String matriculas[] = request.getParameterValues("matriculas");
			for (int i = 0; i < matriculas.length; i++) {
				Frequencia frequencia = new Frequencia();
				Matricula matricula = matriculaRepository.findOne(Long.parseLong(matriculas[i]));
				frequencia.setMatricula(matricula);
				if(request.getParameterValues("frequencias"+matriculas[i]) == null) {
					frequencia.setComparecido(false);
				} else {
					frequencia.setComparecido(true);
				}
				String dia[] = request.getParameterValues("dia");
				for (String string : dia) {
					frequencia.setDia(Integer.parseInt(string));
					continue;
				}
				String mes[] = request.getParameterValues("mes");
				for (String string : mes) {
					frequencia.setMes(Integer.parseInt(string));
					continue;
				}
				String ano[] = request.getParameterValues("ano");
				for (String string : ano) {
					frequencia.setAno(Integer.parseInt(string));
					continue;
				}
				/*String turno[] = request.getParameterValues("turno");
				for (String string : turno) {
					if (string.equals("MANHA")) {
						frequencia.setTurno(TurnoEnum.MANHA);	
					} 
					if (string.equals("TARDE")) {
						frequencia.setTurno(TurnoEnum.TARDE);
					}	
					continue;
				}*/
				
				if(request.getParameterValues("diaDaSemana") != null) {
					switch (request.getParameterValues("diaDaSemana").toString()) {
					case "SEGUNDA":
						frequencia.setDiaDaSemana(DiaDaSemana.SEGUNDA);
						break;
					case "TERCA":
						frequencia.setDiaDaSemana(DiaDaSemana.TERCA);
						break;
					case "QUARTA":
						frequencia.setDiaDaSemana(DiaDaSemana.QUARTA);
						break;
					case "QUINTA":
						frequencia.setDiaDaSemana(DiaDaSemana.QUINTA);
						break;
					case "SEXTA":
						frequencia.setDiaDaSemana(DiaDaSemana.SEXTA);
						break;
					case "SABADO":
						frequencia.setDiaDaSemana(DiaDaSemana.SABADO);
						break;
					case "DOMINGO":
						frequencia.setDiaDaSemana(DiaDaSemana.DOMINGO);
						break;	

					default:
						break;
					}
				}
				frequenciaRepository.save(frequencia);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/frequencias");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	//visualizar/frequencia/{idFrequencia}		ADM/Usuario(Orientador)/Gestor
	@GetMapping("/frequencia/{id}")
	public ModelAndView frequenciaVisualizar(Frequencia frequencia, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaVisualizar() == true) {
			modelAndView = new ModelAndView("frequencias/frequencia");
			modelAndView.addObject("frequencia", frequenciaRepository.findOne(id));
			List<String> dias = this.enumService.carregarDiaDaSemana();
			modelAndView.addObject("dias", dias);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * @param frequencia
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/frequencia/{id}")
	public ModelAndView frequenciaEditar(Frequencia frequencia, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isFrequenciaEditar() == true) {
			modelAndView = new ModelAndView("frequencias/frequencia");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("frequencia", frequencia);
			} else {
				frequenciaRepository.save(frequencia);
				modelAndView.addObject("frequencia", frequencia);				
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		List<String> dias = this.enumService.carregarDiaDaSemana();
		modelAndView.addObject("dias", dias);
		return modelAndView;

	}
	
}