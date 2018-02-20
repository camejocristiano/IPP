package br.net.ipp.controllers.cursos;

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

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.ConteudoTeoricoBasicoRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.ConteudoTeoricoBasico;

@Controller
@Transactional
@RequestMapping("/sw")
public class ConteudoTeoricoBasicoController {

private ConteudoTeoricoBasicoRepository conteudoTeoricoBasicoRepository;
private UsuarioRepository usuarioRepository;

	@Autowired
	public void ConteudoTeoricoBasicoEndPoint(
			ConteudoTeoricoBasicoRepository conteudoTeoricoBasicoRepository,
			UsuarioRepository usuarioRepository
			) {
		this.conteudoTeoricoBasicoRepository = conteudoTeoricoBasicoRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/basicos")
	public ModelAndView basicos(ConteudoTeoricoBasico conteudoTeoricoBasico, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isBasicoListar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/basicos/basicos");
			modelAndView.addObject("basicos", conteudoTeoricoBasicoRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/basico/form")
	public ModelAndView conteudoTeoricoBasico(ConteudoTeoricoBasico conteudoTeoricoBasico, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isBasicoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/basicos/basico");
			modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/basico")
	public ModelAndView save(@Valid ConteudoTeoricoBasico conteudoTeoricoBasico, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isBasicoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/basicos/basico");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
			} else {
				conteudoTeoricoBasicoRepository.save(conteudoTeoricoBasico);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/basico/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isBasicoVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/basicos/basico");
			ConteudoTeoricoBasico conteudoTeoricoBasico = conteudoTeoricoBasicoRepository.findOne(id);
			modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/basico/{id}")
	public ModelAndView update(@Valid ConteudoTeoricoBasico conteudoTeoricoBasico, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isBasicoListar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/basicos/basico");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
			} else {
				conteudoTeoricoBasicoRepository.save(conteudoTeoricoBasico);
				modelAndView.addObject("conteudoTeoricoBasico", conteudoTeoricoBasico);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
