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
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.AvaliacaoPAPIPP;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class AvaliacaoPAPIPPController {

	private AvaliacaoPAPIPPRepository avaliacaoPAPIPPRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void AvaliacaoPAPIPPEndPoint(
			AvaliacaoPAPIPPRepository avaliacaoPAPIPPRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository
			) {
		this.avaliacaoPAPIPPRepository = avaliacaoPAPIPPRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/avaliacaoPAPIPP/form")
	public ModelAndView avaliacaoPAPIPP(AvaliacaoPAPIPP avaliacaoPAPIPP, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().ispAPIPPCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/avaliacaoPAPIPP/form/{id}")
	public ModelAndView avaliacaoPAPIPP(AvaliacaoPAPIPP avaliacaoPAPIPP, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().ispAPIPPCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/paps/pap");
			modelAndView.addObject("avaliacaoPAPIPP", avaliacaoPAPIPP);
			modelAndView.addObject("jovem", jovem);
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
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPIPP.getJovem().getId());
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
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		AvaliacaoPAPIPP avaliacaoPAPIPP = avaliacaoPAPIPPRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPIPP.getJovem().getId());
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
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPIPP.getJovem().getId());
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
