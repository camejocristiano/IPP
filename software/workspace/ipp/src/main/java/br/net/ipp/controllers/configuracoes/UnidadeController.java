package br.net.ipp.controllers.configuracoes;

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

import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Unidade;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class UnidadeController {

	private UnidadeRepository unidadeRepository;
	private UsuarioRepository usuarioRepository;
	private EnumService enumService;
	private ContatoRepository contatoRepository;
    private RepresentanteLegalRepository representanteLegalRepository;
    private GestorRepository gestorRepository;
    
	@Autowired
	public UnidadeController(
			UnidadeRepository unidadeRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository,
			GestorRepository gestorRepository,
			ContatoRepository contatoRepository,
    		RepresentanteLegalRepository representanteLegalRepository
    		) {
		this.unidadeRepository = unidadeRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
        this.representanteLegalRepository = representanteLegalRepository;
	}
	
	@GetMapping("/unidades")
	public ModelAndView unidades(@AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.isAdmin() == true && usuarioSessao.getGrupoDePermissoes().isUnidadeListar() == true) {
			modelAndView = new ModelAndView("configuracoes/unidades/unidades");
			modelAndView.addObject("unidades", unidadeRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/unidade/"+usuarioSessao.getUnidade().getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/unidade/form")
	public ModelAndView unidade(Unidade unidade, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isUnidadeCadastrar() == true) {
			modelAndView = new ModelAndView("configuracoes/unidades/unidade");
			modelAndView.addObject("unidade", unidade);
			List<String> statuss = this.enumService.carregarStatus();
			modelAndView.addObject("statuss", statuss);	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/uni");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/unidade")
	public ModelAndView save(@Valid Unidade unidade, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isUnidadeCadastrar() == true) {
			modelAndView = new ModelAndView("configuracoes/unidades/unidade");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
				modelAndView.addObject("unidade", unidade);
				List<String> statuss = this.enumService.carregarStatus();
				modelAndView.addObject("statuss", statuss);	
			} else {
				unidadeRepository.save(unidade);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("unidade", unidade);
				List<String> statuss = this.enumService.carregarStatus();
				modelAndView.addObject("statuss", statuss);	
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/uni");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/unidade/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isUnidadeVisualizar() == true) {
			modelAndView = new ModelAndView("configuracoes/unidades/unidade");
			Unidade unidade = unidadeRepository.findOne(id);
			modelAndView.addObject("unidade", unidade);
			List<String> statuss = this.enumService.carregarStatus();
			modelAndView.addObject("statuss", statuss);	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/uni");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/unidade/{id}")
	public ModelAndView update(@Valid Unidade unidade, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		ModelAndView modelAndView = null; 
		if (usuarioSessao.getGrupoDePermissoes().isUnidadeEditar() == true) {
			modelAndView = new ModelAndView("configuracoes/unidades/unidade");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("unidade", unidade);
				List<String> statuss = this.enumService.carregarStatus();
				modelAndView.addObject("statuss", statuss);	
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
			} else {
				unidadeRepository.save(unidade);
				List<String> statuss = this.enumService.carregarStatus();
				modelAndView.addObject("statuss", statuss);	
				modelAndView.addObject("unidade", unidade);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}
		} else {
			return modelAndView = new ModelAndView("redirect:/sw/uni");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/uni")
	public ModelAndView uni(@AuthenticationPrincipal UserDetails userDetails) {
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
		Unidade unidade = unidadeRepository.findOne(usuarioSessao.getUnidade().getId());
		if (usuarioSessao.getGrupoDePermissoes().isUnidadeVisualizar()) {
			modelAndView = new ModelAndView("configuracoes/unidades/unidade");
			modelAndView.addObject("unidade", unidade);
			List<String> statuss = this.enumService.carregarStatus();
			modelAndView.addObject("statuss", statuss);	
			modelAndView.addObject("color", "orange");
			modelAndView.addObject("msg", "Sem Permissão ou INATIVA!");
		} else {
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("color", "orange");
			modelAndView.addObject("msg", "Sem Permissão ou INATIVA!");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
