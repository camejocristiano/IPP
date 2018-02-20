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

import br.net.ipp.daos.aprendizes.EscolaridadeRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Escolaridade;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class EscolaridadeController {

	private EscolaridadeRepository escolaridadeRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void EscolaridadeEndPoint(
			EscolaridadeRepository escolaridadeRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository
			) {
		this.escolaridadeRepository = escolaridadeRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/escolaridade/form")
	public ModelAndView escolaridadeNull(Jovem jovem, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEscolaridadeVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
			modelAndView.addObject("jovem", jovem);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/escolaridade/form/{id}")
	public ModelAndView escolaridade(Escolaridade escolaridade, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isEscolaridadeVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
			modelAndView.addObject("escolaridade", escolaridade);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());
			modelAndView.addObject("jovem", jovem);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/escolaridade")
	public ModelAndView save(@Valid Escolaridade escolaridade, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		Long id = escolaridade.getJovem().getId();
		Jovem jovem = jovemRepository.findOne(id);
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEscolaridadeVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
			modelAndView.addObject("jovem", jovem);
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("escolaridade", escolaridade);
				modelAndView.addObject("jovem", jovem);
			} else {
				escolaridadeRepository.save(escolaridade);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("escolaridade", escolaridade);
				modelAndView.addObject("jovem", jovem);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/escolaridade/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Escolaridade escolaridade = escolaridadeRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(escolaridade.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isEscolaridadeVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
			modelAndView.addObject("escolaridade", escolaridade);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());
			modelAndView.addObject("jovem", jovem);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/escolaridade/{id}")
	public ModelAndView update(@Valid Escolaridade escolaridade, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(escolaridade.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isEscolaridadeVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
				modelAndView.addObject("escolaridade", escolaridade);
				modelAndView.addObject("jovem", jovem);
			} else {
				escolaridadeRepository.save(escolaridade);
				modelAndView.addObject("escolaridade", escolaridade);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("jovem", jovem);
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());
			modelAndView.addObject("jovem", jovem);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/escolaridadeJovem/{id}")
	public ModelAndView escolaridadeJovem(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEscolaridadeVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/escolaridades/escolaridade");
			Jovem jovem = jovemRepository.findOne(id);
			if (escolaridadeRepository.findByJovem(jovem) != null) {
				modelAndView.addObject("escolaridade", escolaridadeRepository.findByJovem(jovem));
				modelAndView.addObject("jovem", jovem);
			} else {
				Escolaridade escolaridade = new Escolaridade();
				modelAndView.addObject("escolaridade", escolaridade);
				modelAndView.addObject("jovem", jovem);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		}
	modelAndView.addObject("usuarioSessao", usuarioSessao);
	return modelAndView;
	}
	
}
