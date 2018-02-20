package br.net.ipp.controllers.configuracoes;

import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;
import br.net.ipp.storage.StorageService;

@Controller
@Transactional
@RequestMapping("/sw")
public class UsuarioController {
	
	private UsuarioRepository usuarioRepository;
	private GrupoDePermissoesRepository grupoDePermissoesRepository;
	private EnumService enumService;
	private final StorageService storageService;
	Calendar c = Calendar.getInstance();
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	public UsuarioController(
			UsuarioRepository usuarioRepository,
			GrupoDePermissoesRepository grupoDePermissoesRepository,
			EnumService enumService,
			StorageService storageService,
			UnidadeRepository unidadeRepository
			) {
		this.usuarioRepository = usuarioRepository;
		this.grupoDePermissoesRepository = grupoDePermissoesRepository;
		this.enumService = new EnumService();
		this.storageService = storageService;
		this.unidadeRepository = unidadeRepository;
		
	}
	
	@GetMapping("/usuarios")
	public ModelAndView index(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuarios");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isUsuarioListar() == true) {
			if (usuarioSessao.isAdmin() == true) {
				modelAndView.addObject("usuarios", usuarioRepository.findAll());
			} else {
				modelAndView.addObject("usuarios", usuarioRepository.findAllByUnidade(usuarioSessao.getUnidade()));
			}	
		} else {
			return modelAndView = new ModelAndView("redirect:/sw/user");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
	@GetMapping("/usuario/form")
	public ModelAndView usuario(Usuario usuario, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isUsuarioCadastrar() == true) {
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> estadoCivil = enumService.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> sexo = enumService.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> relacaoFuncional = enumService.carregarRelacaoFuncional();
			modelAndView.addObject("relacaoFuncional", relacaoFuncional);
			List<String> regiao = enumService.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
		} else {
			return modelAndView = new ModelAndView("redirect:/sw/user");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	@PostMapping("/usuario")
	public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		if (usuarioSessao.getGrupoDePermissoes().isUsuarioCadastrar() == true) {
			modelAndView.addObject("usuario", usuarioRepository.findByUsername(userDetails.getUsername()));
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			} else {
				usuarioRepository.save(usuario);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}		
		} else {
			return modelAndView = new ModelAndView("redirect:/sw/user");
		}
		return modelAndView;
	}

	@GetMapping("/usuario/{id}")
	public ModelAndView load(@PathVariable("id") Long id, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		if (usuarioSessao.getGrupoDePermissoes().isUsuarioVisualizar() == true) {
			Usuario usuario = usuarioRepository.findOne(id);
			modelAndView.addObject("usuario", usuario);
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> estadoCivil = enumService.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			EnumService enumService = new EnumService();
			List<String> sexo = enumService.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> relacaoFuncional = enumService.carregarRelacaoFuncional();
			modelAndView.addObject("relacaoFuncional", relacaoFuncional);
			List<String> regiao = enumService.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
		} else {
			return modelAndView = new ModelAndView("redirect:/sw/user");
		}
		return modelAndView;
	}
	
	@PostMapping("/usuario/{id}")
	public ModelAndView update(@Valid Usuario usuario, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		modelAndView.addObject("usuarioSessao", usuarioRepository.findByUsername(userDetails.getUsername()));
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		if (usuarioSessao.getGrupoDePermissoes().isUsuarioEditar() == true) {
			if (bindingResult.hasErrors()) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "Algo saiu errado! Tente novamente!");
			} else {
				usuarioRepository.save(usuario);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso!");
			}	
			modelAndView.addObject("usuario", usuario);
		} else {
			return modelAndView = new ModelAndView("redirect:/sw/user");
		}
		return modelAndView;
	}
	
	@GetMapping("/user")
	public ModelAndView loadUser(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = null;
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		if (usuarioSessao.getGrupoDePermissoes().isUsuarioVisualizar() == true) {
			modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
			Usuario usuario = usuarioRepository.findByUsername(userDetails.getUsername());
			modelAndView.addObject("usuario", usuario);
			List<String> status = enumService.carregarStatus();
			modelAndView.addObject("status", status);
			List<String> estadoCivil = enumService.carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			EnumService enumService = new EnumService();
			List<String> sexo = enumService.carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> relacaoFuncional = enumService.carregarRelacaoFuncional();
			modelAndView.addObject("relacaoFuncional", relacaoFuncional);
			List<String> regiao = enumService.carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			modelAndView.addObject("unidades", unidadeRepository.findAll());
			modelAndView.addObject("gruposDePermissoes", grupoDePermissoesRepository.findAll());
			modelAndView.addObject("color", "orange");
			modelAndView.addObject("msg", "Sem Permissão de Acesso!");
		} else {
			modelAndView = new ModelAndView("index");
			modelAndView.addObject("color", "orange");
			modelAndView.addObject("msg", "Sem Permissão de Acesso!");
		}
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}

	public ModelAndView foto(@Valid Usuario usuario, BindingResult bindingResult, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/configuracoes");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		return modelAndView;
	}
	
    @PostMapping("/usuario/foto/{id}")
    public ModelAndView foto(@PathVariable Long id, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, @AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		Usuario usuarioSessao = usuarioRepository.findByUsername(userDetails.getUsername());
		modelAndView.addObject("usuarioSessao", usuarioSessao);
		Usuario usuario = usuarioRepository.findOne(id);
		modelAndView.addObject("usuario", usuario);
		if (usuarioSessao.getGrupoDePermissoes().isUsuarioEditar() == true) {
			if (file == null) {
				modelAndView.addObject("color", "orange");
				modelAndView.addObject("msg", "A imagem não pode ser nula!");
			} else {
				if (usuario.getFoto() != null && usuario.getFoto() != "") {
					storageService.deleteOne(usuario.getFoto());					
				}
				String classe = "Foto-Usuario"; 
				String nome = usuario.getNome();
				String dia = Integer.toString(c.get(Calendar.DAY_OF_MONTH));
				String mes = Integer.toString(c.get(Calendar.MONTH));
				String ano = Integer.toString(c.get(Calendar.YEAR));
				String data = dia+"-"+mes+"-"+ano;
				String email = usuario.getUsername();
				storageService.store(file, classe, nome, data, email);
				usuario.setFoto(classe + "_" + nome + "_" + data + "_" + email + "_" + file.getOriginalFilename());
				usuarioRepository.save(usuario);
				modelAndView.addObject("color", "#26a69a");
				modelAndView.addObject("msg", "Operação realizada com sucesso! -->> ->" + classe + "_" + nome + "_" + data + "_" + email + "_" + file.getOriginalFilename());
			}		
		} else {
			modelAndView.addObject("color", "orange");
			modelAndView.addObject("msg", "Sem Permissão!");
		}
        return modelAndView;
    }
    
}


