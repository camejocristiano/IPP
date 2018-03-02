package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.AvaliacaoPAPEmpresaRepository;
import br.net.ipp.daos.aprendizes.HistoricoRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.AvaliacaoPAPEmpresa;
import br.net.ipp.models.aprendizes.Historico;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
@Transactional
@RequestMapping("/sw")
public class AvaliacaoPAPEmpresaController {

	private AvaliacaoPAPEmpresaRepository avaliacaoPAPEmpresaRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private HistoricoRepository historicoRepository;
	
	@Autowired
	public void AvaliacaoPAPEmpresaEndPoint(
			AvaliacaoPAPEmpresaRepository avaliacaoPAPEmpresaRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository,
			GestorRepository gestorRepository, 
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			HistoricoRepository historicoRepository
			) {
		this.avaliacaoPAPEmpresaRepository = avaliacaoPAPEmpresaRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.historicoRepository = historicoRepository;
	}

/*	@GetMapping("/avaliacaoPAPEmpresa/form")
	public ModelAndView avaliacaoPAPEmpresa(AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().ispAPEmpresaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}*/
	
	@GetMapping("/avaliacaoPAPEmpresa/form/{id}")
	public ModelAndView avaliacaoPAPEmpresa(AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
		Historico historico = null;
		if (historicoRepository.findByJovem(jovem) != null) {
			historico = historicoRepository.findByJovem(jovem);
			if (avaliacaoPAPEmpresaRepository.findByHistorico(historico) != null) {
				avaliacaoPAPEmpresa = avaliacaoPAPEmpresaRepository.findByHistorico(historico);
				modelAndView = new ModelAndView("redirect:/sw/avaliacaoPAPEmpresa/"+avaliacaoPAPEmpresa.getId());
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/historico/form/"+jovem.getId());
		}
		if (usuarioSessao.getGrupoDePermissoes().ispAPEmpresaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("historico", historico);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+id);
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("historico", historico);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/avaliacaoPAPEmpresa")
	public ModelAndView save(@Valid AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().ispAPEmpresaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
			} else {
				avaliacaoPAPEmpresaRepository.save(avaliacaoPAPEmpresa);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+avaliacaoPAPEmpresa.getHistorico().getJovem().getId());
		}
		modelAndView.addObject("jovem", avaliacaoPAPEmpresa.getHistorico().getJovem().getId());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/avaliacaoPAPEmpresa/{id}")
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
		AvaliacaoPAPEmpresa avaliacaoPAPEmpresa = avaliacaoPAPEmpresaRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPEmpresa.getHistorico().getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispAPEmpresaVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/avaliacaoPAPEmpresa/{id}")
	public ModelAndView update(@Valid AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPEmpresa.getHistorico().getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispAPEmpresaEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
			} else {
				avaliacaoPAPEmpresaRepository.save(avaliacaoPAPEmpresa);
				modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

}
