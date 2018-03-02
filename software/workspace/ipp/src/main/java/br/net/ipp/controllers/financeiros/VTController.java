package br.net.ipp.controllers.financeiros;

import java.math.BigDecimal;
import java.util.Calendar;
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

import br.net.ipp.daos.aprendizes.ContratacaoRepository;
import br.net.ipp.daos.aprendizes.DadosFinanceirosRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.daos.financeiros.ParametroRepository;
import br.net.ipp.daos.financeiros.VTRepository;
import br.net.ipp.daos.frequencias.FrequenciaRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.Contratacao;
import br.net.ipp.models.aprendizes.DadosFinanceiros;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.models.financeiros.Parametro;
import br.net.ipp.models.financeiros.VT;
import br.net.ipp.models.frequencias.Frequencia;

@Controller
@Transactional
@RequestMapping("/sw")
public class VTController {

	private JovemRepository jovemRepository;
	private ParametroRepository parametroRepository;
	private MatriculaRepository matriculaRepository;
	private FrequenciaRepository frequenciaRepository;
	private ContratacaoRepository contratacaoRepository;
	Calendar c = Calendar.getInstance();
	private ContatoRepository contatoRepository;
    private RepresentanteLegalRepository representanteLegalRepository;
    private GestorRepository gestorRepository;
    private UsuarioRepository usuarioRepository;
    private DadosFinanceirosRepository dadosFinanceirosRepository;
    private VTRepository vtRepository;
    
	@Autowired
	public VTController (
			JovemRepository jovemRepository,
			ParametroRepository parametroRepository,
			MatriculaRepository matriculaRepository,
			FrequenciaRepository frequenciaRepository,
			ContratacaoRepository contratacaoRepository,
			ContatoRepository contatoRepository,
    		RepresentanteLegalRepository representanteLegalRepository,
    		GestorRepository gestorRepository,
    		UsuarioRepository usuarioRepository,
    		DadosFinanceirosRepository dadosFinanceirosRepository,
    		VTRepository vtRepository
    		) {
		this.jovemRepository = jovemRepository;
		this.parametroRepository = parametroRepository;
		this.matriculaRepository = matriculaRepository;
		this.frequenciaRepository = frequenciaRepository;
		this.contratacaoRepository = contratacaoRepository;
		this.contatoRepository = contatoRepository;
        this.representanteLegalRepository = representanteLegalRepository;
        this.gestorRepository = gestorRepository;
        this.usuarioRepository = usuarioRepository;
        this.dadosFinanceirosRepository = dadosFinanceirosRepository;
        this.vtRepository = vtRepository;
    }
	
