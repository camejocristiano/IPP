package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.FamiliarRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Familiar;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class FamiliarController {

	private FamiliarRepository familiarRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	private EnumService enumService;
	
	@Autowired
	public void FamiliarEndPoint(
			FamiliarRepository familiarRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository,
			EnumService enumService	
			) {
		this.familiarRepository = familiarRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/familiares/{id}")
	public ModelAndView familiaresJovem(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isFamiliarListar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiares");
			Jovem jovem = jovemRepository.findOne(id);
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("familiares", familiarRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/familiar/form")
	public ModelAndView familiar(Familiar familiar, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isFamiliarCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiar");
			modelAndView.addObject("familiar", familiar);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens/");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/familiar/form/{id}")
	public ModelAndView familiarJovem(Familiar familiar, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isFamiliarCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiar");
			modelAndView.addObject("familiar", familiar);
			Jovem jovem = jovemRepository.findOne(id);
			modelAndView.addObject("jovem", jovem);
			List<String> estadosCivis = this.enumService.carregarEstadoCivil();
			modelAndView.addObject("estadosCivis", estadosCivis);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/familiar")
	public ModelAndView save(@Valid Familiar familiar, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isFamiliarCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiar");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("familiar", familiar);
			} else {
				familiarRepository.save(familiar);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("familiar", familiar);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+familiar.getJovem().getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/familiar/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Familiar familiar = familiarRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isFamiliarVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiar");
			modelAndView.addObject("familiar", familiar);
			List<String> estadosCivis = this.enumService.carregarEstadoCivil();
			modelAndView.addObject("estadosCivis", estadosCivis);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+familiar.getJovem().getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/familiar/{id}")
	public ModelAndView update(@Valid Familiar familiar, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isFamiliarEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/familiares/familiar");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("familiar", familiar);
			} else {
				familiarRepository.save(familiar);
				modelAndView.addObject("familiar", familiar);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+familiar.getJovem().getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
