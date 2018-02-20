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

import br.net.ipp.daos.aprendizes.HabilidadesRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Habilidades;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class HabilidadesController {

	private HabilidadesRepository habilidadesRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public HabilidadesController(
			HabilidadesRepository habilidadesRepository,
			JovemRepository jovemRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository
			) {
		this.habilidadesRepository = habilidadesRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/habilidade/form")
	public ModelAndView habilidades(Habilidades habilidades, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isHabilidadesCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
			modelAndView.addObject("habilidades", habilidades);
			List<String> habilidadesManuais = this.enumService.carregarHabilidadesManuais();
			modelAndView.addObject("habilidadesManuais", habilidadesManuais);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens/");			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/habilidade/form/{id}")
	public ModelAndView habilidadesJovem(Habilidades habilidades, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isHabilidadesCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
			modelAndView.addObject("habilidades", habilidades);
			List<String> habilidadesManuais = this.enumService.carregarHabilidadesManuais();
			modelAndView.addObject("habilidadesManuais", habilidadesManuais);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/habilidade")
	public ModelAndView save(@Valid Habilidades habilidades, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(habilidades.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isHabilidadesCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("habilidades", habilidades);
			} else {
				habilidadesRepository.save(habilidades);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("habilidades", habilidades);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/habilidade/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Habilidades habilidades = habilidadesRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(habilidades.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isHabilidadesVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
			modelAndView.addObject("habilidades", habilidades);
			List<String> habilidadesManuais = this.enumService.carregarHabilidadesManuais();
			modelAndView.addObject("habilidadesManuais", habilidadesManuais);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/habilidade/{id}")
	public ModelAndView update(@Valid Habilidades habilidades, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(habilidades.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isHabilidadesEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("habilidades", habilidades);
			} else {
				habilidadesRepository.save(habilidades);
				modelAndView.addObject("habilidades", habilidades);
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
	
	@GetMapping("/habilidadeJovem/{id}")
	public ModelAndView habilidadeJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isHabilidadesVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/habilidades/habilidade");
			modelAndView.addObject("jovem", jovem);
			if (habilidadesRepository.findByJovem(jovem) != null) {
				modelAndView.addObject("habilidades", habilidadesRepository.findByJovem(jovem));			
			} else {
				Habilidades habilidades = new Habilidades();
				modelAndView.addObject("habilidades", habilidades);
			}
			List<String> habilidadesManuais = this.enumService.carregarHabilidadesManuais();
			modelAndView.addObject("habilidadesManuais", habilidadesManuais);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
