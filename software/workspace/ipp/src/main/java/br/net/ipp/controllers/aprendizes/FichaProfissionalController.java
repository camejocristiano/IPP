package br.net.ipp.controllers.aprendizes;

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

import br.net.ipp.daos.aprendizes.FichaProfissionalRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class FichaProfissionalController {

	private FichaProfissionalRepository fichaProfissionalRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public FichaProfissionalController (
			FichaProfissionalRepository fichaProfissionalRepository,
			JovemRepository jovemRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository
			) {
		this.fichaProfissionalRepository = fichaProfissionalRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/profissional/home/{id}")
	public ModelAndView home(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findByJovem(jovem);
		if (usuarioSessao.getGrupoDePermissoes().isFichaProfissionalVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/home");
			if (fichaProfissionalRepository.findByJovem(jovem) != null) {
				modelAndView.addObject("profissional", fichaProfissional);
			}
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+id);
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/profissional/form/{id}")
	public ModelAndView fichaProfissional(@PathVariable Long id, FichaProfissional fichaProfissional,@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isFichaProfissionalCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
			modelAndView.addObject("fichaProfissional", fichaProfissional);
			modelAndView.addObject("jovem", jovem);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/profissional/home/"+id);
			modelAndView.addObject("jovem", jovem);
		}
		List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
		modelAndView.addObject("situacoesAtuais", situacoesAtuais);
		List<String> status = this.enumService.carregarStatus();
		modelAndView.addObject("status", status);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}
	
	@GetMapping("/fichaProfissional/form/{id}")
	public ModelAndView fichaProfissionalJovem(FichaProfissional fichaProfissional, @PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isFichaProfissionalVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
			modelAndView.addObject("fichaProfissional", fichaProfissional);
			modelAndView.addObject("jovem", jovem);
			List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
			modelAndView.addObject("situacoesAtuais", situacoesAtuais);
			List<String> status = this.enumService.carregarStatus();
			modelAndView.addObject("status", status);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+id);
		}
		List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
		modelAndView.addObject("situacoesAtuais", situacoesAtuais);
		List<String> status = this.enumService.carregarStatus();
		modelAndView.addObject("status", status);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@PostMapping("/fichaProfissional")
	public ModelAndView save(@Valid FichaProfissional fichaProfissional, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(fichaProfissional.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFichaProfissionalCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			} else {
				fichaProfissionalRepository.save(fichaProfissional);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
		modelAndView.addObject("situacoesAtuais", situacoesAtuais);
		List<String> status = this.enumService.carregarStatus();
		modelAndView.addObject("status", status);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}

	@GetMapping("/profissional/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		FichaProfissional fichaProfissional = fichaProfissionalRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(fichaProfissional.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFichaProfissionalVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
			modelAndView.addObject("fichaProfissional", fichaProfissional);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
		modelAndView.addObject("situacoesAtuais", situacoesAtuais);
		List<String> status = this.enumService.carregarStatus();
		modelAndView.addObject("status", status);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}
	
	@PostMapping("/fichaProfissional/{id}")
	public ModelAndView update(@Valid FichaProfissional fichaProfissional, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(fichaProfissional.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isFichaProfissionalEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			} else {
				fichaProfissionalRepository.save(fichaProfissional);
				modelAndView.addObject("fichaProfissional", fichaProfissional);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
		modelAndView.addObject("situacoesAtuais", situacoesAtuais);
		List<String> status = this.enumService.carregarStatus();
		modelAndView.addObject("status", status);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}
	
	@GetMapping("/fichaProfissionalJovem/{id}")
	public ModelAndView fichaProfissionalJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isFichaProfissionalVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/profissional");
			if (fichaProfissionalRepository.findByJovem(jovem) != null) {
				modelAndView.addObject("fichaProfissional", fichaProfissionalRepository.findByJovem(jovem));
			} else {
				FichaProfissional fichaProfissional = new FichaProfissional();
				modelAndView.addObject("fichaProfissional", fichaProfissional);
			}
			List<String> situacoesAtuais = this.enumService.carregarSituacaoAtual();
			modelAndView.addObject("situacoesAtuais", situacoesAtuais);
			List<String> status = this.enumService.carregarStatus();
			modelAndView.addObject("status", status);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+id);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		modelAndView.addObject("jovem", jovem);
		return modelAndView;
	}
	
}
