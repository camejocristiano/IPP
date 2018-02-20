package br.net.ipp.controllers.aprendizes;

import java.util.ArrayList;
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

import br.net.ipp.daos.aprendizes.EntrevistaRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.models.aprendizes.Entrevista;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class EntrevistaController {

	private EntrevistaRepository entrevistaRepository;
	private JovemRepository jovemRepository;
	private EmpresaRepository empresaRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public EntrevistaController (
			EntrevistaRepository entrevistaRepository,
			JovemRepository jovemRepository,
			EmpresaRepository empresaRepository,
			UsuarioRepository usuarioRepository
			) {
		this.entrevistaRepository = entrevistaRepository;
		this.jovemRepository = jovemRepository;
		this.empresaRepository = empresaRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/entrevista/form")
	public ModelAndView entrevista(Entrevista entrevista, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/entrevistaJovem/{id}")
	public ModelAndView entrevistaJovem(Entrevista entrevista, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
			modelAndView.addObject("entrevista", entrevista);
			modelAndView.addObject("empresas", empresaRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+id);
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/entrevista")
	public ModelAndView save(@Valid Entrevista entrevista, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(entrevista.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("entrevista", entrevista);
			} else {
				entrevistaRepository.save(entrevista);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("entrevista", entrevista);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("empresas", empresaRepository.findAll());
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/entrevista/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Entrevista entrevista = entrevistaRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(entrevista.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
			modelAndView.addObject("entrevista", entrevista);
			modelAndView.addObject("empresas", empresaRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/entrevista/{id}")
	public ModelAndView update(@Valid Entrevista entrevista, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(entrevista.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("entrevista", entrevista);
			} else {
				entrevistaRepository.save(entrevista);
				modelAndView.addObject("entrevista", entrevista);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}
			modelAndView.addObject("empresas", empresaRepository.findAll());	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/entrevistasJovem/{id}")
	public ModelAndView entrevistasJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevistas");
			modelAndView.addObject("jovem", jovem);
			if (entrevistaRepository.findAllByJovem(jovem).size() > 0) {
				modelAndView.addObject("entrevistas", entrevistaRepository.findAllByJovem(jovem));
			} else {
				List<Entrevista> entrevistas = new ArrayList<Entrevista>();
				modelAndView.addObject("entrevistas", entrevistas);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
