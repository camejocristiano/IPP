package br.net.ipp.controllers.configuracoes;

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

import br.net.ipp.daos.configuracoes.CanalRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.Canal;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class CanalController {

	private CanalRepository canalRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public CanalController(
			CanalRepository canalRepository, 
			UsuarioRepository usuarioRepository
			) {
		this.canalRepository = canalRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/canais")
	public ModelAndView index(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCanalListar() == true) {
			modelAndView = new ModelAndView("configuracoes/canais/canais");
			modelAndView.addObject("canais", canalRepository.findAll());
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		}
		return modelAndView;
	}

	@GetMapping("/canal/form")
	public ModelAndView canal(Canal canal, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCanalCadastrar() == true) {
			modelAndView = new ModelAndView("configuracoes/canais/canal");
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		}
		return modelAndView;
	}

	@PostMapping("/canal")
	public ModelAndView save(@Valid Canal canal, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/canais/canal");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCanalCadastrar() == true) {
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("canal", canal);
			} else {
				canalRepository.save(canal);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("canal", canal);
				modelAndView.addObject("usuarioSessao", usuarioSessao);				
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		}
		return modelAndView;
	}

	@GetMapping("/canal/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCanalVisualizar() == true) {
			modelAndView = new ModelAndView("configuracoes/canais/canal");
			modelAndView.addObject("canal", canalRepository.findOne(id));
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		}
		return modelAndView;
	}

	@PostMapping("/canal/{id}")
	public ModelAndView update(@Valid Canal canal, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/canais/canal");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCanalEditar() == true) {
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Sem Permissão");
				modelAndView.addObject("canal", canal);
				modelAndView.addObject("usuarioSessao", usuarioSessao);
	
			} else {
				canalRepository.save(canal);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("canal", canal);
				modelAndView.addObject("usuarioSessao", usuarioSessao);
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		}
		return modelAndView;
	}
}