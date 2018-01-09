package br.net.ipp.controllers.aprendizes;

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
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.aprendizes.OcorrenciaRepository;
import br.net.ipp.daos.aprendizes.OutroCursoRepository;
import br.net.ipp.daos.aprendizes.SituacaoDeSaudeRepository;
import br.net.ipp.models.aprendizes.Jovem;

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
	private OcorrenciaRepository ocorrenciaRepository;
	private OutroCursoRepository outrosCursosRepository;
	private SituacaoDeSaudeRepository situacaoDeSaudeRepository;
	
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
			OcorrenciaRepository ocorrenciaRepository,
			OutroCursoRepository outrosCursosRepository,
			SituacaoDeSaudeRepository situacaoDeSaudeRepository
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
		this.ocorrenciaRepository = ocorrenciaRepository;
		this.outrosCursosRepository = outrosCursosRepository;
		this.situacaoDeSaudeRepository = situacaoDeSaudeRepository;
	}

	@GetMapping("/form")
	public ModelAndView jovem(Jovem jovem) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
		modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		modelAndView.addObject("dispensas", dispensaRepository.findAll());
		modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAll());
		modelAndView.addObject("escolaridades", escolaridadeRepository.findAll());
		modelAndView.addObject("familiares", familiarRepository.findAll());
		modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
		modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
		modelAndView.addObject("historicos", historicoRepository.findAll());
		modelAndView.addObject("habilidades", habilidadesRepository.findAll());
		modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAll());
		modelAndView.addObject("outrosCursos", outrosCursosRepository.findAll());
		modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAll());
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Jovem jovem, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAll());
			modelAndView.addObject("dispensas", dispensaRepository.findAll());
			modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
			modelAndView.addObject("escolaridades", escolaridadeRepository.findAll());
			modelAndView.addObject("familiares", familiarRepository.findAll());
			modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
			modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
			modelAndView.addObject("historicos", historicoRepository.findAll());
			modelAndView.addObject("habilidades", habilidadesRepository.findAll());
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAll());
			modelAndView.addObject("outrosCursos", outrosCursosRepository.findAll());
			modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAll());
		} else {
			jovemRepository.save(jovem);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("jovem", jovem);		
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAll());
			modelAndView.addObject("dispensas", dispensaRepository.findAll());
			modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
			modelAndView.addObject("escolaridades", escolaridadeRepository.findAll());
			modelAndView.addObject("familiares", familiarRepository.findAll());
			modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
			modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
			modelAndView.addObject("historicos", historicoRepository.findAll());
			modelAndView.addObject("habilidades", habilidadesRepository.findAll());
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAll());
			modelAndView.addObject("outrosCursos", outrosCursosRepository.findAll());
			modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAll());
			this.load(jovem.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/jovens/jovem");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
		modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAll());
		modelAndView.addObject("dispensas", dispensaRepository.findAll());
		modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
		modelAndView.addObject("escolaridades", escolaridadeRepository.findAll());
		modelAndView.addObject("familiares", familiarRepository.findAll());
		modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
		modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
		modelAndView.addObject("historicos", historicoRepository.findAll());
		modelAndView.addObject("habilidades", habilidadesRepository.findAll());
		modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAll());
		modelAndView.addObject("outrosCursos", outrosCursosRepository.findAll());
		modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAll());
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Jovem jovem, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAll());
			modelAndView.addObject("dispensas", dispensaRepository.findAll());
			modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
			modelAndView.addObject("escolaridades", escolaridadeRepository.findAll());
			modelAndView.addObject("familiares", familiarRepository.findAll());
			modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
			modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
			modelAndView.addObject("historicos", historicoRepository.findAll());
			modelAndView.addObject("habilidades", habilidadesRepository.findAll());
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAll());
			modelAndView.addObject("outrosCursos", outrosCursosRepository.findAll());
			modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAll());
		} else {
			jovemRepository.save(jovem);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("contratacoes", contratacaoRepository.findAll());
			modelAndView.addObject("dadosFinanceiros", dadosFinanceirosRepository.findAll());
			modelAndView.addObject("dispensas", dispensaRepository.findAll());
			modelAndView.addObject("entrevistas", entrevistaRepository.findAll());
			modelAndView.addObject("escolaridades", escolaridadeRepository.findAll());
			modelAndView.addObject("familiares", familiarRepository.findAll());
			modelAndView.addObject("fichasProfissionais", fichaProfissionalRepository.findAll());
			modelAndView.addObject("fichasSociais", fichaSocialRepository.findAll());
			modelAndView.addObject("historicos", historicoRepository.findAll());
			modelAndView.addObject("habilidades", habilidadesRepository.findAll());
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAll());
			modelAndView.addObject("outrosCursos", outrosCursosRepository.findAll());
			modelAndView.addObject("situacoesDeSaude", situacaoDeSaudeRepository.findAll());
		}	
		return modelAndView;
	}
	
}
