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
import br.net.ipp.daos.empresas.EmpresaRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.daos.empresas.CargaHorariaRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.models.empresas.CargaHoraria;
import br.net.ipp.models.empresas.Contato;

@Controller
@Transactional
@RequestMapping("/sw")
public class CargaHorariaController {

	private CargaHorariaRepository cargaHorariaRepository;
	private EmpresaRepository empresaRepository;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	
		@Autowired
		public CargaHorariaController(
				CargaHorariaRepository cargaHorariaRepository,
				EmpresaRepository empresaRepository,
				UsuarioRepository usuarioRepository,
				GestorRepository gestorRepository,
				ContatoRepository contatoRepository,
				RepresentanteLegalRepository representanteLegalRepository
				) {
			this.cargaHorariaRepository = cargaHorariaRepository;
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
		 * 		List<CargaHoraria> cargasHorariasDaEmpresa
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/cargas/empresa/{id}")
		public ModelAndView cargasHorarias(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isCargaHorariaListar() == true) {
				modelAndView = new ModelAndView("empresas/cargas/cargas");
				Empresa empresa = empresaRepository.findOne(id);
				if (usuarioSessao.isAdmin() == true) {
					modelAndView.addObject("cargasHorarias", cargaHorariaRepository.findAll());
					modelAndView.addObject("empresa", empresa);
				} else {
					modelAndView.addObject("cargasHorarias", cargaHorariaRepository.findByEmpresa(empresa));
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
		 * 		new CargaHoraria
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/carga/form/{id}")
		public ModelAndView cargaHoraria(CargaHoraria cargaHoraria, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isCargaHorariaCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/cargas/carga");
				modelAndView.addObject("cargaHoraria", cargaHoraria);
				modelAndView.addObject("empresa", empresaRepository.findOne(id));
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+id);
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param cargaHoraria
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		CargaHoraria
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/carga")
		public ModelAndView save(@Valid CargaHoraria cargaHoraria, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isCargaHorariaCadastrar() == true) {
				modelAndView = new ModelAndView("empresas/cargas/carga");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("cargaHoraria", cargaHoraria);
					modelAndView.addObject("empresa", empresaRepository.findOne(cargaHoraria.getEmpresa().getId()));
				} else {
					cargaHorariaRepository.save(cargaHoraria);
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
					modelAndView.addObject("cargaHoraria", cargaHoraria);
					modelAndView.addObject("empresa", empresaRepository.findOne(cargaHoraria.getEmpresa().getId()));
				}		
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+cargaHoraria.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}

		/**
		 * 
		 * @param id
		 * @param userDetails
		 * @return
		 * 		CargaHoraria
		 * @exception
		 * 		Empresa id
		 */
		@GetMapping("/carga/{id}")
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
			CargaHoraria cargaHoraria = cargaHorariaRepository.findOne(id);
			if (usuarioSessao.getGrupoDePermissoes().isCargaHorariaVisualizar() == true) {
				modelAndView = new ModelAndView("empresas/cargas/carga");
				modelAndView.addObject("cargaHoraria", cargaHoraria);
				modelAndView.addObject("empresa", empresaRepository.findOne(cargaHoraria.getEmpresa().getId()));
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+cargaHoraria.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}
		
		/**
		 * @param cargaHoraria
		 * @param bindingResult
		 * @param userDetails
		 * @return
		 * 		CargaHoraria
		 * @exception
		 * 		Empresa id
		 */
		@PostMapping("/carga/{id}")
		public ModelAndView update(@Valid CargaHoraria cargaHoraria, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (usuarioSessao.getGrupoDePermissoes().isCargaHorariaEditar() == true) {
				modelAndView = new ModelAndView("empresas/cargas/carga");
				if (bindingResult.hasErrors()) {
					modelAndView.addObject("color", "orange");
					modelAndView.addObject("msg", "Algo saiu errado!");
					modelAndView.addObject("cargaHoraria", cargaHoraria);
					modelAndView.addObject("empresa", empresaRepository.findOne(cargaHoraria.getEmpresa().getId()));
				} else {
					cargaHorariaRepository.save(cargaHoraria);
					modelAndView.addObject("cargaHoraria", cargaHoraria);
					modelAndView.addObject("color", "#26a69a");
					modelAndView.addObject("msg", "Operação realizada com sucesso!");
					modelAndView.addObject("empresa", empresaRepository.findOne(cargaHoraria.getEmpresa().getId()));
				}	
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+cargaHoraria.getEmpresa().getId());
			}
			modelAndView.addObject("usuarioSessao", usuarioSessao);
			return modelAndView;
		}

}
