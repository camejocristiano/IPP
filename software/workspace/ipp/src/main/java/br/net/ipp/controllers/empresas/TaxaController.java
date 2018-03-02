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

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.daos.empresas.TaxaRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.models.empresas.Taxa;

@Controller
@Transactional
@RequestMapping("/sw")
public class TaxaController {
	
	private TaxaRepository taxaRepository;
	private EmpresaRepository empresaRepository;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	
		@Autowired
		public TaxaController(
				TaxaRepository taxaRepository,
				EmpresaRepository empresaRepository,
				UsuarioRepository usuarioRepository,
				GestorRepository gestorRepository,
				ContatoRepository contatoRepository,
				RepresentanteLegalRepository representanteLegalRepository
				) {
			this.taxaRepository = taxaRepository;
			this.empresaRepository = empresaRepository;
			this.usuarioRepository = usuarioRepository;
			this.gestorRepository = gestorRepository;
			this.contatoRepository = contatoRepository;
			this.representanteLegalRepository = representanteLegalRepository;
		}

		/**
		 * @param idEmpresa
		 * @param userDetails
		 * @return
		 * 		List<Taxa> taxasDaEmpresa
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/taxas/empresa/{id}")
		public ModelAndView taxas(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isTaxaListar() == true) {
				modelAndView = new ModelAndView("empresas/taxas/taxas");
				Empresa empresa = empresaRepository.findOne(id);
				if (usuarioSessao.isAdmin() == true) {
					modelAndView.addObject("taxas", taxaRepository.findAll());
					modelAndView.addObject("empresa", empresa);
				} else {
					modelAndView.addObject("taxas", taxaRepository.findByEmpresa(empresa));
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
		 * 		new Taxa
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/taxa/form/{id}")
		public ModelAndView taxa(Taxa taxa, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isTaxaCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/taxas/taxa");
				modelAndView.addObject("taxa", taxa);
				modelAndView.addObject("empresa", empresaRepository.findOne(id));
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+id);
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param taxa
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		Taxa
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/taxa")
		public ModelAndView save(@Valid Taxa taxa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isTaxaCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/taxas/taxa");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("taxa", taxa);
					modelAndView.addObject("empresa", empresaRepository.findOne(taxa.getEmpresa().getId()));
				} else {
					taxaRepository.save(taxa);
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
					modelAndView.addObject("taxa", taxa);
					modelAndView.addObject("empresa", empresaRepository.findOne(taxa.getEmpresa().getId()));
				}		
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+taxa.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}

		/**
		 * 
		 * @param id
		 * @param userDetails
		 * @return
		 * 		Taxa
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/taxa/{id}")
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
			Taxa taxa = taxaRepository.findOne(id);
			if (usuarioSessao.getGrupoDePermissoes().isTaxaVisualizar() == true) {
				modelAndView = new ModelAndView("empresas/taxas/taxa");
				modelAndView.addObject("taxa", taxa);
				modelAndView.addObject("empresa", empresaRepository.findOne(taxa.getEmpresa().getId()));
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+taxa.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param taxa
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		Taxa
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/taxa/{id}")
		public ModelAndView update(@Valid Taxa taxa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isTaxaEditar() == true) {
				modelAndView = new ModelAndView("empresas/taxas/taxa");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("taxa", taxa);
					modelAndView.addObject("empresa", empresaRepository.findOne(taxa.getEmpresa().getId()));
				} else {
					taxaRepository.save(taxa);
					modelAndView.addObject("taxa", taxa);
					modelAndView.addObject("empresa", empresaRepository.findOne(taxa.getEmpresa().getId()));
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
				}	
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+taxa.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}

}
