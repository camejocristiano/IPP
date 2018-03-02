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

import br.net.ipp.daos.aprendizes.DispensaRepository;
import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.Dispensa;
import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class DispensaController {

	private DispensaRepository dispensaRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private FichaProfissionalRepository fichaProfissionalRepository;
	
	@Autowired
	public DispensaController (
			DispensaRepository dispensaRepository,
			JovemRepository jovemRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository,
			GestorRepository gestorRepository, 
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			FichaProfissionalRepository fichaProfissionalRepository
			) {
		this.dispensaRepository = dispensaRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.fichaProfissionalRepository = fichaProfissionalRepository;
	}

	/**
	 * 
	 * @param dispensa
	 * @param id
	 * @param userDetails
	 * @return
	 */
	@GetMapping("/dispensaJovem/{id}")
	public ModelAndView dispensaJovem(Dispensa dispensa, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isDispensaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
			modelAndView.addObject("dispensa", dispensa);
			modelAndView.addObject("fichaProfissional", fichaProfissional);
			List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
			modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * 
	 * @param dispensa
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/dispensa")
	public ModelAndView save(@Valid Dispensa dispensa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(dispensa.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isDispensaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "oranges");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
				modelAndView.addObject("dispensa", dispensa);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			} else {
				dispensaRepository.save(dispensa);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("dispensa", dispensa);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
		modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
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
	@GetMapping("/dispensa/{id}")
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
		Dispensa dispensa = dispensaRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(dispensa.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isDispensaVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("dispensa", dispensa);
			modelAndView.addObject("fichaProfissional", fichaProfissional);
			List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
			modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * 
	 * @param dispensa
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 */
	@PostMapping("/dispensa/{id}")
	public ModelAndView update(@Valid Dispensa dispensa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(dispensa.getFichaProfissional().getJovem().getId());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isDispensaEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("dispensa", dispensa);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			} else {
				dispensaRepository.save(dispensa);
				modelAndView.addObject("dispensa", dispensa);				
				modelAndView.addObject("fichaProfissional", fichaProfissional);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
		modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
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
	@GetMapping("/dispensasJovem/{id}")
	public ModelAndView dispensasJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isDispensaListar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensas");
			modelAndView.addObject("jovem", jovem);
			if (dispensaRepository.findAllByFichaProfissional(fichaProfissional) != null) {
				modelAndView.addObject("dispensas", dispensaRepository.findAllByFichaProfissional(fichaProfissional));
			} else {
				List<Dispensa> dispensas = new ArrayList<Dispensa>();
				modelAndView.addObject("dispensas", dispensas);
			}
			List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
			modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
