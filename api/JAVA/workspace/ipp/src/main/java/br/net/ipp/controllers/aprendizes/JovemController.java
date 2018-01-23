package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.AvaliacaoPAPEmpresaRepository;
import br.net.ipp.daos.aprendizes.AvaliacaoPAPIPPRepository;
import br.net.ipp.daos.aprendizes.AvaliacaoPIORepository;
import br.net.ipp.daos.aprendizes.AvaliacaoPITEPIPRepository;
import br.net.ipp.daos.aprendizes.CaracteristicasDomiciliaresRepository;
import br.net.ipp.daos.aprendizes.ContratacaoRepository;
import br.net.ipp.daos.aprendizes.DadosFinanceirosRepository;
import br.net.ipp.daos.aprendizes.DispensaRepository;
import br.net.ipp.daos.aprendizes.EntrevistaRepository;
import br.net.ipp.daos.aprendizes.EscolaridadeRepository;
import br.net.ipp.daos.aprendizes.FamiliarRepository;
import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.FichaSocialRepository;
import br.net.ipp.daos.aprendizes.HabilidadesRepository;
import br.net.ipp.daos.aprendizes.HistoricoRepository;
import br.net.ipp.daos.aprendizes.JaFoiAprendizRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.aprendizes.OcorrenciaRepository;
import br.net.ipp.daos.aprendizes.OutroCursoRepository;
import br.net.ipp.daos.aprendizes.SituacaoDeSaudeRepository;
import br.net.ipp.daos.aprendizes.SituacaoLaboralRepository;
import br.net.ipp.daos.configuracoes.CanalRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.enums.Area;
import br.net.ipp.enums.EstadoCivil;
import br.net.ipp.enums.Regiao;
import br.net.ipp.enums.RelacaoFuncional;
import br.net.ipp.enums.Sexo;
import br.net.ipp.enums.Status;
import br.net.ipp.enums.TipoDeInsercao;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Unidade;

@Controller
@Transactional
@RequestMapping("/jovens")
public class JovemController {

