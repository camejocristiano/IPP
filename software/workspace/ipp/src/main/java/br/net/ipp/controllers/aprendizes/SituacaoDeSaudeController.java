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
import br.net.ipp.daos.aprendizes.SituacaoDeSaudeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.SituacaoDeSaude;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class SituacaoDeSaudeController {

	private SituacaoDeSaudeRepository situacaoDeSaudeRepository;
	private UsuarioRepository usuarioRepository;
	private JovemRepository jovemRepository;
	
	@Autowired
	public SituacaoDeSaudeController(
			SituacaoDeSaudeRepository situacaoDeSaudeRepository,
			UsuarioRepository usuarioRepository,
			JovemRepository jovemRepository
			) {
		this.situacaoDeSaudeRepository = situacaoDeSaudeRepository;
		this.usuarioRepository = usuarioRepository;
		this.jovemRepository = jovemRepository;
	}

	@GetMapping("/situacaoDeSaude/form")
	public ModelAndView situacaoDeSaude(SituacaoDeSaude situacaoDeSaude, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoDeSaudeCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/saudes/saude");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens/");			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/situacaoDeSaude/form/{id}")
	public ModelAndView situacaoDeSaudeJovem(SituacaoDeSaude situacaoDeSaude, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoDeSaudeCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/saudes/saude");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/situacaoDeSaude")
	public ModelAndView save(@Valid SituacaoDeSaude situacaoDeSaude, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(situacaoDeSaude.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoDeSaudeCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/saudes/saude");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			} else {
				situacaoDeSaudeRepository.save(situacaoDeSaude);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/situacaoDeSaude/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		SituacaoDeSaude situacaoDeSaude = situacaoDeSaudeRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(situacaoDeSaude.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoDeSaudeVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/saudes/saude");
			modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/situacaoDeSaude/{id}")
	public ModelAndView update(@Valid SituacaoDeSaude situacaoDeSaude, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(situacaoDeSaude.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoDeSaudeEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/saudes/saude");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			} else {
				situacaoDeSaudeRepository.save(situacaoDeSaude);
				modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
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
	
	@GetMapping("/situacaoDeSaudeJovem/{id}")
	public ModelAndView situacaoDeSaudeJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoDeSaudeVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/saudes/saude");
			modelAndView.addObject("jovem", jovem);
			if (situacaoDeSaudeRepository.findByJovem(jovem) != null) {
				modelAndView.addObject("situacaoDeSaude", situacaoDeSaudeRepository.findByJovem(jovem));
			} else {
				SituacaoDeSaude situacaoDeSaude = new SituacaoDeSaude();
				modelAndView.addObject("situacaoDeSaude", situacaoDeSaude);
			}
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
