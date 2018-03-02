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
import br.net.ipp.daos.financeiros.DemonstrativoRepository;
import br.net.ipp.daos.financeiros.ParametroRepository;
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
import br.net.ipp.models.financeiros.Demonstrativo;
import br.net.ipp.models.financeiros.Parametro;
import br.net.ipp.models.frequencias.Frequencia;

@Controller
@Transactional
@RequestMapping("/sw")
public class DemonstrativoController {

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
    private DemonstrativoRepository demonstrativoRepository;
    private DadosFinanceirosRepository dadosFinanceirosRepository;
       
	@Autowired
	public DemonstrativoController (
			JovemRepository jovemRepository,
			ParametroRepository parametroRepository,
			MatriculaRepository matriculaRepository,
			FrequenciaRepository frequenciaRepository,
			ContratacaoRepository contratacaoRepository,
			ContatoRepository contatoRepository,
    		RepresentanteLegalRepository representanteLegalRepository,
    		GestorRepository gestorRepository,
    		UsuarioRepository usuarioRepository,
    		DemonstrativoRepository demonstrativoRepository,
    		DadosFinanceirosRepository dadosFinanceirosRepository
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
        this.demonstrativoRepository = demonstrativoRepository;
        this.dadosFinanceirosRepository = dadosFinanceirosRepository;
    }