	private JovemRepository jovemRepository;
	private ContratacaoRepository contratacaoRepository;
	private DadosFinanceirosRepository dadosFinanceirosRepository;
	private DispensaRepository dispensaRepository;
	private EntrevistaRepository entrevistaRepository;
	private EscolaridadeRepository escolaridadeRepository;
	private FamiliarRepository familiarRepository;
	private FichaProfissionalRepository fichaProfissionalRepository;
	private FichaSocialRepository fichaSocialRepository;
	private HabilidadesRepository habilidadesRepository;
	private HistoricoRepository historicoRepository; 
	private AvaliacaoPITEPIPRepository avaliacaoPITEPIPRepository;
	private AvaliacaoPIORepository avaliacaoPIORepository;
	private AvaliacaoPAPIPPRepository avaliacaoPAPIPPRepository;
	private AvaliacaoPAPEmpresaRepository avaliacaoPAPEmpresaRepository;
	private OcorrenciaRepository ocorrenciaRepository;
	private OutroCursoRepository outrosCursosRepository;
	private SituacaoDeSaudeRepository situacaoDeSaudeRepository;
	private UnidadeRepository unidadeRepository;
	private CanalRepository canalRepository;
	private CaracteristicasDomiciliaresRepository caracteristicasDomiciliaresRepository;
	private SituacaoLaboralRepository situacaoLaboralRepository;
	private JaFoiAprendizRepository aprendizRepository;
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	public void JovemEndPoint(
			JovemRepository jovemRepository,
			ContratacaoRepository contratacaoRepository,
			DadosFinanceirosRepository dadosFinanceirosRepository,
			DispensaRepository dispensaRepository,
			EntrevistaRepository entrevistaRepository,
			EscolaridadeRepository escolaridadeRepository,
			FamiliarRepository familiarRepository,
			FichaProfissionalRepository fichaProfissionalRepository,
			FichaSocialRepository fichaSocialRepository,
			HabilidadesRepository habilidadesRepository,
			HistoricoRepository historicoRepository,
			AvaliacaoPITEPIPRepository avaliacaoPITEPIPRepository,
			AvaliacaoPIORepository avaliacaoPIORepository,
			AvaliacaoPAPIPPRepository avaliacaoPAPIPPRepository,
			AvaliacaoPAPEmpresaRepository avaliacaoPAPEmpresaRepository,
			OcorrenciaRepository ocorrenciaRepository,
			OutroCursoRepository outrosCursosRepository,
			SituacaoDeSaudeRepository situacaoDeSaudeRepository,
			UnidadeRepository unidadeRepository,
			CanalRepository canalRepository,
			CaracteristicasDomiciliaresRepository caracteristicasDomiciliaresRepository,
			SituacaoLaboralRepository situacaoLaboralRepository,
			JaFoiAprendizRepository aprendizRepository,
			MatriculaRepository matriculaRepository
			) {
		this.jovemRepository = jovemRepository;
		this.contratacaoRepository = contratacaoRepository;
		this.dadosFinanceirosRepository = dadosFinanceirosRepository;
		this.dispensaRepository = dispensaRepository;
		this.entrevistaRepository = entrevistaRepository;
		this.escolaridadeRepository = escolaridadeRepository;
		this.familiarRepository = familiarRepository;
		this.fichaProfissionalRepository = fichaProfissionalRepository;
		this.fichaSocialRepository = fichaSocialRepository;
		this.habilidadesRepository = habilidadesRepository;
		this.historicoRepository = historicoRepository;
		this.avaliacaoPITEPIPRepository = avaliacaoPITEPIPRepository;
		this.avaliacaoPIORepository = avaliacaoPIORepository;
		this.avaliacaoPAPIPPRepository = avaliacaoPAPIPPRepository;
		this.avaliacaoPAPEmpresaRepository = avaliacaoPAPEmpresaRepository;
		this.ocorrenciaRepository = ocorrenciaRepository;
		this.outrosCursosRepository = outrosCursosRepository;
		this.situacaoDeSaudeRepository = situacaoDeSaudeRepository;
		this.unidadeRepository = unidadeRepository;
		this.canalRepository = canalRepository;
		this.caracteristicasDomiciliaresRepository = caracteristicasDomiciliaresRepository;
		this.situacaoLaboralRepository = situacaoLaboralRepository;
		this.aprendizRepository = aprendizRepository;
		this.matriculaRepository = matriculaRepository;
	}

