package br.net.ipp.controllers.configuracoes;

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

import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.GrupoDePermissoes;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.frequencias.Frequencia;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class GrupoDePermissoesController {

	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	private UnidadeRepository unidadesRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public GrupoDePermissoesController(
			GrupoDePermissoesRepository grupoDePermissoesRepository,
			UnidadeRepository unidadesRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository
			) {
		this.grupoDePermissoesRepository = grupoDePermissoesRepository;
		this.unidadesRepository = unidadesRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
	}
	
	@GetMapping("/gruposDePermissoes")
	public ModelAndView gruposDePermissoes(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isGrupoDePermissoesListar() == true) {
			modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/gruposDePermissoes");
			if (usuarioSessao.isAdmin() == true) {
				modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
			} else {
				modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAllByUnidade(usuarioSessao.getUnidade()));
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/grupoDePermissoes/form")
	public ModelAndView form(GrupoDePermissoes grupoDePermissoes, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isGrupoDePermissoesCadastrar() == true) {
			modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
			List<String> status = this.enumService.carregarStatus();
			modelAndView.addObject("status", status);
			modelAndView.addObject("unidades", unidadesRepository.findAll());
			modelAndView.addObject("pitepip", new Frequencia());
			modelAndView.addObject("usuarioSessao", usuarioSessao);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/grupoDePermissoes")
	public ModelAndView save(@Valid GrupoDePermissoes grupoDePermissoes, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isGrupoDePermissoesCadastrar() == true) {
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			} else {
				grupoDePermissoesRepository.save(grupoDePermissoes);
				modelAndView.addObject("color", "green");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/grupoDePermissoes/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isGrupoDePermissoesVisualizar() == true) {
			GrupoDePermissoes grupoDePermissoes = grupoDePermissoesRepository.findOne(id);
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
			List<String> status = this.enumService.carregarStatus();
			modelAndView.addObject("unidades", unidadesRepository.findAll());
			modelAndView.addObject("status", status);
			modelAndView.addObject("usuarioSessao", usuarioSessao);	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/grupoDePermissoes/{id}")
	public ModelAndView update(@Valid GrupoDePermissoes grupoDePermissoes, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/gruposDePermissoes/grupoDePermissoes");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isGrupoDePermissoesEditar() == true) {
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			} else {
				List<String> status = this.enumService.carregarStatus();
				modelAndView.addObject("unidades", unidadesRepository.findAll());
				modelAndView.addObject("status", status);
				grupoDePermissoesRepository.save(grupoDePermissoes);
				modelAndView.addObject("color", "green");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		}	
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

}
