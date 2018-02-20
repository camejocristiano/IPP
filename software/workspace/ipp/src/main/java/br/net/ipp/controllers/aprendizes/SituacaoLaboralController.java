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
import br.net.ipp.daos.aprendizes.SituacaoLaboralRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.SituacaoLaboral;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class SituacaoLaboralController {

	private SituacaoLaboralRepository situacaoLaboralRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public SituacaoLaboralController(
			SituacaoLaboralRepository situacaoLaboralRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository
			) {
		this.situacaoLaboralRepository = situacaoLaboralRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/situacaoLaboral/form")
	public ModelAndView situacaoLaboral(SituacaoLaboral situacaoLaboral, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoLaboralCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/laboral");
			modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens/");			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/situacaoLaboral/form/{id}")
	public ModelAndView situacaoLaboralJovem(SituacaoLaboral situacaoLaboral, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoLaboralCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/laboral");
			Jovem jovem = jovemRepository.findOne(id);
			modelAndView.addObject("situacaoLaboral", situacaoLaboral);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovemRepository.findOne(id));			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/situacaoLaboral")
	public ModelAndView save(@Valid SituacaoLaboral situacaoLaboral, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoLaboralCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/laboral");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("situacaoLaboral", situacaoLaboral);
			} else {
				situacaoLaboralRepository.save(situacaoLaboral);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("situacaoLaboral", situacaoLaboral);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovemRepository.findOne(situacaoLaboral.getJovem().getId()));			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/situacaoLaboral/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		SituacaoLaboral situacaoLaboral = situacaoLaboralRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoLaboralCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/laboral");
			modelAndView.addObject("situacaoLaboral", situacaoLaboral);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovemRepository.findOne(situacaoLaboral.getJovem().getId()));			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/situacaoLaboral/{id}")
	public ModelAndView update(@Valid SituacaoLaboral situacaoLaboral, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoLaboralEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/laboral");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("situacaoLaboral", situacaoLaboral);
			} else {
				situacaoLaboralRepository.save(situacaoLaboral);
				modelAndView.addObject("situacaoLaboral", situacaoLaboral);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovemRepository.findOne(situacaoLaboral.getJovem().getId()));			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/situacaoLaboralJovem/{id}")
	public ModelAndView situacaoLaboralJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isSituacaoLaboralVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/laborais/laboral");
			Jovem jovem = jovemRepository.findOne(id);
			modelAndView.addObject("jovem", jovem);
			if (situacaoLaboralRepository.findByJovem(jovem) != null) {
				modelAndView.addObject("situacaoLaboral", situacaoLaboralRepository.findByJovem(jovem));
			} else {
				SituacaoLaboral situacaoLaboral = new SituacaoLaboral();
				modelAndView.addObject("situacaoLaboral", situacaoLaboral);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovemRepository.findOne(id));			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