	@GetMapping("/form")
	public ModelAndView jovem(Jovem jovem) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
		modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
		modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		modelAndView.addObject("dispensas", dispensaRepository.findAll());
		modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAll());
		modelAndView.addObject("escolaridades", escolaridadeRepository.findAllByJovem(jovem));
		modelAndView.addObject("familiares", familiarRepository.findAllByJovem(jovem));
		modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
		modelAndView.addObject("fichasSociais", fichaSocialRepository.findAllByJovem(jovem));
		modelAndView.addObject("historicos", historicoRepository.findAll());
		modelAndView.addObject("avaliacoesPITsEPIPs", avaliacaoPITEPIPRepository.findAllByJovem(jovem));
		modelAndView.addObject("avaliacoesPIOs", avaliacaoPIORepository.findAllByJovem(jovem));
		modelAndView.addObject("avaliacoesPAPsIPP", avaliacaoPAPIPPRepository.findAllByJovem(jovem));
		modelAndView.addObject("avaliacoesPAPsEmpresa", avaliacaoPAPEmpresaRepository.findAllByJovem(jovem));
		modelAndView.addObject("habilidades", habilidadesRepository.findAll());
		modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAll());
		modelAndView.addObject("outrosCursos", outrosCursosRepository.findAllByJovem(jovem));
		modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAllByJovem(jovem));
		modelAndView.addObject("unidades", unidadeRepository.findAll());
		modelAndView.addObject("canais", canalRepository.findAll());
		modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliaresRepository.findAllByJovem(jovem));
		modelAndView.addObject("situacoesLaborais", situacaoLaboralRepository.findAllByJovem(jovem));
		modelAndView.addObject("aprendizes", aprendizRepository.findAllByJovem(jovem));
		modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		modelAndView.addObject("jovem", jovem);
		List<String> status = this.carregarStatus();
		modelAndView.addObject("status", status);
		List<String> sexo = this.carregarSexo();
		modelAndView.addObject("sexo", sexo);
		List<String> area = this.carregarArea();
		modelAndView.addObject("area", area);
		List<String> regiao = this.carregarRegiao();
		modelAndView.addObject("regiao", regiao);
		List<String> estadoCivil = this.carregarEstadoCivil();
		modelAndView.addObject("estadoCivil", estadoCivil);
		List<String> tipoDeInsercao = this.carregarTipoDeInsercao();
		modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Jovem jovem, BindingResult bindingResult) {
		Long id = null;
		ModelAndView modelAndView = null;
		if (bindingResult.hasErrors()) {
			modelAndView = new ModelAndView("redirect:/jovens/");
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAllByJovem(jovem));
			modelAndView.addObject("dispensas", dispensaRepository.findAll());
			modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
			modelAndView.addObject("escolaridades", escolaridadeRepository.findAllByJovem(jovem));
			modelAndView.addObject("familiares", familiarRepository.findAll());
			modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
			modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
			modelAndView.addObject("historicos", historicoRepository.findAll());
			modelAndView.addObject("avaliacoesPITsEPIPs", avaliacaoPITEPIPRepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPIOs", avaliacaoPIORepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPAPsIPP", avaliacaoPAPIPPRepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPAPsEmpresa", avaliacaoPAPEmpresaRepository.findAllByJovem(jovem));
			modelAndView.addObject("habilidades", habilidadesRepository.findAll());
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAllByJovem(jovem));
			modelAndView.addObject("outrosCursos", outrosCursosRepository.findAllByJovem(jovem));
			modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAllByJovem(jovem));
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			Unidade unidade = unidadeRepository.findOne((long) 1);
			modelAndView.addObject("unidade", unidade);
			modelAndView.addObject("canais", canalRepository.findAll());
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliaresRepository.findAllByJovem(jovem));
			modelAndView.addObject("situacoesLaborais", situacaoLaboralRepository.findAllByJovem(jovem));
			modelAndView.addObject("aprendizes", aprendizRepository.findAllByJovem(jovem));
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			List<String> status = this.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> sexo = this.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> area = this.carregarArea();
			modelAndView.addObject("area", area);
			List<String> regiao = this.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<String> estadoCivil = this.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> tipoDeInsercao = this.carregarTipoDeInsercao();
			modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
			
		} else {
			jovemRepository.save(jovem);
			Jovem jov = jovemRepository.findByEmail(jovem.getEmail());
			id = jov.getId();
			modelAndView = new ModelAndView("redirect:/jovens/"+id);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("jovem", jovem);		
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAllByJovem(jovem));
			modelAndView.addObject("dispensas", dispensaRepository.findAll());
			modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
			modelAndView.addObject("escolaridades", escolaridadeRepository.findAllByJovem(jovem));
			modelAndView.addObject("familiares", familiarRepository.findAll());
			modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
			modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
			modelAndView.addObject("historicos", historicoRepository.findAll());
			modelAndView.addObject("avaliacoesPITsEPIPs", avaliacaoPITEPIPRepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPIOs", avaliacaoPIORepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPAPsIPP", avaliacaoPAPIPPRepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPAPsEmpresa", avaliacaoPAPEmpresaRepository.findAllByJovem(jovem));
			modelAndView.addObject("habilidades", habilidadesRepository.findAll());
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAllByJovem(jovem));
			modelAndView.addObject("outrosCursos", outrosCursosRepository.findAllByJovem(jovem));
			modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAllByJovem(jovem));
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			Unidade unidade = unidadeRepository.findOne((long) 1);
			modelAndView.addObject("unidade", unidade);
			modelAndView.addObject("canais", canalRepository.findAll());
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliaresRepository.findAllByJovem(jovem));
			modelAndView.addObject("situacoesLaborais", situacaoLaboralRepository.findAllByJovem(jovem));
			modelAndView.addObject("aprendizes", aprendizRepository.findAllByJovem(jovem));
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			List<String> status = this.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> sexo = this.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> area = this.carregarArea();
			modelAndView.addObject("area", area);
			List<String> regiao = this.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<String> estadoCivil = this.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> tipoDeInsercao = this.carregarTipoDeInsercao();
			modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAllByJovem(jovem));
		modelAndView.addObject("dispensas", dispensaRepository.findAll());
		modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
		modelAndView.addObject("escolaridades", escolaridadeRepository.findAllByJovem(jovem));
		modelAndView.addObject("familiares", familiarRepository.findAll());
		modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
		modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
		modelAndView.addObject("historicos", historicoRepository.findAll());
		modelAndView.addObject("avaliacoesPITsEPIPs", avaliacaoPITEPIPRepository.findAllByJovem(jovem));
		modelAndView.addObject("avaliacoesPIOs", avaliacaoPIORepository.findAllByJovem(jovem));
		modelAndView.addObject("avaliacoesPAPsIPP", avaliacaoPAPIPPRepository.findAllByJovem(jovem));
		modelAndView.addObject("avaliacoesPAPsEmpresa", avaliacaoPAPEmpresaRepository.findAllByJovem(jovem));
		modelAndView.addObject("habilidades", habilidadesRepository.findAll());
		modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAllByJovem(jovem));
		modelAndView.addObject("outrosCursos", outrosCursosRepository.findAllByJovem(jovem));
		modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAllByJovem(jovem));
		modelAndView.addObject("unidades", unidadeRepository.findAll());
		Unidade unidade = unidadeRepository.findOne((long) 1);
		modelAndView.addObject("unidade", unidade);
		modelAndView.addObject("canais", canalRepository.findAll());
		modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliaresRepository.findAllByJovem(jovem));
		modelAndView.addObject("situacoesLaborais", situacaoLaboralRepository.findAllByJovem(jovem));
		modelAndView.addObject("aprendizes", aprendizRepository.findAllByJovem(jovem));
		modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		List<String> status = this.carregarStatus();
		modelAndView.addObject("status", status);
		List<String> sexo = this.carregarSexo();
		modelAndView.addObject("sexo", sexo);
		List<String> area = this.carregarArea();
		modelAndView.addObject("area", area);
		List<String> regiao = this.carregarRegiao();
		modelAndView.addObject("regiao", regiao);
		List<String> estadoCivil = this.carregarEstadoCivil();
		modelAndView.addObject("estadoCivil", estadoCivil);
		List<String> tipoDeInsercao = this.carregarTipoDeInsercao();
		modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Jovem jovem, BindingResult bindingResult) {
		Long id = jovem.getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAllByJovem(jovem));
			modelAndView.addObject("dispensas", dispensaRepository.findAll());
			modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
			modelAndView.addObject("escolaridades", escolaridadeRepository.findAllByJovem(jovem));
			modelAndView.addObject("familiares", familiarRepository.findAll());
			modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
			modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
			modelAndView.addObject("historicos", historicoRepository.findAll());
			modelAndView.addObject("avaliacoesPITsEPIPs", avaliacaoPITEPIPRepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPIOs", avaliacaoPIORepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPAPsIPP", avaliacaoPAPIPPRepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPAPsEmpresa", avaliacaoPAPEmpresaRepository.findAllByJovem(jovem));
			modelAndView.addObject("habilidades", habilidadesRepository.findAll());
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAllByJovem(jovem));
			modelAndView.addObject("outrosCursos", outrosCursosRepository.findAllByJovem(jovem));
			modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAllByJovem(jovem));
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			Unidade unidade = unidadeRepository.findOne((long) 1);
			modelAndView.addObject("unidade", unidade);
			modelAndView.addObject("canais", canalRepository.findAll());
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliaresRepository.findAllByJovem(jovem));
			modelAndView.addObject("situacoesLaborais", situacaoLaboralRepository.findAllByJovem(jovem));
			modelAndView.addObject("aprendizes", aprendizRepository.findAllByJovem(jovem));
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			List<String> status = this.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> sexo = this.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> area = this.carregarArea();
			modelAndView.addObject("area", area);
			List<String> regiao = this.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<String> estadoCivil = this.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> tipoDeInsercao = this.carregarTipoDeInsercao();
			modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
		} else {
			jovemRepository.save(jovem);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAllByJovem(jovem));
			modelAndView.addObject("dispensas", dispensaRepository.findAll());
			modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
			modelAndView.addObject("escolaridades", escolaridadeRepository.findAllByJovem(jovem));
			modelAndView.addObject("familiares", familiarRepository.findAll());
			modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
			modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
			modelAndView.addObject("historicos", historicoRepository.findAll());
			modelAndView.addObject("avaliacoesPITsEPIPs", avaliacaoPITEPIPRepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPIOs", avaliacaoPIORepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPAPsIPP", avaliacaoPAPIPPRepository.findAllByJovem(jovem));
			modelAndView.addObject("avaliacoesPAPsEmpresa", avaliacaoPAPEmpresaRepository.findAllByJovem(jovem));
			modelAndView.addObject("habilidades", habilidadesRepository.findAll());
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAllByJovem(jovem));
			modelAndView.addObject("outrosCursos", outrosCursosRepository.findAllByJovem(jovem));
			modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAllByJovem(jovem));
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			Unidade unidade = unidadeRepository.findOne((long) 1);
			modelAndView.addObject("unidade", unidade);
			modelAndView.addObject("canais", canalRepository.findAll());
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliaresRepository.findAllByJovem(jovem));
			modelAndView.addObject("situacoesLaborais", situacaoLaboralRepository.findAllByJovem(jovem));
			modelAndView.addObject("aprendizes", aprendizRepository.findAllByJovem(jovem));
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			List<String> status = this.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> sexo = this.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> area = this.carregarArea();
			modelAndView.addObject("area", area);
			List<String> regiao = this.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<String> estadoCivil = this.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> tipoDeInsercao = this.carregarTipoDeInsercao();
			modelAndView.addObject("tipoDeInsercao", tipoDeInsercao);
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
	
	public List<String> carregarSexo() {
		List<Sexo> lista = Arrays.asList(Sexo.values());
		List<String> sexo = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			sexo.add(lista.get(i).name());
		}
		return sexo;
	}

	public List<String> carregarArea() {
		List<Area> lista = Arrays.asList(Area.values());
		List<String> area = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			area.add(lista.get(i).name());
		}
		return area;
	}

	public List<String> carregarEstadoCivil() {
		List<EstadoCivil> lista = Arrays.asList(EstadoCivil.values());
		List<String> estadoCivil = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			estadoCivil.add(lista.get(i).name());
		}
		return estadoCivil;
	}
	
	public List<String> carregarRelacaoFuncional() {
		List<RelacaoFuncional> lista = Arrays.asList(RelacaoFuncional.values());
		List<String> relacaoFuncional = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			relacaoFuncional.add(lista.get(i).name());
		}
		return relacaoFuncional;
	}
	
	public List<String> carregarRegiao() {
		List<Regiao> lista = Arrays.asList(Regiao.values());
		List<String> regiao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			regiao.add(lista.get(i).name());
		}
		return regiao;
	}
	
	public List<String> carregarTipoDeInsercao() {
		List<TipoDeInsercao> lista = Arrays.asList(TipoDeInsercao.values());
		List<String> tipoDeInsercao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tipoDeInsercao.add(lista.get(i).name());
		}
		return tipoDeInsercao;
	}

}
