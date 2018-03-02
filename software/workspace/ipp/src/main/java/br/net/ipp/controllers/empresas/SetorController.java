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
import br.net.ipp.daos.empresas.SetorRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;
import br.net.ipp.models.empresas.Setor;

@Controller
@Transactional
@RequestMapping("/sw")
public class SetorController {

	private SetorRepository setorRepository;
	private EmpresaRepository empresaRepository;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	
	@Autowired
	public SetorController (
			SetorRepository setorRepository,
			EmpresaRepository empresaRepository,
			UsuarioRepository usuarioRepository,
			GestorRepository gestorRepository,
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository
			) {
		this.setorRepository = setorRepository;
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
	 * 		List<Setor> setoresDaEmpresa
	 * @exception
	 * 		Empresa id
	 */
	@GetMapping("/setores/empresa/{id}")
	public ModelAndView setores(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isSetorListar() == true) {
			modelAndView = new ModelAndView("empresas/setores/setores");
			Empresa empresa = empresaRepository.findOne(id);
			if (usuarioSessao.isAdmin() == true) {
				modelAndView.addObject("setores", setorRepository.findAll());
				modelAndView.addObject("gestores", gestorRepository.findAll());
				modelAndView.addObject("empresa", empresa);
			} else {
				modelAndView.addObject("setores", setorRepository.findByEmpresa(empresa));
				modelAndView.addObject("gestores", gestorRepository.findByEmpresa(empresa));
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
	 * 		new Setor
	 * @exception
	 * 		Empresa id
	 */
	@GetMapping("/setor/form/{id}")
	public ModelAndView setor(Setor setor, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isSetorCadastrar() == true) {
			modelAndView = new ModelAndView("empresas/setores/setor");
			Empresa empresa = empresaRepository.findOne(id);
			modelAndView.addObject("setor", setor);
			modelAndView.addObject("empresa", empresa);
			modelAndView.addObject("gestores", gestorRepository.findByEmpresa(empresa));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/empresa/"+id);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * @param setor
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 * 		Setor
	 * @exception
	 * 		Empresa id
	 */
	@PostMapping("/setor")
	public ModelAndView save(@Valid Setor setor, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isSetorCadastrar() == true) {
			modelAndView = new ModelAndView("empresas/setores/setor");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("setor", setor);
				modelAndView.addObject("gestores", gestorRepository.findByEmpresa(setor.getEmpresa()));
				modelAndView.addObject("empresa", empresaRepository.findOne(setor.getEmpresa().getId()));
			} else {
				setorRepository.save(setor);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("setor", setor);
				modelAndView.addObject("gestores", gestorRepository.findByEmpresa(setor.getEmpresa()));
				modelAndView.addObject("empresa", empresaRepository.findOne(setor.getEmpresa().getId()));
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/empresa/"+setor.getEmpresa().getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	/**
	 * 
	 * @param id
	 * @param userDetails
	 * @return
	 * 		Setor
	 * @exception
	 * 		Empresa id
	 */
	@GetMapping("/setor/{id}")
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
		Setor setor = setorRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isSetorVisualizar() == true) {
			modelAndView = new ModelAndView("empresas/setores/setor");
			modelAndView.addObject("setor", setor);
			modelAndView.addObject("empresa", empresaRepository.findOne(setor.getEmpresa().getId()));
			modelAndView.addObject("gestores", gestorRepository.findByEmpresa(setor.getEmpresa()));
		} else {
			modelAndView = new ModelAndView("redirect:/sw/empresa/"+setor.getEmpresa().getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	/**
	 * @param setor
	 * @param bindingResult
	 * @param userDetails
	 * @return
	 * 		Setor
	 * @exception
	 * 		Empresa id
	 */
	@PostMapping("/setor/{id}")
	public ModelAndView update(@Valid Setor setor, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isSetorEditar() == true) {
			modelAndView = new ModelAndView("empresas/setores/setor");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("setor", setor);
				modelAndView.addObject("gestores", gestorRepository.findByEmpresa(setor.getEmpresa()));
				modelAndView.addObject("empresa", empresaRepository.findOne(setor.getEmpresa().getId()));
			} else {
				setorRepository.save(setor);
				modelAndView.addObject("setor", setor);
				modelAndView.addObject("empresa", empresaRepository.findOne(setor.getEmpresa().getId()));
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("gestores", gestorRepository.findByEmpresa(setor.getEmpresa()));
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/empresa/"+setor.getEmpresa().getId());
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

}
