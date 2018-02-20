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
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.AvaliacaoPAPEmpresa;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/sw")
public class AvaliacaoPAPEmpresaController {

	private AvaliacaoPAPEmpresaRepository avaliacaoPAPEmpresaRepository;
	private JovemRepository jovemRepository;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public void AvaliacaoPAPEmpresaEndPoint(
			AvaliacaoPAPEmpresaRepository avaliacaoPAPEmpresaRepository,
			JovemRepository jovemRepository,
			UsuarioRepository usuarioRepository
			) {
		this.avaliacaoPAPEmpresaRepository = avaliacaoPAPEmpresaRepository;
		this.jovemRepository = jovemRepository;
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/avaliacaoPAPEmpresa/form")
	public ModelAndView avaliacaoPAPEmpresa(AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().ispAPEmpresaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/avaliacaoPAPEmpresa/form/{id}")
	public ModelAndView avaliacaoPAPEmpresa(AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().ispAPEmpresaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
			modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/avaliacaoPAPEmpresa")
	public ModelAndView save(@Valid AvaliacaoPAPEmpresa avaliacaoPAPEmpresa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPEmpresa.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().ispAPEmpresaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/historicos/empresas/pap");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
				modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
			} else {
				avaliacaoPAPEmpresaRepository.save(avaliacaoPAPEmpresa);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("avaliacaoPAPEmpresa", avaliacaoPAPEmpresa);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/avaliacaoPAPEmpresa/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		AvaliacaoPAPEmpresa avaliacaoPAPEmpresa = avaliacaoPAPEmpresaRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPEmpresa.getJovem().getId());
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
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(avaliacaoPAPEmpresa.getJovem().getId());
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
