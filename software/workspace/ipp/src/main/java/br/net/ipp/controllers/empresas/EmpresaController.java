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

import br.net.ipp.daos.configuracoes.UnidadeRepository;
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
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class EmpresaController {

	private UsuarioRepository usuarioRepository;
	private EmpresaRepository empresaRepository;
	private SetorRepository setorRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private UnidadeRepository unidadeRepository;
	private EnumService enumService;
	
	@Autowired
	public EmpresaController(
			EmpresaRepository empresaRepository,
			SetorRepository setorRepository,
			GestorRepository gestorRepository,
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			UsuarioRepository usuarioRepository,
			UnidadeRepository unidadeRepository,
			EnumService enumService
			) {
		this.usuarioRepository = usuarioRepository;
		this.empresaRepository = empresaRepository;
		this.setorRepository = setorRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.unidadeRepository = unidadeRepository;
		this.enumService = new EnumService();
	}
	
	@GetMapping("/empresas")
	public ModelAndView empresas(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		User usuarioSessao = null;
		Long idEmpresa = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Usuario) usuarioRepository.findByUsername(userDetails.getUsername());
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Gestor) gestorRepository.findByUsername(userDetails.getUsername());
			Gestor gestor = gestorRepository.findByUsername(userDetails.getUsername());
			idEmpresa = gestor.getEmpresa().getId();
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (Contato) contatoRepository.findByUsername(userDetails.getUsername());
			Contato contato = contatoRepository.findByUsername(userDetails.getUsername());
			idEmpresa = contato.getEmpresa().getId();
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			usuarioSessao = (RepresentanteLegal) representanteLegalRepository.findByUsername(userDetails.getUsername());
			RepresentanteLegal representanteLegal = representanteLegalRepository.findByUsername(userDetails.getUsername());
			idEmpresa = representanteLegal.getEmpresa().getId();
		}
		if (usuarioSessao.getGrupoDePermissoes().isEmpresaListar() == true) {
			modelAndView = new ModelAndView("empresas/empresas/empresas");
			if (usuarioSessao.isAdmin() == true) {
				modelAndView.addObject("empresas", empresaRepository.findAll());
			} else {
				if (usuarioSessao.getUnidade() != null) {
					modelAndView.addObject("empresas", empresaRepository.findAllByUnidade(usuarioSessao.getUnidade()));
				} else {
					modelAndView = new ModelAndView("redirect:/sw/empresa/"+idEmpresa);
				}
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/empresa/"+idEmpresa);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/empresa")
	public ModelAndView home(Empresa empresa, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isEmpresaCadastrar() == true) {
			modelAndView = new ModelAndView("empresas/empresas/empresa");
			modelAndView.addObject("empresa", empresa);
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			modelAndView.addObject("usuarios", usuarioRepository.findAll());
			List<String> tiposDeEmpresas = this.enumService.carregarTiposDeEmpresa();
			modelAndView.addObject("tiposDeEmpresas", tiposDeEmpresas);
			List<String> regioes = this.enumService.carregarRegioes();
			modelAndView.addObject("regioes", regioes);
			List<String> tiposDeParceria = this.enumService.carregarTiposDeParceria();
			modelAndView.addObject("tiposDeParceria", tiposDeParceria);
		} else {
			modelAndView = new ModelAndView("redirect:/sw");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/empresa")
	public ModelAndView save(@Valid Empresa empresa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isEmpresaCadastrar() == true) {
			modelAndView = new ModelAndView("empresas/empresas/empresa");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("empresa", empresa);
				modelAndView.addObject("unidades", unidadeRepository.findAll());
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
				List<String> tiposDeEmpresas = this.enumService.carregarTiposDeEmpresa();
				modelAndView.addObject("tiposDeEmpresas", tiposDeEmpresas);
				List<String> regioes = this.enumService.carregarRegioes();
				modelAndView.addObject("regioes", regioes);
				List<String> tiposDeParceria = this.enumService.carregarTiposDeParceria();
				modelAndView.addObject("tiposDeParceria", tiposDeParceria);
			} else {
				empresaRepository.save(empresa);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("empresa", empresa);
				modelAndView.addObject("unidades", unidadeRepository.findAll());
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
				List<String> tiposDeEmpresas = this.enumService.carregarTiposDeEmpresa();
				modelAndView.addObject("tiposDeEmpresas", tiposDeEmpresas);
				List<String> regioes = this.enumService.carregarRegioes();
				modelAndView.addObject("regioes", regioes);
				List<String> tiposDeParceria = this.enumService.carregarTiposDeParceria();
				modelAndView.addObject("tiposDeParceria", tiposDeParceria);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/empresa/{id}")
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
		if (usuarioSessao.getGrupoDePermissoes().isEmpresaVisualizar() == true) {
			modelAndView = new ModelAndView("empresas/empresas/home");
			Empresa empresa = empresaRepository.findOne(id);
			modelAndView.addObject("empresa", empresa);
			modelAndView.addObject("gestores", gestorRepository.findAll());
			modelAndView.addObject("setores", setorRepository.findAll());
			modelAndView.addObject("contatos", contatoRepository.findAll());
			modelAndView.addObject("representantes", representanteLegalRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/loadEmpresa/{id}")
	public ModelAndView loadEmpresa(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isEmpresaVisualizar() == true) {
			modelAndView = new ModelAndView("empresas/empresas/empresa");
			Empresa empresa = empresaRepository.findOne(id);
			modelAndView.addObject("empresa", empresa);
			modelAndView.addObject("gestores", gestorRepository.findAll());
			modelAndView.addObject("setores", setorRepository.findAll());
			modelAndView.addObject("contatos", contatoRepository.findAll());
			modelAndView.addObject("representantes", representanteLegalRepository.findAll());
			List<String> tiposDeEmpresas = this.enumService.carregarTiposDeEmpresa();
			modelAndView.addObject("tiposDeEmpresas", tiposDeEmpresas);
			List<String> regioes = this.enumService.carregarRegioes();
			modelAndView.addObject("regioes", regioes);
			List<String> tiposDeParceria = this.enumService.carregarTiposDeParceria();
			modelAndView.addObject("tiposDeParceria", tiposDeParceria);
		} else {
			modelAndView = new ModelAndView("redirect:/sw");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/empresa/{id}")
	public ModelAndView update(@Valid Empresa empresa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().isEmpresaEditar() == true) {
			modelAndView = new ModelAndView("empresas/empresas/empresa");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("empresa", empresa);
				modelAndView.addObject("unidades", unidadeRepository.findAll());
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
				List<String> tiposDeEmpresas = this.enumService.carregarTiposDeEmpresa();
				modelAndView.addObject("tiposDeEmpresas", tiposDeEmpresas);
				List<String> regioes = this.enumService.carregarRegioes();
				modelAndView.addObject("regioes", regioes);
				List<String> tiposDeParceria = this.enumService.carregarTiposDeParceria();
				modelAndView.addObject("tiposDeParceria", tiposDeParceria);
			} else {
				empresaRepository.save(empresa);
				modelAndView.addObject("empresa", empresa);
				modelAndView.addObject("unidades", unidadeRepository.findAll());
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
				List<String> tiposDeEmpresas = this.enumService.carregarTiposDeEmpresa();
				modelAndView.addObject("tiposDeEmpresas", tiposDeEmpresas);
				List<String> regioes = this.enumService.carregarRegioes();
				modelAndView.addObject("regioes", regioes);
				List<String> tiposDeParceria = this.enumService.carregarTiposDeParceria();
				modelAndView.addObject("tiposDeParceria", tiposDeParceria);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
