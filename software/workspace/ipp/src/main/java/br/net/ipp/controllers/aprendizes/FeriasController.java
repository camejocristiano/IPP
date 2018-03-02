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

import br.net.ipp.daos.aprendizes.FeriasRepository;
import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.cursos.MatriculaRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.Ferias;
import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
@Transactional
@RequestMapping("/sw")
public class FeriasController {

	private FeriasRepository feriasRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	private MatriculaRepository matriculaRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private FichaProfissionalRepository fichaProfissionalRepository;
	
	@Autowired
	public FeriasController (
			FeriasRepository feriasRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository,
			MatriculaRepository matriculaRepository,
			GestorRepository gestorRepository, 
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			FichaProfissionalRepository fichaProfissionalRepository
			) {
		this.feriasRepository = feriasRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
		this.matriculaRepository = matriculaRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.fichaProfissionalRepository = fichaProfissionalRepository;
	}
	
	/**
	 * 
	 * @param ferias
	 * @param id
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/feriasJovem/{id}")
	public ModelAndView feriasJovem(Ferias ferias, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isFeriasCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			modelAndView.addObject("ferias", ferias);
			modelAndView.addObject("fichaProfissional", fichaProfissional);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * 
	 * @param ferias
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/ferias")
	public ModelAndView save(@Valid Ferias ferias, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(ferias.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isFeriasCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("fichaProfissional", fichaProfissional);
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("ferias", ferias);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			} else {
				feriasRepository.save(ferias);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("ferias", ferias);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * 
	 * @param id
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/ferias/{id}")
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
		Ferias ferias = feriasRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(ferias.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isFeriasVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			modelAndView.addObject("ferias", ferias);
			modelAndView.addObject("fichaProfissional", fichaProfissional);
			modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * 
	 * @param ferias
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/ferias/{id}")
	public ModelAndView update(@Valid Ferias ferias, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(ferias.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isFeriasEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/ferias");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("ferias", ferias);
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			} else {
				feriasRepository.save(ferias);
				modelAndView.addObject("ferias", ferias);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("matriculas", matriculaRepository.findAllByJovem(jovem));
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			}	
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
	@GetMapping("/feriassJovem/{id}")
	public ModelAndView feriassJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isFeriasListar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/ferias/feriass");
			if (feriasRepository.findAllByFichaProfissional(fichaProfissional).size() > 0) {
				modelAndView.addObject("feriass", feriasRepository.findAllByFichaProfissional(fichaProfissional));
			} else {
				List<Ferias> ferias = new ArrayList<Ferias>();
				modelAndView.addObject("ferias", ferias);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("fichaProfissional", fichaProfissional);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
