package br.net.ipp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.enums.Status;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
public class MainController {
	
	private UsuarioRepository usuarioRepository;
	private ContatoRepository contatoRepository;
    private RepresentanteLegalRepository representanteLegalRepository;
    private GestorRepository gestorRepository;
    private JovemRepository jovemRepository;
	
	@Autowired
	public MainController(
			UsuarioRepository usuarioRepository,
			ContatoRepository contatoRepository,
    		RepresentanteLegalRepository representanteLegalRepository,
    		GestorRepository gestorRepository,
    		JovemRepository jovemRepository
			) {
		this.usuarioRepository = usuarioRepository;
		this.contatoRepository = contatoRepository;
        this.representanteLegalRepository = representanteLegalRepository;
        this.gestorRepository = gestorRepository;
        this.jovemRepository = jovemRepository;
	}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw");
		return modelAndView;
	}
	
	@GetMapping("/sw")
	public ModelAndView indexSW(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
			if (usuarioSessao.getStatus() != null && usuarioSessao.getStatus().equals(Status.ATIVO)) {
				if (usuarioSessao.getGrupoDePermissoes().getStatus().equals(Status.ATIVO)) {
					modelAndView = new ModelAndView("index");
				} else {
					usuarioSessao.setGrupoDePermissoes(null);
					usuarioRepository.save(usuarioSessao);
					modelAndView = new ModelAndView("index");
				}
			} else {
				modelAndView = new ModelAndView("redirect:/logout");
			}	
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			Gestor usuarioSessao = gestorRepository.findByUsername(userDetails.getUsername());
			if (usuarioSessao.getStatus() != null && usuarioSessao.getStatus().equals(Status.ATIVO)) {
				if (usuarioSessao.getGrupoDePermissoes().getStatus().equals(Status.ATIVO)) {
					modelAndView = new ModelAndView("index");
				} else {
					usuarioSessao.setGrupoDePermissoes(null);
					gestorRepository.save(usuarioSessao);
					modelAndView = new ModelAndView("index");
				}
			} else {
				modelAndView = new ModelAndView("redirect:/logout");
			}	
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			RepresentanteLegal usuarioSessao = representanteLegalRepository.findByUsername(userDetails.getUsername());
			if (usuarioSessao.getStatus() != null && usuarioSessao.getStatus().equals(Status.ATIVO)) {
				if (usuarioSessao.getGrupoDePermissoes().getStatus().equals(Status.ATIVO)) {
					modelAndView = new ModelAndView("index");
				} else {
					usuarioSessao.setGrupoDePermissoes(null);
					representanteLegalRepository.save(usuarioSessao);
					modelAndView = new ModelAndView("index");
				}
			} else {
				modelAndView = new ModelAndView("redirect:/logout");
			}	
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		} else
		if (jovemRepository.findByUsername(userDetails.getUsername()) != null) {
			Jovem usuarioSessao = jovemRepository.findByUsername(userDetails.getUsername());
			if (usuarioSessao.getStatus() != null && usuarioSessao.getStatus().equals(Status.ATIVO)) {
				if (usuarioSessao.getGrupoDePermissoes().getStatus().equals(Status.ATIVO)) {
					modelAndView = new ModelAndView("index");
				} else {
					usuarioSessao.setGrupoDePermissoes(null);
					jovemRepository.save(usuarioSessao);
					modelAndView = new ModelAndView("index");
				}
			} else {
				modelAndView = new ModelAndView("redirect:/logout");
			}	
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			Contato usuarioSessao = contatoRepository.findByUsername(userDetails.getUsername());
			if (usuarioSessao.getStatus() != null && usuarioSessao.getStatus().equals(Status.ATIVO)) {
				if (usuarioSessao.getGrupoDePermissoes().getStatus().equals(Status.ATIVO)) {
					modelAndView = new ModelAndView("index");
				} else {
					usuarioSessao.setGrupoDePermissoes(null);
					contatoRepository.save(usuarioSessao);
					modelAndView = new ModelAndView("index");
				}
			} else {
				modelAndView = new ModelAndView("redirect:/logout");
			}	
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		}
		return modelAndView;
	}
	
	@GetMapping("/sw/configuracoes")
	public ModelAndView configuracoes(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/home");
		modelAndView.addObject("usuarioSessao", usuarioRepository.findByUsername(userDetails.getUsername()));
		return modelAndView;
	}

	@GetMapping("/sw/financeiros")
	public ModelAndView financeiros(@AuthenticationPrincipal UserDetails userDetails) {
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
			modelAndView = new ModelAndView("financeiros/home");
		} else {
			modelAndView = new ModelAndView("redirect:/sw/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
