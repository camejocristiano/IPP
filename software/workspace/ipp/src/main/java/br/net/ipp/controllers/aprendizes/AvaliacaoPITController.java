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

import br.net.ipp.daos.aprendizes.AvaliacaoPITRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.AvaliacaoPIT;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class AvaliacaoPITController {

	private AvaliacaoPITRepository avaliacaoPITRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public AvaliacaoPITController(
			AvaliacaoPITRepository avaliacaoPITRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository
			) {
		this.avaliacaoPITRepository = avaliacaoPITRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/avaliacaoPIT/form")
	public ModelAndView avaliacaoPIT(AvaliacaoPIT avaliacaoPIT, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPIT.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispITCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
			modelAndView.addObject("avaliacaoPIT", avaliacaoPIT);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/avaliacaoPIT/form/{id}")
	public ModelAndView avaliacaoPIT(AvaliacaoPIT avaliacaoPIT, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
			modelAndView.addObject("avaliacaoPIT", avaliacaoPIT);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/avaliacaoPIT")
	public ModelAndView save(@Valid AvaliacaoPIT avaliacaoPIT, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPIT.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispITCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPIT", avaliacaoPIT);
			} else {
				avaliacaoPITRepository.save(avaliacaoPIT);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("avaliacaoPIT", avaliacaoPIT);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/avaliacaoPIT/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().ispITEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
			AvaliacaoPIT avaliacaoPIT = avaliacaoPITRepository.findOne(id);
			modelAndView.addObject("avaliacaoPIT", avaliacaoPIT);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/avaliacaoPIT/{id}")
	public ModelAndView update(@Valid AvaliacaoPIT avaliacaoPIT, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPIT.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispITEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pitsepips/pitepip");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPIT", avaliacaoPIT);
			} else {
				avaliacaoPITRepository.save(avaliacaoPIT);
				modelAndView.addObject("avaliacaoPIT", avaliacaoPIT);
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
