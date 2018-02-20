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

import br.net.ipp.daos.aprendizes.AvaliacaoPIORepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.AvaliacaoPIO;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class AvaliacaoPIOController {

	private AvaliacaoPIORepository avaliacaoPIORepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void AvaliacaoPIOEndPoint(
			AvaliacaoPIORepository avaliacaoPIORepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository
			) {
		this.avaliacaoPIORepository = avaliacaoPIORepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/avaliacaoPIO/form")
	public ModelAndView avaliacaoPIO(AvaliacaoPIO avaliacaoPIO, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pios/pio");
			modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/avaliacaoPIO/form/{id}")
	public ModelAndView avaliacaoPIO(AvaliacaoPIO avaliacaoPIO, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isContratacaoCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pios/pio");
			modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/avaliacaoPIO")
	public ModelAndView save(@Valid AvaliacaoPIO avaliacaoPIO, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPIO.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispIOCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pios/pio");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
			} else {
				avaliacaoPIORepository.save(avaliacaoPIO);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/avaliacaoPIO/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		AvaliacaoPIO avaliacaoPIO = avaliacaoPIORepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(avaliacaoPIO.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispIOVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/financeiros/financeiro");
			modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/avaliacaoPIO/{id}")
	public ModelAndView update(@Valid AvaliacaoPIO avaliacaoPIO, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPIO.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispIOEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/pios/pio");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
			} else {
				avaliacaoPIORepository.save(avaliacaoPIO);
				modelAndView.addObject("avaliacaoPIO", avaliacaoPIO);
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