	@GetMapping("/vts")
	public ModelAndView vTs(@AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isVtCadastrar() == true) {
			modelAndView = new ModelAndView("financeiros/vts/vts");
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/vt")
	public ModelAndView save(VT vt, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isVtCadastrar() == true) {
			modelAndView = new ModelAndView("financeiros/vts/vt");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("vt", vt);
			} else {
				vtRepository.save(vt);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("vt", vt);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * @param vt
	 * @param idJovem
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/vt/{id}")
	public ModelAndView load(VT vt, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isVtVisualizar() == true) {
			modelAndView = new ModelAndView("financeiros/vts/vt");
			Contratacao contratacao = contratacaoRepository.findOne(id);
			Jovem jovem = jovemRepository.findOne(contratacao.getFichaProfissional().getJovem().getId());
			List<Parametro> parametros = (List<Parametro>) parametroRepository.findAll();
			Parametro parametro = null;
			for (Parametro param : parametros) {
				parametro = param;
			}
			List<Matricula> matriculas = matriculaRepository.findAllByJovem(contratacao.getFichaProfissional().getJovem());
			Matricula matricula = null;
			for (Matricula mat : matriculas) {
				if (mat.getStatusDaMatricula().toString() == "CURSANDO") {
					matricula = mat;
				}
			}
			List<Frequencia> frequencias = frequenciaRepository.findByMatriculaAndMes(matricula, c.get(Calendar.MONTH)+1);
			int faltasIPP = 0;
			int faltasEmpresa = 0;
			int faltasEmpresaJustificadas = 0;
			int faltasEmpresaNaoJustificadas = 0;
			int diasIPP = 0;
			int diasEmpresa = 0;
			int diasAReceber = 0;
			int segunda = 0;	
			int terca = 0;
			int quarta = 0;	
			int quinta = 0;
			int sexta = 0;	
			int sab = 0;
			
			for (Frequencia frequencia : frequencias) {
				if(frequencia.isComparecido() == true) {
					if(frequencia.getTipoDeInsercao() != null && frequencia.getTipoDeInsercao().toString() == "EMPRESA") {
						diasEmpresa++;
					} else {
						diasIPP++;
					}
					if (frequencia.getDiaDaSemana() != null) {
						switch (frequencia.getDiaDaSemana().toString()) {
						case "SEGUNDA":
							segunda++;
							break;
						case "TERCA":
							terca++;
							break;
						case "QUARTA":
							quarta++;
							break;
						case "QUINTA":
							quinta++;
							break;
						case "SEXTA":
							sexta++;
							break;
						case "SABADO":
							sab++;
							break;
	
						default:
							break;
						}
					}
				} else {
					if(frequencia.getTipoDeInsercao() != null && frequencia.getTipoDeInsercao().toString() == "EMPRESA") {
						faltasEmpresa++;
						if (frequencia.isJustificativa() == true) {
							faltasEmpresaJustificadas++;
						} else {
							faltasEmpresaNaoJustificadas++;
						}
					} else {
						faltasIPP++;
					}
				}
			}
			if (contratacao.getMesDeInicioDaContratacao() == c.get(Calendar.MONTH)+1) {
				diasAReceber = 30 - contratacao.getDiaDeInicioDaContratacao() - (faltasIPP + faltasEmpresa);
			} else {
				diasAReceber = 30 - (faltasIPP + faltasEmpresa);
			}
			DadosFinanceiros financeiro = dadosFinanceirosRepository.findByJovem(jovem);
			String diaInicio = null;
			if (contratacao.getDiaDeInicioDaContratacao() < 10) {
				diaInicio = "0"+contratacao.getDiaDeInicioDaContratacao().toString();
			} else {
				diaInicio = contratacao.getDiaDeInicioDaContratacao().toString();
			}
			String mesInicio = null;
			if (contratacao.getMesDeInicioDaContratacao() < 10) {
				mesInicio = "0"+contratacao.getMesDeInicioDaContratacao().toString();
			} else {
				mesInicio = contratacao.getMesDeInicioDaContratacao().toString();
			}
			String dataDaContratacao =  diaInicio+"/"+mesInicio+"/"+contratacao.getAnoDeInicioDaContratacao().toString();
			String diaFinal = null;
			if (contratacao.getDiaTerminoDoContrato() < 10) {
				diaFinal = "0"+contratacao.getDiaTerminoDoContrato().toString();
			} else {
				diaFinal = contratacao.getDiaTerminoDoContrato().toString();
			}
			String mesFinal = null;
			if (contratacao.getMesTerminoDoContrato() < 10) {
				mesFinal = "0"+contratacao.getMesTerminoDoContrato().toString();
			} else {
				mesFinal = contratacao.getMesTerminoDoContrato().toString();
			}
			String dataFIMDaContratacao =  diaFinal+"/"+mesFinal+"/"+contratacao.getAnoTerminoDoContrato().toString();
			modelAndView.addObject("liquedo", parametro.getSalarioMinimoFederalSMF());
			
			BigDecimal totalBruto = new BigDecimal(parametro.getSalarioMinimoFederalSMF().toString());
			BigDecimal totalLiquedo = new BigDecimal(totalBruto.toString());
			BigDecimal totalDescontos = new BigDecimal("0");
			BigDecimal cemPorCento = new BigDecimal("100");
			BigDecimal umPorCento = new BigDecimal(parametro.getSalarioMinimoFederalSMF().toString());
			umPorCento = umPorCento.divide(cemPorCento);
			
			String mes = Integer.toString(c.get(Calendar.MONTH)+1);
			
			// Bilhete Único
			BigDecimal unicoMetroIPP = null;
			if (financeiro.getValeTransporteIPPCurso_metroValor() != null) {
				unicoMetroIPP = new BigDecimal(financeiro.getValeTransporteIPPCurso_metroValor().toString());
			} else {
				unicoMetroIPP = new BigDecimal("0.00");
			}
			BigDecimal unicoIntegracaoIPP = null;
			if (financeiro.getValeTransporteIPPCurso_integracaoValor() != null) {
				unicoIntegracaoIPP = new BigDecimal(financeiro.getValeTransporteIPPCurso_integracaoValor().toString());
			} else {
				unicoIntegracaoIPP = new BigDecimal("0.00");
			}
			BigDecimal unicoMetroEmpresa = null;
			if (financeiro.getValeTransporteEmpresaTrabalho_metroValor() != null) {
				unicoMetroEmpresa = new BigDecimal(financeiro.getValeTransporteEmpresaTrabalho_metroValor().toString());
			} else {
				unicoMetroEmpresa = new BigDecimal("0.00");
			}
			BigDecimal unicoIntegracaoEmpresa = null;
			if (financeiro.getValeTransporteEmpresaTrabalho_integracaoValor() != null) {
				unicoIntegracaoEmpresa = new BigDecimal(financeiro.getValeTransporteEmpresaTrabalho_metroValor().toString());
			} else {
				unicoIntegracaoEmpresa = new BigDecimal("0.00");
			}

			// BOM
			BigDecimal sPTransTremIPP = null;
			if (financeiro.getValeTransporteIPPCurso_metroValor() != null) {
				sPTransTremIPP = new BigDecimal(financeiro.getValeTransporteIPPCurso_tremValor().toString());
			} else {
				sPTransTremIPP = new BigDecimal("0.00");
			}
			BigDecimal sPTransOnibusIPP = null;
			if (financeiro.getValeTransporteIPPCurso_integracaoValor() != null) {
				sPTransOnibusIPP = new BigDecimal(financeiro.getValeTransporteIPPCurso_onibusMunicipalValor().toString());
			} else {
				sPTransOnibusIPP = new BigDecimal("0.00");
			}
			BigDecimal sPTransTremEmpresa = null;
			if (financeiro.getValeTransporteEmpresaTrabalho_metroValor() != null) {
				sPTransTremEmpresa = new BigDecimal(financeiro.getValeTransporteEmpresaTrabalho_tremValor().toString());
			} else {
				sPTransTremEmpresa = new BigDecimal("0.00");
			}
			BigDecimal sPTransOnibusEmpresa = null;
			if (financeiro.getValeTransporteEmpresaTrabalho_integracaoValor() != null) {
				sPTransOnibusEmpresa = new BigDecimal(financeiro.getValeTransporteEmpresaTrabalho_onibusMunicipalValor().toString());
			} else {
				sPTransOnibusEmpresa = new BigDecimal("0.00");
			}
			
			// BEM
			BigDecimal bem = null;
			if (financeiro.getValeTransporteIPPCurso_metroValor() != null) {
				bem = new BigDecimal(financeiro.getValeTransporteIPPCurso_bemValor().toString());
			} else {
				bem = new BigDecimal("0.00");
			}
			
			BigDecimal unico = new BigDecimal("0.00");	
			BigDecimal unicoIPP = new BigDecimal("0.00");	
			BigDecimal unicoEmpresa = new BigDecimal("0.00");	
			BigDecimal unicoIdaEVolta = new BigDecimal("0.00");	
			BigDecimal unicoParaJovem = new BigDecimal("0.00"); 	 
			BigDecimal unicoParaSPTans = new BigDecimal("0.00");
			
			BigDecimal bom = new BigDecimal("0.00");	
			BigDecimal bomIPP = new BigDecimal("0.00");	
			BigDecimal bomEmpresa = new BigDecimal("0.00");	
			BigDecimal bomIdaEVolta = new BigDecimal("0.00");	
			BigDecimal bomParaJovem = new BigDecimal("0.00"); 	 
			BigDecimal bomParaCMT = new BigDecimal("0.00");

			BigDecimal bemBem = new BigDecimal("0.00");	
			BigDecimal bemIdaEVolta = new BigDecimal("0.00");	
			BigDecimal bemParaJovem = new BigDecimal("0.00");

			BigDecimal valorIPP = new BigDecimal("0.00");	
			BigDecimal valorEmpresa = new BigDecimal("0.00");
			
			for (Frequencia frequencia : frequencias) {
				if (frequencia.isComparecido() == true) {
					if(frequencia.getDiaDaSemana() == matricula.getTurma().getDiaDaSemana()) {
						unicoIPP = unicoIPP.add(unicoMetroIPP);
						unicoIPP = unicoIPP.add(unicoIntegracaoIPP);
						unicoParaJovem = unicoParaJovem.add(unicoIPP);
						unicoParaJovem = unicoParaJovem.add(unicoIPP);
						unico = unico.add(unicoIPP);
						
						valorIPP = valorIPP.add(unico);
						
						bomIPP = bomIPP.add(sPTransTremIPP);
						bomIPP = bomIPP.add(sPTransOnibusIPP);
						bomParaJovem = bomParaJovem.add(bomIPP);
						bomParaJovem = bomParaJovem.add(bomIPP);
						bom = bom.add(bomIPP);

						valorIPP = valorIPP.add(bom);
					} else {
						unicoEmpresa = unicoEmpresa.add(unicoMetroEmpresa);
						unicoEmpresa = unicoEmpresa.add(unicoIntegracaoEmpresa);
						unicoParaSPTans = unicoParaSPTans.add(unicoEmpresa);
						unicoParaSPTans = unicoParaSPTans.add(unicoEmpresa);
						unico = unico.add(unicoEmpresa);
						
						valorEmpresa = valorEmpresa.add(unico);
						
						bomEmpresa = bomEmpresa.add(sPTransTremEmpresa);
						bomEmpresa = bomEmpresa.add(sPTransOnibusEmpresa);
						bomParaCMT = bomParaCMT.add(bomEmpresa);
						bomParaCMT = bomParaCMT.add(bomEmpresa);
						bom = bom.add(bomEmpresa);
						
						valorEmpresa = valorEmpresa.add(bom);
					}
					bemBem = bemBem.add(bem);
					bemParaJovem = bemParaJovem.add(bemBem);

					valorIPP = valorIPP.add(bem);
				}
			}
				
			unicoIdaEVolta = unicoIdaEVolta.add(unico);
			unicoIdaEVolta = unicoIdaEVolta.add(unico);
			
			bomIdaEVolta = bomIdaEVolta.add(bom);
			bomIdaEVolta = bomIdaEVolta.add(bom);
			
			bemIdaEVolta = bemIdaEVolta.add(bem);
			bemIdaEVolta = bemIdaEVolta.add(bem);
			
			vt.setCod(matricula.getJovem().getCodigoDoJovem());
			vt.setAprendiz(matricula.getJovem().getNome());
			vt.setEmpresa(contratacao.getEmpresaContratante().getNomeFantazia());
			vt.setMesReferente(mes);
			vt.setPap(matricula.getTurma().getDiaDaSemana().toString());
			
			vt.setSegunda(Integer.toString(segunda));
			vt.setTerca(Integer.toString(terca));
			vt.setQuarta(Integer.toString(quinta));
			vt.setQuinta(Integer.toString(quinta));
			vt.setSexta(Integer.toString(sexta));
			vt.setSab(Integer.toString(sab));
			
			vt.setFaltasCurso(Integer.toString(faltasIPP));
			vt.setFaltasEmpresa(Integer.toString(faltasEmpresa));
			vt.setFaltasEmpresaJustificada(Integer.toString(faltasEmpresaJustificadas));
			vt.setFaltasEmpresaInjustificada(Integer.toString(faltasEmpresaNaoJustificadas));
			vt.setDiasAPagar(Integer.toString(diasEmpresa + diasIPP));
			
			vt.setUnico(unico.toString());
			vt.setUnicoIdaEVolta(unicoIdaEVolta.toString());
			vt.setUnicoParaJovem(unicoParaJovem.toString());
			vt.setUnicoParaSPTans(unicoParaSPTans.toString());

			vt.setBom(bom.toString());
			vt.setBomIdaEVolta(bomIdaEVolta.toString());
			vt.setBomParaJovem(bomParaJovem.toString());
			vt.setBomParaCMT(bomParaCMT.toString());
			
			vt.setbEM(bem.toString());
			vt.setbEMIdaEVolta(bemIdaEVolta.toString());
			vt.setbEMParaJovem(bemParaJovem.toString());
			
			vt.setDiasMes("30");
			
			vt.setDataInicioContrato(dataDaContratacao);
			vt.setDataFimContrato(dataFIMDaContratacao);
			
			vt.setDataFimContrato(dataFIMDaContratacao);

			BigDecimal totalAluno = new BigDecimal("0.00");
			totalAluno = totalAluno.add(unicoParaJovem);
			totalAluno = totalAluno.add(bomParaJovem);
			totalAluno = totalAluno.add(bemParaJovem);
			vt.setTotalAluno(totalAluno.toString());
			
			BigDecimal totalConcessionaria = new BigDecimal("0.00");
			totalConcessionaria = totalConcessionaria.add(unicoParaSPTans);
			totalConcessionaria = totalConcessionaria.add(bomParaCMT);
			vt.setTotalConcessionaria(totalConcessionaria.toString());
		
			vt.setValorIPP(valorIPP.toString());
			vt.setValorEmpresa(valorEmpresa.toString());

			modelAndView.addObject("vt", vt);
			
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/vt/{id}")
	public ModelAndView update(@Valid VT vT, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isVtEditar() == true) {
			modelAndView = new ModelAndView("financeiros/vts/vt");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("vt", vT);
			} else {
				vtRepository.save(vT);
				modelAndView.addObject("vt", vT);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
