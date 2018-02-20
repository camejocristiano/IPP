package br.net.ipp.controllers.aprendizes;

import java.util.ArrayList;
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

import br.net.ipp.daos.aprendizes.DispensaRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.Dispensa;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class DispensaController {

	private DispensaRepository dispensaRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	public DispensaController (
			DispensaRepository dispensaRepository,
			JovemRepository jovemRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository
			) {
		this.dispensaRepository = dispensaRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/dispensa/form")
	public ModelAndView dispensa(Dispensa dispensa, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isDispensaCadastrar() == true) {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/dispensaJovem/{id}")
	public ModelAndView dispensaJovem(Dispensa dispensa, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isDispensaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
			modelAndView.addObject("dispensa", dispensa);
			List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
			modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/dispensa")
	public ModelAndView save(@Valid Dispensa dispensa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(dispensa.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isDispensaCadastrar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "oranges");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
				modelAndView.addObject("dispensa", dispensa);
			} else {
				dispensaRepository.save(dispensa);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("dispensa", dispensa);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
		modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/dispensa/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Dispensa dispensa = dispensaRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(dispensa.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isDispensaVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
			modelAndView.addObject("jovem", jovem);
			modelAndView.addObject("dispensa", dispensa);
			List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
			modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/dispensa/{id}")
	public ModelAndView update(@Valid Dispensa dispensa, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(dispensa.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isDispensaEditar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensa");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado!");
				modelAndView.addObject("dispensa", dispensa);
			} else {
				dispensaRepository.save(dispensa);
				modelAndView.addObject("dispensa", dispensa);				
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
		modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/dispensasJovem/{id}")
	public ModelAndView dispensasJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isDispensaListar() == true) {
			modelAndView = new ModelAndView("aprendizes/profissionais/dispensas/dispensas");
			modelAndView.addObject("jovem", jovem);
			if (dispensaRepository.findAllByJovem(jovem) != null) {
				modelAndView.addObject("dispensas", dispensaRepository.findAllByJovem(jovem));
			} else {
				List<Dispensa> dispensas = new ArrayList<Dispensa>();
				modelAndView.addObject("dispensas", dispensas);
			}
			List<String> motivosDaDispensa = this.enumService.carregarMotivoDaDispensa();
			modelAndView.addObject("motivosDaDispensa", motivosDaDispensa);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/fichaProfissional/home/"+jovem.getId());
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