	/**
	 * @param userDetails
	 * @return
	 * 		List<Demonstrativo>
	 * @exception
	 * 		redirect:swfinanceiros
	 */
	@GetMapping("/demonstrativos")
	public ModelAndView demonstrativos(@AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isDemonstrativoListar() == true) {
			modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativos");
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * @param idContratacao
	 * @param userDetails
	 * @return
	 * 		Demonstrativo
	 * @exception
	 * 		redirect:swfinanceiros
	 */
	@GetMapping("/demonstrativo/{id}")
	public ModelAndView load(Demonstrativo demonstrativo, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isDemonstrativoVisualizar() == true) {
			modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativo");
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
			modelAndView.addObject("frequencias", frequencias);
			int faltas = 0;
			int diasTrabalho = 0;
			int diasAReceber = 0;
			for (Frequencia frequencia : frequencias) {
				if(!frequencia.isComparecido() == true) {
					faltas++;
				} else {
					diasTrabalho++;
				}
			}
			if (contratacao.getMesDeInicioDaContratacao() == c.get(Calendar.MONTH)+1) {
				diasAReceber = 30 - contratacao.getDiaDeInicioDaContratacao() - faltas;
			} else {
				diasAReceber = 30 - faltas;
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
			modelAndView.addObject("frequencias", frequencias);
			modelAndView.addObject("liquedo", parametro.getSalarioMinimoFederalSMF());
			
			BigDecimal totalBruto = new BigDecimal(parametro.getSalarioMinimoFederalSMF().toString());
			BigDecimal totalLiquedo = new BigDecimal(totalBruto.toString());
			BigDecimal totalDescontos = new BigDecimal("0");
			BigDecimal cemPorCento = new BigDecimal("100");
			BigDecimal umPorCento = new BigDecimal(parametro.getSalarioMinimoFederalSMF().toString());
			umPorCento = umPorCento.divide(cemPorCento);
			// Descontos
			BigDecimal iNSS_20_porCento = new BigDecimal("20");
			iNSS_20_porCento = iNSS_20_porCento.multiply(umPorCento);
			totalDescontos = totalDescontos.add(iNSS_20_porCento);
			BigDecimal fGTS_2_porCento = new BigDecimal("2");
			fGTS_2_porCento = fGTS_2_porCento.multiply(umPorCento);
			totalDescontos = totalDescontos.add(fGTS_2_porCento);
			BigDecimal pIS_1_porCento = new BigDecimal("1");
			pIS_1_porCento = pIS_1_porCento.multiply(umPorCento);
			totalDescontos = totalDescontos.add(pIS_1_porCento);
			BigDecimal acidenteDeTrabalho_2_porCento = new BigDecimal("2");
			acidenteDeTrabalho_2_porCento = acidenteDeTrabalho_2_porCento.multiply(umPorCento);
			totalDescontos = totalDescontos.add(acidenteDeTrabalho_2_porCento);
			BigDecimal sistemaS_3_ponto_5_porCento = new BigDecimal("5");
			sistemaS_3_ponto_5_porCento = sistemaS_3_ponto_5_porCento.multiply(umPorCento);
			totalDescontos = totalDescontos.add(sistemaS_3_ponto_5_porCento);
			BigDecimal salarioEducacao_1_porCento = new BigDecimal("1");
			salarioEducacao_1_porCento = salarioEducacao_1_porCento.multiply(umPorCento);
			totalDescontos = totalDescontos.add(salarioEducacao_1_porCento);
			BigDecimal taxaExtraAdicional_18_porCento_s_min = new BigDecimal("18");
			taxaExtraAdicional_18_porCento_s_min = taxaExtraAdicional_18_porCento_s_min.multiply(umPorCento);
			totalDescontos = totalDescontos.add(taxaExtraAdicional_18_porCento_s_min);
			totalLiquedo = totalLiquedo.subtract(totalDescontos);
			
			demonstrativo.setNomeDoJovem(matricula.getJovem().getNome());
			demonstrativo.setCodigoDoJovem(matricula.getJovem().getCodigoDoJovem());
			demonstrativo.setIdadeDoJovem(matricula.getJovem().getIdade());
			demonstrativo.setDataDaContratacao(dataDaContratacao);
			demonstrativo.setBase(parametro.getSalarioMinimoFederalSMF().toString());
			demonstrativo.setSeguroDeVida_PCMSO(parametro.getSeguroDeVidaPCMSO().toString());
			String mes = Integer.toString(c.get(Calendar.MONTH)+1);
			demonstrativo.setMesReferente(mes);
			demonstrativo.setFaltas(Integer.toString(faltas));
			demonstrativo.setDiasTrabalhados(Integer.toString(diasTrabalho));
			demonstrativo.setValorBruto(parametro.getSalarioMinimoFederalSMF().toString());
			demonstrativo.setiNSS_20_porCento(iNSS_20_porCento.toString());
			demonstrativo.setfGTS_2_porCento(fGTS_2_porCento.toString());
			demonstrativo.setpIS_1_porCento(pIS_1_porCento.toString());
			demonstrativo.setAcidenteDeTrabalho_2_porCento(acidenteDeTrabalho_2_porCento.toString());
			demonstrativo.setSistemaS_3_ponto_5_porCento(sistemaS_3_ponto_5_porCento.toString());
			demonstrativo.setSalarioEducacao_1_porCento(salarioEducacao_1_porCento.toString());
			demonstrativo.setPlanoDeSaude(financeiro.getAssistenciaMedica_valor().toString());
			demonstrativo.setPlanoOdonto(financeiro.getAssistenciaOdontologica_valor().toString());
			demonstrativo.setTaxaExtraAdicional_18_porCento_s_min(taxaExtraAdicional_18_porCento_s_min.toString());
			demonstrativo.setDiaDoCurso(matricula.getTurma().getDiaDaSemana().toString());
			demonstrativo.setTerminoDoContrato(dataFIMDaContratacao);
			
			demonstrativo.setTotalLiquedo(totalLiquedo.toString());

			/*
			private String vt;
			private String vr;
			
			//Empresa(PAP)
			private String valorDaParceiriaEmpresa;
			
			*/
			
			
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/demonstrativo")
	public ModelAndView save(@Valid Demonstrativo demonstrativo, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isDemonstrativoVisualizar() == true) {
			modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativo");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("demonstrativo", demonstrativo);
			} else {
				demonstrativoRepository.save(demonstrativo);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("demonstrativo", demonstrativo);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
/*	@PostMapping("/demonstrativo/{id}")
	public ModelAndView update(@Valid Demonstrativo demonstrativo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		} else {
			demonstrativoRepository.save(demonstrativo);
			modelAndView.addObject("demonstrativo", demonstrativo);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}*/
	/*	@GetMapping("/demonstrativo/form")
	public ModelAndView demonstrativo(Demonstrativo demonstrativo) {
		ModelAndView modelAndView = new ModelAndView("financeiros/demonstrativos/demonstrativo");
		modelAndView.addObject("demonstrativo", demonstrativo);
		return modelAndView;
	}

	@PostMapping("/demonstrativo")
	public ModelAndView save(@Valid Demonstrativo demonstrativo, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/financeiros/");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		} else {
			demonstrativoRepository.save(demonstrativo);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("demonstrativo", demonstrativo);
		}		
		return modelAndView;
	}*/

	
}
