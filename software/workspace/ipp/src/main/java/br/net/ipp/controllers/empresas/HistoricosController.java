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
import br.net.ipp.daos.empresas.HistoricosRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.Historicos;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
@Transactional
@RequestMapping("/sw")
public class HistoricosController {

	private HistoricosRepository historicosRepository;
	private EmpresaRepository empresaRepository;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	
		@Autowired
		public HistoricosController(
				HistoricosRepository historicosRepository,
				EmpresaRepository empresaRepository,
				UsuarioRepository usuarioRepository,
				GestorRepository gestorRepository,
				ContatoRepository contatoRepository,
				RepresentanteLegalRepository representanteLegalRepository
				) {
			this.historicosRepository = historicosRepository;
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
		 * 		List<Historicos> historicosDaEmpresa
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/historicos/empresa/{id}")
		public ModelAndView historicos(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isHistoricosListar() == true) {
				modelAndView = new ModelAndView("empresas/historicos/historicos");
				Empresa empresa = empresaRepository.findOne(id);
				if (usuarioSessao.isAdmin() == true) {
					modelAndView.addObject("historicos", historicosRepository.findAll());
					modelAndView.addObject("empresa", empresa);
				} else {
					modelAndView.addObject("historicos", historicosRepository.findByEmpresa(empresa));
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
		 * 		new Historicos
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/historico/empresa/form/{id}")
		public ModelAndView historicos(Historicos historicos, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isHistoricosCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/historicos/historico");
				modelAndView.addObject("historicos", historicos);
				modelAndView.addObject("empresa", empresaRepository.findOne(id));
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+id);
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param historicos
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		Historicos
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/historico/empresa")
		public ModelAndView save(@Valid Historicos historicos, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isHistoricosCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/historicos/historico");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("historicos", historicos);
					modelAndView.addObject("empresa", empresaRepository.findOne(historicos.getEmpresa().getId()));
				} else {
					historicosRepository.save(historicos);
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
					modelAndView.addObject("historicos", historicos);
					modelAndView.addObject("empresa", empresaRepository.findOne(historicos.getEmpresa().getId()));
				}		
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+historicos.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}

		/**
		 * 
		 * @param id
		 * @param userDetails
		 * @return
		 * 		Historicos
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/historico/empresa/{id}")
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
			Historicos historicos = historicosRepository.findOne(id);
			if (usuarioSessao.getGrupoDePermissoes().isHistoricosVisualizar() == true) {
				modelAndView = new ModelAndView("empresas/historicos/historico");
				modelAndView.addObject("historicos", historicos);
				modelAndView.addObject("empresa", empresaRepository.findOne(historicos.getEmpresa().getId()));
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+historicos.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param historicos
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		Historicos
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/historico/empresa/{id}")
		public ModelAndView update(@Valid Historicos historicos, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isHistoricosEditar() == true) {
				modelAndView = new ModelAndView("empresas/historicos/historico");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("historicos", historicos);
					modelAndView.addObject("empresa", empresaRepository.findOne(historicos.getEmpresa().getId()));
				} else {
					historicosRepository.save(historicos);
					modelAndView.addObject("historicos", historicos);
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
					modelAndView.addObject("empresa", empresaRepository.findOne(historicos.getEmpresa().getId()));
				}	
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+historicos.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}

}
