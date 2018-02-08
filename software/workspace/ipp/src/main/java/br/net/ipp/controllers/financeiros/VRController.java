package br.net.ipp.controllers.financeiros;

import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.ContratacaoRepository;
import br.net.ipp.daos.aprendizes.DadosFinanceirosRepository;
import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.financeiros.ParametroRepository;
import br.net.ipp.models.aprendizes.Contratacao;
import br.net.ipp.models.aprendizes.DadosFinanceiros;
import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.financeiros.Parametro;

@RestController
@Transactional
@RequestMapping("/sw")
public class VRController {

	private ContratacaoRepository contratacaoRepository;
	private JovemRepository jovemRepository;
	private FichaProfissionalRepository fichaProfissionalRepository;
	private EmpresaRepository empresaRepository;
	// private MatriculaRepository matriculaRepository;
	private ParametroRepository parametroRepository;
	// private FrequenciaRepository frequenciaRepository;
	private DadosFinanceirosRepository dadosFinanceirosRepository;
	Calendar c = Calendar.getInstance();
	
	@Autowired
	public VRController(
			ContratacaoRepository contratacaoRepository,
			JovemRepository jovemRepository,
			FichaProfissionalRepository fichaProfissionalRepository,
			EmpresaRepository empresaRepository,
			//MatriculaRepository matriculaRepository,
			ParametroRepository parametroRepository,
			//FrequenciaRepository frequenciaRepository,
			DadosFinanceirosRepository dadosFinanceirosRepository
			) {
		this.contratacaoRepository = contratacaoRepository;
		this.jovemRepository = jovemRepository;
		this.fichaProfissionalRepository = fichaProfissionalRepository;
		this.empresaRepository  = empresaRepository;
		//this.matriculaRepository = matriculaRepository;
		this.parametroRepository = parametroRepository;
		//this.frequenciaRepository = frequenciaRepository;
		this.dadosFinanceirosRepository = dadosFinanceirosRepository;
	}

	@GetMapping("/vrs")
	public ModelAndView vRs() {
		ModelAndView modelAndView = new ModelAndView("financeiros/vrs/vrs");
		modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/vr/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("financeiros/vrs/vr");

		Contratacao contratacao = contratacaoRepository.findOne(id); // (dataDeAdmissao)
		Empresa empresa = empresaRepository.findOne((long) 1);
		Parametro parametro = parametroRepository.findOne((long) 1); //(taxaAdministracaoVR)
		Jovem jovem = jovemRepository.findOne(contratacao.getId());//código, nome, valorVR
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		DadosFinanceiros dadosFinanceiros = dadosFinanceirosRepository.findByJovem(jovem);
		
		modelAndView.addObject("contratacao", contratacao);
		modelAndView.addObject("empresa", empresa);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("dadosFinanceiros", dadosFinanceiros);
		modelAndView.addObject("parametro", parametro);

		return modelAndView;
	}

}
