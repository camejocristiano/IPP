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

import br.net.ipp.daos.aprendizes.AvaliacaoPIPRepository;
import br.net.ipp.daos.aprendizes.HistoricoRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;
import br.net.ipp.models.aprendizes.AvaliacaoPIP;
import br.net.ipp.models.aprendizes.Historico;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
@Transactional
@RequestMapping("/sw")
public class AvaliacaoPIPController {

	private AvaliacaoPIPRepository avaliacaoPIPRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	private GestorRepository gestorRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private HistoricoRepository historicoRepository;
	
	@Autowired
	public void AvaliacaoPIPEndPoint(
			AvaliacaoPIPRepository avaliacaoPIPRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository,
			GestorRepository gestorRepository, 
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			HistoricoRepository historicoRepository
			) {
		this.avaliacaoPIPRepository = avaliacaoPIPRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
		this.gestorRepository = gestorRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.historicoRepository = historicoRepository;
	}

/*	@GetMapping("/avaliacaoPIP/form")
	public ModelAndView avaliacaoPIP(AvaliacaoPIP avaliacaoPIP, @AuthenticationPrincipal UserDetails userDetails) {
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
		if (usuarioSessao.getGrupoDePermissoes().ispIOCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
			modelAndView.addObject("avaliacaoPIP", avaliacaoPIP);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}*/
	
	@GetMapping("/avaliacaoPIP/form/{id}")
	public ModelAndView avaliacaoPIP(AvaliacaoPIP avaliacaoPIP, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
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
			if (avaliacaoPIPRepository.findByHistorico(historico) != null) {
				avaliacaoPIP = avaliacaoPIPRepository.findByHistorico(historico);
				modelAndView = new ModelAndView("redirect:/sw/avaliacaoPIP/"+avaliacaoPIP.getId());
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/historico/form/"+jovem.getId());
		}
		if (usuarioSessao.getGrupoDePermissoes().ispIOCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pips/pip");
			modelAndView.addObject("avaliacaoPIP", avaliacaoPIP);
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("historico", historico);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("historico", historico);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/avaliacaoPIP")
	public ModelAndView save(@Valid AvaliacaoPIP avaliacaoPIP, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(avaliacaoPIP.getHistorico().getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispIOCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pips/pip");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPIP", avaliacaoPIP);
			} else {
				avaliacaoPIPRepository.save(avaliacaoPIP);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("avaliacaoPIP", avaliacaoPIP);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/avaliacaoPIP/{id}")
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
		AvaliacaoPIP avaliacaoPIP = avaliacaoPIPRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(avaliacaoPIP.getHistorico().getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispIOVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pips/pip");
			modelAndView.addObject("avaliacaoPIP", avaliacaoPIP);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/avaliacaoPIP/{id}")
	public ModelAndView update(@Valid AvaliacaoPIP avaliacaoPIP, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
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
		Jovem jovem = jovemRepository.findOne(avaliacaoPIP.getHistorico().getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispIOEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pips/pip");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
				modelAndView.addObject("avaliacaoPIP", avaliacaoPIP);
			} else {
				avaliacaoPIPRepository.save(avaliacaoPIP);
				modelAndView.addObject("avaliacaoPIP", avaliacaoPIP);
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
