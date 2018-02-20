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

import br.net.ipp.daos.aprendizes.CaracteristicasDomiciliaresRepository;
import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.aprendizes.CaracteristicasDomiciliares;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class CaracteristicasDomiciliaresController {

	private CaracteristicasDomiciliaresRepository caracteristicasDomiciliaresRepository;
	private JovemRepository jovemRepository;
	private EnumService enumService;
	private UsuarioRepository usuarioRepository; 
	
	@Autowired
	public CaracteristicasDomiciliaresController(
			CaracteristicasDomiciliaresRepository caracteristicasDomiciliaresRepository,
			JovemRepository jovemRepository,
			EnumService enumService,
			UsuarioRepository usuarioRepository
			) {
		this.caracteristicasDomiciliaresRepository = caracteristicasDomiciliaresRepository;
		this.jovemRepository = jovemRepository;
		this.enumService = new EnumService();
		this.usuarioRepository = usuarioRepository;
	}

	@GetMapping("/caracteristicaDomiciliar/form")
	public ModelAndView caracteristicasDomiciliares(CaracteristicasDomiciliares caracteristicasDomiciliares, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isCaracteristicasDomiciliaresCadastrar() == true) {
			modelAndView = new ModelAndView("redirect:/sw/jovens");
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovens/");			
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/caracteristicaDomiciliar/form/{id}")
	public ModelAndView caracteristicasDomiciliaresJovem(CaracteristicasDomiciliares caracteristicasDomiciliares, @PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isCaracteristicasDomiciliaresVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
			modelAndView.addObject("jovem", jovem);
			List<String> auxiliosDoGoverno = this.enumService.carregarAuxiliosDoGoverno();
			modelAndView.addObject("auxiliosDoGoverno", auxiliosDoGoverno);
			List<String> escolaridades = this.enumService.carregarEscolaridades();
			modelAndView.addObject("escolaridades", escolaridades);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
			modelAndView.addObject("jovem", jovem);
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/caracteristicaDomiciliar")
	public ModelAndView save(@Valid CaracteristicasDomiciliares caracteristicasDomiciliares, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(caracteristicasDomiciliares.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isCaracteristicasDomiciliaresVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
				modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
			} else {
				caracteristicasDomiciliaresRepository.save(caracteristicasDomiciliares);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
				modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
			}		
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@GetMapping("/caracteristicaDomiciliar/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		CaracteristicasDomiciliares caracteristicasDomiciliares = caracteristicasDomiciliaresRepository.findOne(id);
		Jovem jovem = jovemRepository.findOne(caracteristicasDomiciliares.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isCaracteristicasDomiciliaresVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
			modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
			List<String> auxiliosDoGoverno = this.enumService.carregarAuxiliosDoGoverno();
			modelAndView.addObject("auxiliosDoGoverno", auxiliosDoGoverno);
			List<String> escolaridades = this.enumService.carregarEscolaridades();
			modelAndView.addObject("escolaridades", escolaridades);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@PostMapping("/caracteristicaDomiciliar/{id}")
	public ModelAndView update(@Valid CaracteristicasDomiciliares caracteristicasDomiciliares, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(caracteristicasDomiciliares.getJovem().getId());
		if (usuarioSessao.getGrupoDePermissoes().isCaracteristicasDomiciliaresVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
				modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
			} else {
				caracteristicasDomiciliaresRepository.save(caracteristicasDomiciliares);
				modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/caracteristicaDomiciliarJovem/{id}")
	public ModelAndView caracteristicaDomiciliarJovem(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		Jovem jovem = jovemRepository.findOne(id);
		if (usuarioSessao.getGrupoDePermissoes().isCaracteristicasDomiciliaresVisualizar() == true) {
			modelAndView = new ModelAndView("aprendizes/domiciliares/domiciliar");
			modelAndView.addObject("jovem", jovem);
			if (caracteristicasDomiciliaresRepository.findByJovem(jovem) != null) {
				modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliaresRepository.findByJovem(jovem));
			} else {
				CaracteristicasDomiciliares caracteristicasDomiciliares = new CaracteristicasDomiciliares();
				modelAndView.addObject("caracteristicasDomiciliares", caracteristicasDomiciliares);
			}
			List<String> auxiliosDoGoverno = this.enumService.carregarAuxiliosDoGoverno();
			modelAndView.addObject("auxiliosDoGoverno", auxiliosDoGoverno);
			List<String> escolaridades = this.enumService.carregarEscolaridades();
			modelAndView.addObject("escolaridades", escolaridades);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/jovem/"+jovem.getId());			
			
		}
		modelAndView.addObject("jovem", jovem);
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
}
