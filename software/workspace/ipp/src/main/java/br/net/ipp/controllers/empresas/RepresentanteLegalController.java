package br.net.ipp.controllers.empresas;

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

@Controller
@Transactional
@RequestMapping("/sw")
public class RepresentanteLegalController {

	private RepresentanteLegalRepository representanteLegalRepository;
	private EmpresaRepository empresaRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private UsuarioRepository usuarioRepository;
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	
		@Autowired
		public RepresentanteLegalController (
			    RepresentanteLegalRepository representanteLegalRepository,
				EmpresaRepository empresaRepository,
				GestorRepository gestorRepository,
				ContatoRepository contatoRepository,
				UsuarioRepository usuarioRepository,
				GrupoDePermissoesRepository grupoDePermissoesRepository
				) {
			this.representanteLegalRepository = representanteLegalRepository;
			this.empresaRepository = empresaRepository;
			this.gestorRepository = gestorRepository;
			this.contatoRepository = contatoRepository;
			this.usuarioRepository = usuarioRepository;
			this.grupoDePermissoesRepository = grupoDePermissoesRepository;
		}

		/**
		 * @param idEmpresa
		 * @param userDetails
		 * @return
		 * 		List<RepresentanteLegal> representantesLegaisDaEmpresa
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/representantes/{id}")
		public ModelAndView representantesLegais(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isRepresentanteLegalListar() == true) {
				modelAndView = new ModelAndView("empresas/representantes/representantes");
				if (usuarioSessao.isAdmin() == true) {
					modelAndView.addObject("representantes", representanteLegalRepository.findAll());
					modelAndView.addObject("empresa", empresa);
				} else {
					modelAndView.addObject("representantes", representanteLegalRepository.findByEmpresa(empresa));
					modelAndView.addObject("empresa", empresa);
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
		 * 		new RepresentanteLegal
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/representante/form/{id}")
		public ModelAndView representanteLegal(RepresentanteLegal representanteLegal, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isRepresentanteLegalCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/representantes/representante");
				modelAndView.addObject("representanteLegal", representanteLegal);
				modelAndView.addObject("empresa", empresaRepository.findOne(id));
				modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+id);
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param representanteLegal
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		RepresentanteLegal
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/representante")
		public ModelAndView save(@Valid RepresentanteLegal representanteLegal, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isRepresentanteLegalCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/representantes/representante");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("representanteLegal", representanteLegal);
					modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
				} else {
					representanteLegalRepository.save(representanteLegal);
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
					modelAndView.addObject("representanteLegal", representanteLegal);
					modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
				}		
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+representanteLegal.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}

		/**
		 * 
		 * @param id
		 * @param userDetails
		 * @return
		 * 		RepresentanteLegal
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/representante/{id}")
		public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
			ModelAndView modelAndView = null;
			User usuarioSessao = null;
			RepresentanteLegal representanteLegal = representanteLegalRepository.findOne(id);
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
			if (usuarioSessao.getGrupoDePermissoes().isRepresentanteLegalVisualizar() == true) {
				modelAndView = new ModelAndView("empresas/representantes/representante");
				modelAndView.addObject("representanteLegal", representanteLegal);
				modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+representanteLegal.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param representanteLegal
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		RepresentanteLegal
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/representante/{id}")
		public ModelAndView update(@Valid RepresentanteLegal representanteLegal, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isRepresentanteLegalEditar() == true) {
				modelAndView = new ModelAndView("empresas/representantes/representante");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("representanteLegal", representanteLegal);
					modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
				} else {
					representanteLegalRepository.save(representanteLegal);
					modelAndView.addObject("representanteLegal", representanteLegal);
					modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
				}	
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+representanteLegal.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
	
}
