package br.net.ipp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.enums.Status;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
public class MainController {
	
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public MainController(
			UsuarioRepository usuarioRepository
			) {
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw");
		return modelAndView;
	}
	
	@GetMapping("/sw")
	public ModelAndView indexSW(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
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
		return modelAndView;
	}

}
