package br.net.ipp.controllers.aprendizes;

import java.util.ArrayList;
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

import br.net.ipp.daos.aprendizes.ContratacaoRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.models.aprendizes.Contratacao;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class ContratacaoController {

	private ContratacaoRepository contratacaoRepository;
	private JovemRepository jovemRepository;
	private EmpresaRepository empresaRepository;
	private GestorRepository gestorRepository;
	private CursoRepository cursoRepository;
	private EnumService enumService;
	
	@Autowired
	public ContratacaoController (
			ContratacaoRepository contratacaoRepository,
			JovemRepository jovemRepository,
			EmpresaRepository empresaRepository,
			GestorRepository gestorRepository,
			CursoRepository cursoRepository,
			EnumService enumService
			) {
		this.contratacaoRepository = contratacaoRepository;
		this.jovemRepository = jovemRepository;
		this.empresaRepository = empresaRepository;
		this.gestorRepository = gestorRepository;
		this.cursoRepository = cursoRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/contratacao/form")
	public ModelAndView contratacao(Contratacao contratacao) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
		modelAndView.addObject("contratacao", contratacao);
		return modelAndView;
	}
	
	@GetMapping("/contratacaoJovem/{id}")
	public ModelAndView contratacaoJovem(Contratacao contratacao, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("contratacao", contratacao);
		modelAndView.addObject("empresas", empresaRepository.findAll());
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("cursos", cursoRepository.findAll());
		modelAndView.addObject("gestores", gestorRepository.findAll());
		List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
		modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
		return modelAndView;
	}

	@PostMapping("/contratacao")
	public ModelAndView save(@Valid Contratacao contratacao, BindingResult bindingResult) {
		Long id = contratacao.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("contratacao", contratacao);
		} else {
			contratacaoRepository.save(contratacao);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("contratacao", contratacao);
		}		
		return modelAndView;
	}

	@GetMapping("/contratacao/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
		Contratacao contratacao = contratacaoRepository.findOne(id);
		modelAndView.addObject("contratacao", contratacao);
		modelAndView.addObject("empresas", empresaRepository.findAll());
		modelAndView.addObject("cursos", cursoRepository.findAll());
		modelAndView.addObject("gestores", gestorRepository.findAll());
		List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
		modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
		return modelAndView;
	}
	
	@PostMapping("/contratacao/{id}")
	public ModelAndView update(@Valid Contratacao contratacao, BindingResult bindingResult) {
		Long id = contratacao.getJovem().getId();
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("contratacao", contratacao);
		} else {
			contratacaoRepository.save(contratacao);
			modelAndView.addObject("contratacao", contratacao);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}
	
	@GetMapping("/contratacoesJovem/{id}")
	public ModelAndView contratacoesJovem(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacoes");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("jovem", jovem);
		if (contratacaoRepository.findAllByJovem(jovem).size() > 0) {
			modelAndView.addObject("contratacoes", contratacaoRepository.findAllByJovem(jovem));
		} else {
			List<Contratacao> contratacoes = new ArrayList<Contratacao>();
			modelAndView.addObject("contratacoes", contratacoes);
		}
		return modelAndView;
	}
	
}
