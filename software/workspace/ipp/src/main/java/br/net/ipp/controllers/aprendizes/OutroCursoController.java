package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.aprendizes.OutroCursoRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.OutroCurso;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class OutroCursoController {

	private OutroCursoRepository outroCursoRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public OutroCursoController(
			OutroCursoRepository outroCursoRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository
			) {
		this.outroCursoRepository = outroCursoRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/outrosCursos/{id}")
	public ModelAndView outrosCursosJovem(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isOutroCursoListar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/cursos/cursos");
			modelAndView.addObject("outrosCursos", outroCursoRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/outroCursoForm/{id}")
	public ModelAndView outroCursoJovem(OutroCurso outroCurso, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isOutroCursoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/cursos/curso");
			modelAndView.addObject("outroCurso", outroCurso);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/outroCurso")
	public ModelAndView save(@Valid OutroCurso outroCurso, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(outroCurso.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isOutroCursoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/cursos/curso");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("outroCurso", outroCurso);
			} else {
				outroCursoRepository.save(outroCurso);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("outroCurso", outroCurso);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/outroCurso/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		OutroCurso outroCurso = outroCursoRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(outroCurso.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isOutroCursoVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/cursos/curso");
			modelAndView.addObject("outroCurso", outroCurso);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/outroCurso/{id}")
	public ModelAndView update(@Valid OutroCurso outroCurso, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(outroCurso.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isOutroCursoEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/cursos/curso");
				if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("outroCurso", outroCurso);
			} else {
				outroCursoRepository.save(outroCurso);
				modelAndView.addObject("outroCurso", outroCurso);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
