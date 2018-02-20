package br.net.ipp.controllers.configuracoes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.ArquivoRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw")
public class ArquivoController {
	
	private ArquivoRepository arquivoRepository;
	private UsuarioRepository usuarioRepository;
	private EnumService enumService;
	
	@Autowired
	public ArquivoController(
			ArquivoRepository arquivoRepository,
			UsuarioRepository usuarioRepository,
			EnumService enumService
			) {
		this.arquivoRepository = arquivoRepository;
		this.usuarioRepository = usuarioRepository;
		this.enumService = new EnumService();
	}
	
	@GetMapping("/arquivos")
	public ModelAndView arquivos(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isArquivoListar() == true) {
			List<String> locaisDosArquivos = enumService.carregarLocaisDosArquivos();
			modelAndView = new ModelAndView("configuracoes/arquivos/arquivos");
			modelAndView.addObject("locaisDosArquivos", locaisDosArquivos);
			modelAndView.addObject("arquivos", arquivoRepository.findAll());
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/arquivo/form")
	public ModelAndView arquivo(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isArquivoCadastrar() == true) {
			modelAndView = new ModelAndView("configuracoes/arquivos/arquivo");
			List<String> locaisDosArquivos = enumService.carregarLocaisDosArquivos();
			modelAndView.addObject("locaisDosArquivos", locaisDosArquivos);
		} else {
			modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		}
		return modelAndView;
	}
	
	// post
	
	@GetMapping("/arquivosi/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/arquivos/arquivo");
		modelAndView.addObject("arquivo", arquivoRepository.findOne(id));
		return modelAndView;
	}
	
	// put
}


