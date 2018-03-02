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
import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.CursoRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.Contratacao;
import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class ContratacaoController {

	private ContratacaoRepository contratacaoRepository;
	private FichaProfissionalRepository fichaProfissionalRepository;
	private EmpresaRepository empresaRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private CursoRepository cursoRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	private MatriculaRepository matriculaRepository;
	private JovemRepository jovemRepository;

	@Autowired
	public ContratacaoController(
			ContratacaoRepository contratacaoRepository,
			FichaProfissionalRepository fichaProfissionalRepository, 
			EmpresaRepository empresaRepository,
			GestorRepository gestorRepository, 
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository, 
			CursoRepository cursoRepository,
			EnumService enumService, 
			UsuarioRepository usuarioRepository, 
			MatriculaRepository matriculaRepository,
			JovemRepository jovemRepository
			) {
		this.contratacaoRepository = contratacaoRepository;
		this.fichaProfissionalRepository = fichaProfissionalRepository;
		this.empresaRepository = empresaRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.cursoRepository = cursoRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
		this.matriculaRepository = matriculaRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/contratacoes/profissional/{id}")
	public ModelAndView contratacao(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findOne(id);
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacoes");
			modelAndView.addObject("contratacoes",
					contratacaoRepository.findAllByFichaProfissional(fichaProfissionalRepository.findOne(id)));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/profissional/home/"+fichaProfissional.getJovem().getId());
		}
		modelAndView.addObject("jovem", fichaProfissional.getJovem());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/contratacao/profissional/{id}")
	public ModelAndView contratacaoFichaProfissional(Contratacao contratacao, @PathVariable("id") Long id,
			@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			modelAndView.addObject("contratacao", contratacao);
			modelAndView.addObject("fichaProfissional", fichaProfissionalRepository.findByJovem(jovem));
			modelAndView.addObject("empresas", empresaRepository.findAll());
			modelAndView.addObject("cursos", cursoRepository.findAll());
			modelAndView.addObject("gestores", gestorRepository.findAll());
			List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
			modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/profissional/home/" + jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/contratacao")
	public ModelAndView save(@Valid Contratacao contratacao, BindingResult bindingResult,
			@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findOne(contratacao.getFichaProfissional().getId());
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("contratacao", contratacao);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(fichaProfissional.getJovem()));
				List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
				modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
				modelAndView.addObject("cursos", cursoRepository.findAll());
				modelAndView.addObject("gestores", gestorRepository.findAll());
			} else {
				contratacaoRepository.save(contratacao);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("contratacao", contratacao);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(fichaProfissional.getJovem()));
				List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
				modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
				modelAndView.addObject("cursos", cursoRepository.findAll());
				modelAndView.addObject("gestores", gestorRepository.findAll());
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/" + fichaProfissional.getId());
		}
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("jovem", fichaProfissional.getJovem());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/contratacao/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Contratacao contratacao = contratacaoRepository.findOne(id);
		FichaProfissional fichaProfissional = fichaProfissionalRepository
				.findOne(contratacao.getFichaProfissional().getId());
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			modelAndView.addObject("contratacao", contratacao);
			modelAndView.addObject("empresas", empresaRepository.findAll());
			List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
			modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
			modelAndView.addObject("cursos", cursoRepository.findAll());
			modelAndView.addObject("gestores", gestorRepository.findAll());
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(fichaProfissional.getJovem()));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/" + fichaProfissional.getId());
		}
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("jovem", fichaProfissional.getJovem());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/contratacao/{id}")
	public ModelAndView update(@Valid Contratacao contratacao, BindingResult bindingResult,
			@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		FichaProfissional fichaProfissional = fichaProfissionalRepository
				.findOne(contratacao.getFichaProfissional().getId());
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacao");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("contratacao", contratacao);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(fichaProfissional.getJovem()));
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
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(fichaProfissional.getJovem()));
				modelAndView.addObject("empresas", empresaRepository.findAll());
				List<String> tiposDeContratacao = this.enumService.carregarTipoDeContratacao();
				modelAndView.addObject("tiposDeContratacao", tiposDeContratacao);
				modelAndView.addObject("cursos", cursoRepository.findAll());
				modelAndView.addObject("gestores", gestorRepository.findAll());
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/" + fichaProfissional.getId());
		}
		modelAndView.addObject("jovem", fichaProfissional.getJovem());
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/contratacoesFichaProfissional/{id}")
	public ModelAndView contratacoesFichaProfissional(@PathVariable("id") Long id,
			@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoListar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/contratacoes/contratacoes");
			if (contratacaoRepository.findAllByFichaProfissional(fichaProfissional).size() > 0) {
				modelAndView.addObject("contratacoes",
						contratacaoRepository.findByFichaProfissional(fichaProfissional));
			} else {
				List<Contratacao> contratacoes = new ArrayList<Contratacao>();
				modelAndView.addObject("contratacoes", contratacoes);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/" + fichaProfissional.getId());
		}
		modelAndView.addObject("jovem", fichaProfissional.getJovem());
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

}
