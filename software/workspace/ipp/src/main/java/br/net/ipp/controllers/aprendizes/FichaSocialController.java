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

import br.net.ipp.daos.aprendizes.FichaSocialRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.FichaSocial;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class FichaSocialController {

	private FichaSocialRepository fichaSocialRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public FichaSocialController(
			FichaSocialRepository fichaSocialRepository,
			JovemRepository jovemRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository
			) {
		this.fichaSocialRepository = fichaSocialRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/fichaSocial/form")
	public ModelAndView fichaSocial(FichaSocial fichaSocial, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(fichaSocial.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFichaSocialCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/social");
			modelAndView.addObject("fichaSocial", fichaSocial);
			List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
			modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
			List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
			modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
			List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
			modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/fichaSocial/form/{id}")
	public ModelAndView fichaSocialJovem(FichaSocial fichaSocial, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isFichaSocialVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/social");
			modelAndView.addObject("fichaSocial", fichaSocial);
			modelAndView.addObject("jovem", jovem);
			List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
			modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
			List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
			modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
			List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
			modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/fichaSocial")
	public ModelAndView save(@Valid FichaSocial fichaSocial, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(fichaSocial.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFichaSocialVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/social");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("fichaSocial", fichaSocial);
				List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
				modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
				List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
				modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
				List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
				modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
			} else {
				fichaSocialRepository.save(fichaSocial);
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("fichaSocial", fichaSocial);
				List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
				modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
				List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
				modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
				List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
				modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/fichaSocial/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		FichaSocial fichaSocial = fichaSocialRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(fichaSocial.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFichaSocialVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/social");
			modelAndView.addObject("fichaSocial", fichaSocial);
			List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
			modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
			List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
			modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
			List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
			modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/fichaSocial/{id}")
	public ModelAndView update(@Valid FichaSocial fichaSocial, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(fichaSocial.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFichaSocialVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/social");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("fichaSocial", fichaSocial);
				List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
				modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
				List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
				modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
				List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
				modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
			} else {
				fichaSocialRepository.save(fichaSocial);
				modelAndView.addObject("fichaSocial", fichaSocial);
				List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
				modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
				List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
				modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
				List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
				modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
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

	@GetMapping("/fichaSocialJovem/{id}")
	public ModelAndView fichaSocialJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isFichaSocialVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/sociais/social");
			modelAndView.addObject("jovem", jovem);
			if (fichaSocialRepository.findByJovem(jovem) != null) {
				modelAndView.addObject("fichaSocial", fichaSocialRepository.findByJovem(jovem));
			} else {
				FichaSocial fichaSocial = new FichaSocial();
				modelAndView.addObject("fichaSocial", fichaSocial);
			}
			List<String> tiposDeMoradia = this.enumService.carregarTipoMoradia();
			modelAndView.addObject("tiposDeMoradia", tiposDeMoradia);
			List<String> situacoesDeMoradia = this.enumService.carregarSituacaoDaMoradia();
			modelAndView.addObject("situacoesDeMoradia", situacoesDeMoradia);
			List<String> tiposDeConstrucao = this.enumService.carregarTipoDeConstrucao();
			modelAndView.addObject("tiposDeConstrucao", tiposDeConstrucao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
