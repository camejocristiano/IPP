package br.net.ipp.controllers.empresas;

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
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class GestorController {

	private ContatoRepository contatoRepository;
    private RepresentanteLegalRepository representanteLegalRepository;
    private GestorRepository gestorRepository;
    private EmpresaRepository empresaRepository;
	private UsuarioRepository usuarioRepository;
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	private EnumService enumService;
	
		@Autowired
		public GestorController(
				GestorRepository gestorRepository,
				ContatoRepository contatoRepository,
	    		RepresentanteLegalRepository representanteLegalRepository,
	    		EmpresaRepository empresaRepository,
				UsuarioRepository usuarioRepository,
				GrupoDePermissoesRepository grupoDePermissoesRepository,
				EnumService enumService
				) {
			this.gestorRepository = gestorRepository;
			this.contatoRepository = contatoRepository;
	        this.representanteLegalRepository = representanteLegalRepository;
	        this.empresaRepository = empresaRepository;
			this.usuarioRepository = usuarioRepository;
			this.grupoDePermissoesRepository = grupoDePermissoesRepository;
			this.enumService = new EnumService();
		}

		/**
		 * @param idEmpresa
		 * @param userDetails
		 * @return
		 * 		List<Gestor> gestoresDaEmpresa
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/gestores/{id}")
		public ModelAndView gestores(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
			ModelAndView modelAndView = null;
			User usuarioSessao = null;
			if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
			} else
			if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
			} else
			if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
			} else
			if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
			}
			Empresa empresa = empresaRepository.findOne(id);
			if (usuarioSessao.getGrupoDePermissoes().isGestorListar() == true) {
				modelAndView = new ModelAndView("empresas/gestores/gestores");
				if (usuarioSessao.isAdmin() == true) {
					modelAndView.addObject("gestores", gestorRepository.findAll());
					modelAndView.addObject("empresa", empresa);
					List<String> status = this.enumService.carregarStatus();
					modelAndView.addObject("status", status);
				} else {
					modelAndView.addObject("gestores", gestorRepository.findByEmpresa(empresa));
					modelAndView.addObject("empresa", empresa);
					List<String> status = this.enumService.carregarStatus();
					modelAndView.addObject("status", status);
				}
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+id);
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param idEmpresa
		 * @param userDetails
		 * @return
		 * 		new Gestor
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/gestor/form/{id}")
		public ModelAndView gestor(Gestor gestor, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
			ModelAndView modelAndView = null;
			User usuarioSessao = null;
			if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
			} else
			if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
			} else
			if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
			} else
			if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
			}
			if (usuarioSessao.getGrupoDePermissoes().isGestorCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/gestores/gestor");
				modelAndView.addObject("gestor", gestor);
				modelAndView.addObject("empresa", empresaRepository.findOne(id));
				modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
				List<String> status = this.enumService.carregarStatus();
				modelAndView.addObject("status", status);
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+id);
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param gestor
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		Gestor
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/gestor")
		public ModelAndView save(@Valid Gestor gestor, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
			ModelAndView modelAndView = null;
			User usuarioSessao = null;
			if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
			} else
			if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
			} else
			if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
			} else
			if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
			}
			if (usuarioSessao.getGrupoDePermissoes().isGestorCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/gestores/gestor");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("gestor", gestor);
					modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
					List<String> status = this.enumService.carregarStatus();
					modelAndView.addObject("status", status);
				} else {
					gestorRepository.save(gestor);
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
					modelAndView.addObject("gestor", gestor);
					modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
					List<String> status = this.enumService.carregarStatus();
					modelAndView.addObject("status", status);
				}		
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+gestor.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}

		/**
		 * 
		 * @param id
		 * @param userDetails
		 * @return
		 * 		Gestor
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/gestor/{id}")
		public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
			ModelAndView modelAndView = null;
			User usuarioSessao = null;
			if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
			} else
			if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
			} else
			if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
			} else
			if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
			}
			Gestor gestor = gestorRepository.findOne(id);
			if (usuarioSessao.getGrupoDePermissoes().isGestorVisualizar() == true) {
				modelAndView = new ModelAndView("empresas/gestores/gestor");
				modelAndView.addObject("gestor", gestor);
				modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
				List<String> status = this.enumService.carregarStatus();
				modelAndView.addObject("status", status);
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+gestor.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param gestor
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		Gestor
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/gestor/{id}")
		public ModelAndView update(@Valid Gestor gestor, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
			ModelAndView modelAndView = null;
			User usuarioSessao = null;
			if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
			} else
			if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
			} else
			if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
			} else
			if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
				usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
			}
			if (usuarioSessao.getGrupoDePermissoes().isGestorEditar() == true) {
				modelAndView = new ModelAndView("empresas/gestores/gestor");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("gestor", gestor);
					modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
					List<String> status = this.enumService.carregarStatus();
					modelAndView.addObject("status", status);
				} else {
					gestorRepository.save(gestor);
					modelAndView.addObject("gestor", gestor);
					modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
					List<String> status = this.enumService.carregarStatus();
					modelAndView.addObject("status", status);
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
				}	
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+gestor.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
	
}
