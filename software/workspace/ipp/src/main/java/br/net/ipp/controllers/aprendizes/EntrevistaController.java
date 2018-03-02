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
import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.Entrevista;
import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
@Transactional
@RequestMapping("/sw")
public class EntrevistaController {

	private EntrevistaRepository entrevistaRepository;
	private JovemRepository jovemRepository;
	private EmpresaRepository empresaRepository;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private FichaProfissionalRepository fichaProfissionalRepository;
	
	@Autowired
	public EntrevistaController (
			EntrevistaRepository entrevistaRepository,
			JovemRepository jovemRepository,
			EmpresaRepository empresaRepository,
			UsuarioRepository usuarioRepository,
			GestorRepository gestorRepository, 
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			FichaProfissionalRepository fichaProfissionalRepository
			) {
		this.entrevistaRepository = entrevistaRepository;
		this.jovemRepository = jovemRepository;
		this.empresaRepository = empresaRepository;
		this.usuarioRepository = usuarioRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.fichaProfissionalRepository = fichaProfissionalRepository;
	}

	/**
	 * 
	 * @param entrevista
	 * @param id
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/entrevistaJovem/{id}")
	public ModelAndView entrevistaJovem(Entrevista entrevista, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Jovem jovem = jovemRepository.findOne(id);
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
			modelAndView.addObject("entrevista", entrevista);
			modelAndView.addObject("fichaProfissional", fichaProfissional);
			modelAndView.addObject("empresas", empresaRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+id);
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * 
	 * @param entrevista
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/entrevista")
	public ModelAndView save(@Valid Entrevista entrevista, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Jovem jovem = jovemRepository.findOne(entrevista.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("entrevista", entrevista);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			} else {
				entrevistaRepository.save(entrevista);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("entrevista", entrevista);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("empresas", empresaRepository.findAll());
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * 
	 * @param id
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/entrevista/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Entrevista entrevista = entrevistaRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(entrevista.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
			modelAndView.addObject("entrevista", entrevista);
			modelAndView.addObject("fichaProfissional", fichaProfissional);
			modelAndView.addObject("empresas", empresaRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * 
	 * @param entrevista
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/entrevista/{id}")
	public ModelAndView update(@Valid Entrevista entrevista, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Jovem jovem = jovemRepository.findOne(entrevista.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevista");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("entrevista", entrevista);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			} else {
				entrevistaRepository.save(entrevista);
				modelAndView.addObject("entrevista", entrevista);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
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
	
	/**
	 * 
	 * @param id
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/entrevistasJovem/{id}")
	public ModelAndView entrevistasJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
		} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
		} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
		}
		Jovem jovem = jovemRepository.findOne(id);
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem); 
		if (usuarioSessao.getGrupoDePermissoes().isEntrevistaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/entrevistas/entrevistas");
			modelAndView.addObject("jovem", jovem);
			if (entrevistaRepository.findAllByFichaProfissional(fichaProfissional).size() > 0) {
				modelAndView.addObject("entrevistas", entrevistaRepository.findAllByFichaProfissional(fichaProfissional));
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
