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

import br.net.ipp.daos.aprendizes.ContratacaoRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.enums.TipoDeContratacao;
import br.net.ipp.models.aprendizes.Contratacao;
import br.net.ipp.models.aprendizes.Jovem;

@Controller
@Transactional
@RequestMapping("/contratacoes")
public class ContratacaoController {

	private ContratacaoRepository contratacaoRepository;
	private JovemRepository jovemRepository;
	private EmpresaRepository empresaRepository;
	private GestorRepository gestorRepository;
	private CursoRepository cursoRepository;
	
	@Autowired
	public void ContratacaoEndPoint(
			ContratacaoRepository contratacaoRepository,
			JovemRepository jovemRepository,
			EmpresaRepository empresaRepository,
			GestorRepository gestorRepository,
			CursoRepository cursoRepository
			) {
		this.contratacaoRepository = contratacaoRepository;
		this.jovemRepository = jovemRepository;
		this.empresaRepository = empresaRepository;
		this.gestorRepository = gestorRepository;
		this.cursoRepository = cursoRepository;
	}

	@GetMapping("/form")
	public ModelAndView contratacao(Contratacao contratacao) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
		modelAndView.addObject("contratacao", contratacao);
		return modelAndView;
	}
	
	@GetMapping("/form/{id}")
	public ModelAndView contratacaoJovem(Contratacao contratacao, @PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
		Jovem jovem = jovemRepository.findOne(id);
		modelAndView.addObject("contratacao", contratacao);
		modelAndView.addObject("empresas", empresaRepository.findAll());
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("cursos", cursoRepository.findAll());
		modelAndView.addObject("gestores", gestorRepository.findAll());
		List<String> tiposDeContratacao = this.carregarTipoDeContratacao();
		modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Contratacao contratacao, BindingResult bindingResult) {
		Long jid = (long) 1;
		Jovem jovem = jovemRepository.findOne(jid);
		contratacao.setJovem(jovem);
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
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

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
		Contratacao contratacao = contratacaoRepository.findOne(id);
		modelAndView.addObject("contratacao", contratacao);
		modelAndView.addObject("empresas", empresaRepository.findAll());
		modelAndView.addObject("cursos", cursoRepository.findAll());
		modelAndView.addObject("gestores", gestorRepository.findAll());
		List<String> tiposDeContratacao = this.carregarTipoDeContratacao();
		modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Contratacao contratacao, BindingResult bindingResult) {
		Long id = (long) 1;
		ModelAndView modelAndView = new ModelAndView("redirect:/jovens/"+id);
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
	
	public List<String> carregarTipoDeContratacao() {
		List<TipoDeContratacao> lista = Arrays.asList(TipoDeContratacao.values());
		List<String> tiposDeContratacao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			tiposDeContratacao.add(lista.get(i).name());
		}
		return tiposDeContratacao;
	}
	
}
