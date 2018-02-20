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
import br.net.ipp.daos.cursos.ConteudoTeoricoEspecificoRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.ConteudoTeoricoEspecifico;

@Controller
@Transactional
@RequestMapping("/sw")
public class ConteudoTeoricoEspecificoController {

private ConteudoTeoricoEspecificoRepository conteudoTeoricoEspecificoRepository;
private UsuarioRepository usuarioRepository;

	@Autowired
	public void ConteudoTeoricoEspecificoEndPoint(
			ConteudoTeoricoEspecificoRepository conteudoTeoricoEspecificoRepository,
			UsuarioRepository usuarioRepository
			) {
		this.conteudoTeoricoEspecificoRepository = conteudoTeoricoEspecificoRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/especificos")
	public ModelAndView especificos(ConteudoTeoricoEspecifico conteudoTeoricoEspecifico, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEspecificoListar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/especificos/especificos");
			modelAndView.addObject("especificos", conteudoTeoricoEspecificoRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/especifico/form")
	public ModelAndView conteudoTeoricoEspecifico(ConteudoTeoricoEspecifico conteudoTeoricoEspecifico, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEspecificoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/especificos/especifico");
			modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/especifico")
	public ModelAndView save(@Valid ConteudoTeoricoEspecifico conteudoTeoricoEspecifico, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEspecificoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/especificos/especifico");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
			} else {
				conteudoTeoricoEspecificoRepository.save(conteudoTeoricoEspecifico);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/especifico/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEspecificoVisualizar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/especificos/especifico");
			ConteudoTeoricoEspecifico conteudoTeoricoEspecifico = conteudoTeoricoEspecificoRepository.findOne(id);
			modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/homeCursos");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/especifico/{id}")
	public ModelAndView update(@Valid ConteudoTeoricoEspecifico conteudoTeoricoEspecifico, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEspecificoCadastrar() == true) {
			modelAndView = new ModelAndView("cursos/matrizes/especificos/especifico");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
			} else {
				conteudoTeoricoEspecificoRepository.save(conteudoTeoricoEspecifico);
				modelAndView.addObject("conteudoTeoricoEspecifico", conteudoTeoricoEspecifico);
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
