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
public class ContatoController {

	private UsuarioRepository usuarioRepository;
	private ContatoRepository contatoRepository;
	private GestorRepository gestorRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private EmpresaRepository empresaRepository;
	private EnumService enumService;
	
	@Autowired
	public void EmpresaEndPoint(
			GestorRepository gestorRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			UsuarioRepository usuarioRepository,
			ContatoRepository contatoRepository,
			EmpresaRepository empresaRepository,
			EnumService enumService
			) {
		this.contatoRepository = contatoRepository;
		this.usuarioRepository = usuarioRepository;
		this.gestorRepository = gestorRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.empresaRepository = empresaRepository;
		this.enumService = new EnumService();
	}

	/**
	 * @param idEmpresa
	 * @param userDetails
	 * @return
	 * 		List<Contato> contatosDaEmpresa
	 * @exception
	 * 		Empresa id
	 */
	@GetMapping("/contatos/empresa/{id}")
	public ModelAndView contatos(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isContatoListar() == true) {
			modelAndView = new ModelAndView("empresas/contatos/contatos");
			Empresa empresa = empresaRepository.findOne(id);
			if (usuarioSessao.isAdmin() == true) {
				modelAndView.addObject("contatos", contatoRepository.findAll());
				modelAndView.addObject("empresa", empresa);
			} else {
				modelAndView.addObject("contatos", contatoRepository.findByEmpresa(empresa));
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
	 * 		new Contato
	 * @exception
	 * 		Empresa id
	 */
	@GetMapping("/contato/form/{id}")
	public ModelAndView contato(Contato contato, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isContatoCadastrar() == true) {
			modelAndView = new ModelAndView("empresas/contatos/contato");
			modelAndView.addObject("contato", contato);
			modelAndView.addObject("empresa", empresaRepository.findOne(id));
			List<String> tiposDeContatos = this.enumService.carregarTiposDeContatos();
			modelAndView.addObject("tiposDeContatos", tiposDeContatos);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/empresa/"+id);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * @param contato
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 * 		Contato
	 * @exception
	 * 		Empresa id
	 */
	@PostMapping("/contato")
	public ModelAndView save(@Valid Contato contato, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isContatoCadastrar() == true) {
			modelAndView = new ModelAndView("empresas/contatos/contato");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("contato", contato);
				modelAndView.addObject("empresa", empresaRepository.findOne(contato.getEmpresa().getId()));
				List<String> tiposDeContatos = this.enumService.carregarTiposDeContatos();
				modelAndView.addObject("tiposDeContatos", tiposDeContatos);
			} else {
				contatoRepository.save(contato);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("contato", contato);
				modelAndView.addObject("empresa", empresaRepository.findOne(contato.getEmpresa().getId()));
				List<String> tiposDeContatos = this.enumService.carregarTiposDeContatos();
				modelAndView.addObject("tiposDeContatos", tiposDeContatos);
			}		
		} else {
			if (contato.getEmpresa().getId() != null) {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+contato.getEmpresa().getId());
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresas/");
			}
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * 
	 * @param id
	 * @param userDetails
	 * @return
	 * 		Contato
	 * @exception
	 * 		Empresa id
	 */
	@GetMapping("/contato/{id}")
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
		Contato contato = contatoRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isContatoVisualizar() == true) {
			modelAndView = new ModelAndView("empresas/contatos/contato");
			modelAndView.addObject("contato", contato);
			List<String> tiposDeContatos = this.enumService.carregarTiposDeContatos();
			modelAndView.addObject("tiposDeContatos", tiposDeContatos);
			modelAndView.addObject("empresa", empresaRepository.findOne(contato.getEmpresa().getId()));
		} else {
			if (contato.getEmpresa().getId() != null) {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+contato.getEmpresa().getId());
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresas/");
			}
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * @param contato
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 * 		Contato
	 * @exception
	 * 		Empresa id
	 */
	@PostMapping("/contato/{id}")
	public ModelAndView update(@Valid Contato contato, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isContatoEditar() == true) {
			modelAndView = new ModelAndView("empresas/contatos/contato");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("contato", contato);
				List<String> tiposDeContatos = this.enumService.carregarTiposDeContatos();
				modelAndView.addObject("tiposDeContatos", tiposDeContatos);
				modelAndView.addObject("empresa", empresaRepository.findOne(contato.getEmpresa().getId()));
			} else {
				contatoRepository.save(contato);
				modelAndView.addObject("contato", contato);
				List<String> tiposDeContatos = this.enumService.carregarTiposDeContatos();
				modelAndView.addObject("tiposDeContatos", tiposDeContatos);
				if (contato.getEmpresa().getId() != null) {
					modelAndView.addObject("empresa", empresaRepository.findOne(contato.getEmpresa().getId()));
				}
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			if (contato.getEmpresa().getId() != null) {
				modelAndView = new ModelAndView("redirect:/sw/empresa/"+contato.getEmpresa().getId());
			} else {
				modelAndView = new ModelAndView("redirect:/sw/empresas/");
			}
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

}
