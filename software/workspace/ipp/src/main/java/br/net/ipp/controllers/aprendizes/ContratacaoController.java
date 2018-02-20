package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.ContratacaoRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.models.aprendizes.Contratacao;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
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
	private UsuarioRepository usuarioRepository;
	private MatriculaRepository matriculaRepository;
	
	@Autowired
	public ContratacaoController (
			ContratacaoRepository contratacaoRepository,
			JovemRepository jovemRepository,
			EmpresaRepository empresaRepository,
			GestorRepository gestorRepository,
			CursoRepository cursoRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository,
			MatriculaRepository matriculaRepository
			) {
		this.contratacaoRepository = contratacaoRepository;
		this.jovemRepository = jovemRepository;
		this.empresaRepository = empresaRepository;
		this.gestorRepository = gestorRepository;
		this.cursoRepository = cursoRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
		this.matriculaRepository = matriculaRepository;
	}

	@GetMapping("/contratacao/form")
	public ModelAndView contratacao(Contratacao contratacao, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			modelAndView.addObject("contratacao", contratacao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/contratacaoJovem/{id}")
	public ModelAndView contratacaoJovem(Contratacao contratacao, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			modelAndView.addObject("contratacao", contratacao);
			modelAndView.addObject("empresas", empresaRepository.findAll());
			modelAndView.addObject("cursos", cursoRepository.findAll());
			modelAndView.addObject("gestores", gestorRepository.findAll());
			List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
			modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/contratacao")
	public ModelAndView save(@Valid Contratacao contratacao, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(contratacao.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("contratacao", contratacao);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
				List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
				modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
				modelAndView.addObject("cursos", cursoRepository.findAll());
				modelAndView.addObject("gestores", gestorRepository.findAll());
			} else {
				contratacaoRepository.save(contratacao);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("contratacao", contratacao);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
				List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
				modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
				modelAndView.addObject("cursos", cursoRepository.findAll());
				modelAndView.addObject("gestores", gestorRepository.findAll());
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/contratacao/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Contratacao contratacao = contratacaoRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(contratacao.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			modelAndView.addObject("contratacao", contratacao);
			modelAndView.addObject("empresas", empresaRepository.findAll());
			List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
			modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
			modelAndView.addObject("cursos", cursoRepository.findAll());
			modelAndView.addObject("gestores", gestorRepository.findAll());
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/contratacao/{id}")
	public ModelAndView update(@Valid Contratacao contratacao, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(contratacao.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("contratacao", contratacao);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
				modelAndView.addObject("empresas", empresaRepository.findAll());
				List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
				modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
				modelAndView.addObject("cursos", cursoRepository.findAll());
				modelAndView.addObject("gestores", gestorRepository.findAll());
			} else {
				contratacaoRepository.save(contratacao);
				modelAndView.addObject("contratacao", contratacao);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
				modelAndView.addObject("empresas", empresaRepository.findAll());
				List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
				modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
				modelAndView.addObject("cursos", cursoRepository.findAll());
				modelAndView.addObject("gestores", gestorRepository.findAll());
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/contratacoesJovem/{id}")
	public ModelAndView contratacoesJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoListar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacoes");
			if (contratacaoRepository.findAllByJovem(jovem).size() > 0) {
				modelAndView.addObject("contratacoes", contratacaoRepository.findAllByJovem(jovem));
			} else {
				List<Contratacao> contratacoes = new ArrayList<Contratacao>();
				modelAndView.addObject("contratacoes", contratacoes);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
