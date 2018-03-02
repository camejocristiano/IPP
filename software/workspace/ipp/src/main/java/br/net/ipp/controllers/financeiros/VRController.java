package br.net.ipp.controllers.financeiros;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.ContratacaoRepository;
import br.net.ipp.daos.aprendizes.DadosFinanceirosRepository;
import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
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
import br.net.ipp.models.financeiros.Parametro;
import br.net.ipp.models.financeiros.VR;
import br.net.ipp.models.frequencias.Frequencia;

@RestController
@Transactional
@RequestMapping("/sw")
public class VRController {

	private ContratacaoRepository contratacaoRepository;
	private JovemRepository jovemRepository;
	private FichaProfissionalRepository fichaProfissionalRepository;
	private EmpresaRepository empresaRepository;
	private ParametroRepository parametroRepository;
	private DadosFinanceirosRepository dadosFinanceirosRepository;
	Calendar c = Calendar.getInstance();
	private ContatoRepository contatoRepository;
    private RepresentanteLegalRepository representanteLegalRepository;
    private GestorRepository gestorRepository;
    private UsuarioRepository usuarioRepository;
    private MatriculaRepository matriculaRepository;
    private FrequenciaRepository frequenciaRepository;
	
	@Autowired
	public VRController(
			ContratacaoRepository contratacaoRepository,
			JovemRepository jovemRepository,
			FichaProfissionalRepository fichaProfissionalRepository,
			EmpresaRepository empresaRepository,
			ParametroRepository parametroRepository,
			DadosFinanceirosRepository dadosFinanceirosRepository,
			ContatoRepository contatoRepository,
    		RepresentanteLegalRepository representanteLegalRepository,
    		GestorRepository gestorRepository,
    		UsuarioRepository usuarioRepository,
    		MatriculaRepository matriculaRepository,
    		FrequenciaRepository frequenciaRepository
    		) {
		this.contratacaoRepository = contratacaoRepository;
		this.jovemRepository = jovemRepository;
		this.fichaProfissionalRepository = fichaProfissionalRepository;
		this.empresaRepository  = empresaRepository;
		this.parametroRepository = parametroRepository;
		this.frequenciaRepository = frequenciaRepository;
		this.dadosFinanceirosRepository = dadosFinanceirosRepository;
		this.contatoRepository = contatoRepository;
        this.representanteLegalRepository = representanteLegalRepository;
        this.gestorRepository = gestorRepository;
        this.usuarioRepository = usuarioRepository;
        this.matriculaRepository = matriculaRepository;
    }

	@GetMapping("/vrs")
	public ModelAndView vRs(@AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isVtListar() == true) {
			modelAndView = new ModelAndView("financeiros/vrs/vrs");
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/vr/{id}")
	public ModelAndView load(VR vr, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isVrVisualizar() == true) {
			modelAndView = new ModelAndView("financeiros/vrs/vr");
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
			
			String mes = Integer.toString(c.get(Calendar.MONTH)+1);
			
			vr.setMes(mes);
			vr.setCodigoDoJovem(jovem.getCodigoDoJovem());
			vr.setDataInicioContrato(dataDaContratacao);
			vr.setDataFimContrato(dataFIMDaContratacao);
			vr.setDiaSemana(matricula.getTurma().getDiaDaSemana().toString());
			vr.setDiasAPagar(Integer.toString(diasTrabalho));
			//vr.setValor(valor);
			
			modelAndView.addObject("vr", vr);
			
		} else {
			modelAndView = new ModelAndView("redirect:/sw/financeiros");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

}
