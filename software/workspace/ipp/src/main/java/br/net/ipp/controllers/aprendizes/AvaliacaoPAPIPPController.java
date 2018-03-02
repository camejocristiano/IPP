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

import br.net.ipp.daos.aprendizes.AvaliacaoPAPIPPRepository;
import br.net.ipp.daos.aprendizes.HistoricoRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.AvaliacaoPAPIPP;
import br.net.ipp.models.aprendizes.Historico;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
@Transactional
@RequestMapping("/sw")
public class AvaliacaoPAPIPPController {

	private AvaliacaoPAPIPPRepository avaliacaoPAPIPPRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private HistoricoRepository historicoRepository;
	
	@Autowired
	public void AvaliacaoPAPIPPEndPoint(
			AvaliacaoPAPIPPRepository avaliacaoPAPIPPRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository,
			GestorRepository gestorRepository, 
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			HistoricoRepository historicoRepository
			) {
		this.avaliacaoPAPIPPRepository = avaliacaoPAPIPPRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.historicoRepository = historicoRepository;
	}

	/*@GetMapping("/avaliacaoPAPIPP/form")
	public ModelAndView avaliacaoPAPIPP(AvaliacaoPAPIPP avaliacaoPAPIPP, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().ispAPIPPCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}*/
	
	@GetMapping("/avaliacaoPAPIPP/form/{id}")
	public ModelAndView avaliacaoPAPIPP(AvaliacaoPAPIPP avaliacaoPAPIPP, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (avaliacaoPAPIPPRepository.findByHistorico(historico) != null) {
				avaliacaoPAPIPP = avaliacaoPAPIPPRepository.findByHistorico(historico);
				modelAndView = new ModelAndView("redirect:/sw/avaliacaoPAPEmpresa/"+avaliacaoPAPIPP.getId());
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/historico/form/"+jovem.getId());
		}
		if (usuarioSessao.getGrupoDePermissoes().ispAPIPPCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("historico", historico);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/avaliacaoPAPIPP")
	public ModelAndView save(@Valid AvaliacaoPAPIPP avaliacaoPAPIPP, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPIPP.getHistorico().getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispAPIPPCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
			} else {
				avaliacaoPAPIPPRepository.save(avaliacaoPAPIPP);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/avaliacaoPAPIPP/{id}")
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
		AvaliacaoPAPIPP avaliacaoPAPIPP = avaliacaoPAPIPPRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPIPP.getHistorico().getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispAPIPPVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/avaliacaoPAPIPP/{id}")
	public ModelAndView update(@Valid AvaliacaoPAPIPP avaliacaoPAPIPP, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPIPP.getHistorico().getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispAPIPPEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
			} else {
				avaliacaoPAPIPPRepository.save(avaliacaoPAPIPP);
				modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
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
