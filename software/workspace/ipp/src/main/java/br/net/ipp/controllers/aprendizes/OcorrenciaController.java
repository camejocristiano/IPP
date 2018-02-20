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

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.aprendizes.OcorrenciaRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.Ocorrencia;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class OcorrenciaController {

	private OcorrenciaRepository ocorrenciaRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	private EnumService enumService;
	
	@Autowired
	public OcorrenciaController(
			OcorrenciaRepository ocorrenciaRepository,
			UsuarioRepository usuarioRepository,
			JovemRepository jovemRepository,
			EnumService enumService
			) {
		this.ocorrenciaRepository = ocorrenciaRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
		this.enumService = new EnumService();
	}

	@GetMapping("/ocorrencias/{id}")
	public ModelAndView ocorrenciasJovem(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isOcorrenciaListar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/ocorrencias");
			modelAndView.addObject("jovem", jovem);
			List<String> tiposDeOcorrencias = this.enumService.carregarTipoDeOcorrencia();
			modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);
			modelAndView.addObject("ocorrencias", ocorrenciaRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/ocorrencia/form")
	public ModelAndView ocorrencia(Ocorrencia ocorrencia, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isOcorrenciaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/form");
			modelAndView.addObject("ocorrencia", ocorrencia);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			List<String> tiposDeOcorrencias = this.enumService.carregarTipoDeOcorrencia();
			modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/ocorrencia/form/{id}")
	public ModelAndView ocorrenciaJovem(@PathVariable Long id, Ocorrencia ocorrencia, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isOcorrenciaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/ocorrencia");
			modelAndView.addObject("ocorrencia", ocorrencia);
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			List<String> tiposDeOcorrencias = this.enumService.carregarTipoDeOcorrencia();
			modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/ocorrencia")
	public ModelAndView save(@Valid Ocorrencia ocorrencia, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(ocorrencia.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isOcorrenciaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/ocorrencia");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("ocorrencia", ocorrencia);
			} else {
				ocorrenciaRepository.save(ocorrencia);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("ocorrencia", ocorrencia);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> tiposDeOcorrencias = this.enumService.carregarTipoDeOcorrencia();
		modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/ocorrencia/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Ocorrencia ocorrencia = ocorrenciaRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(ocorrencia.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isOcorrenciaVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/ocorrencia");
			modelAndView.addObject("ocorrencia", ocorrencia);
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			List<String> tiposDeOcorrencias = this.enumService.carregarTipoDeOcorrencia();
			modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/ocorrencia/{id}")
	public ModelAndView update(@Valid Ocorrencia ocorrencia, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(ocorrencia.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isOcorrenciaEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/ocorrencias/ocorrencia");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("ocorrencia", ocorrencia);
			} else {
				ocorrenciaRepository.save(ocorrencia);
				modelAndView.addObject("ocorrencia", ocorrencia);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> tiposDeOcorrencias = this.enumService.carregarTipoDeOcorrencia();
		modelAndView.addObject("tiposDeOcorrencias", tiposDeOcorrencias);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
