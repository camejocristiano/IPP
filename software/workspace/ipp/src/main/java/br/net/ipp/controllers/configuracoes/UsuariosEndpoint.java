package br.net.ipp.controllers.configuracoes;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.GrupoDePermissoes;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.EnumService;

@Controller
@Transactional
@RequestMapping("/sw/usuarios")
public class UsuariosEndpoint {
	
	private UsuarioRepository usuarioRepository;
	private GrupoDePermissoesRepository grupoDePermissoeRepository;
	private EnumService enumService;
	
	@Autowired
	public void UsuarioEndPoint(
			UsuarioRepository usuarioRepository,
			GrupoDePermissoesRepository grupoDePermissoeRepository
			) {
		this.usuarioRepository = usuarioRepository;
		this.grupoDePermissoeRepository = grupoDePermissoeRepository;
		this.enumService = new EnumService();
		
	}
	
	@GetMapping
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuarios");
		modelAndView.addObject("usuarios", usuarioRepository.findAll());
		return modelAndView;
	}
	
	@GetMapping("/form")
	public ModelAndView usuario(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
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
		List<GrupoDePermissoes> gruposDePermissoes = (List<GrupoDePermissoes>) grupoDePermissoeRepository.findAll();
		modelAndView.addObject("gruposDePermissoes", gruposDePermissoes);
		/*Long user = usuario.getGrupoDePermissoes().getId();
		GrupoDePermissoes grupoDePermissoes = grupoDePermissoeRepository.findById(user);
		modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);*/
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("usuario", usuario);
		} else {
			usuarioRepository.save(usuario);
			modelAndView.addObject("usuario", usuario);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
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
			/*Long user = usuario.getGrupoDePermissoes().getId();
			GrupoDePermissoes grupoDePermissoes = grupoDePermissoeRepository.findById(user);
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);*/
			this.load(usuario.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
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
		List<GrupoDePermissoes> gruposDePermissoes = (List<GrupoDePermissoes>) grupoDePermissoeRepository.findAll();
		modelAndView.addObject("gruposDePermissoes", gruposDePermissoes);
		if (usuario.getGrupoDePermissoes() != null) {
			GrupoDePermissoes grupoDePermissoes = grupoDePermissoes(usuario);
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);				
		}
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("usuario", usuario);
			GrupoDePermissoes grupoDePermissoes = grupoDePermissoeRepository.findById(usuario.getId());
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
		} else {
			usuarioRepository.save(usuario);
			modelAndView.addObject("usuario", usuario);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
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
			List<GrupoDePermissoes> gruposDePermissoes = (List<GrupoDePermissoes>) grupoDePermissoeRepository.findAll();
			modelAndView.addObject("gruposDePermissoes", gruposDePermissoes);
			if (usuario.getGrupoDePermissoes() != null) {
				GrupoDePermissoes grupoDePermissoes = grupoDePermissoes(usuario);
				modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);				
			}
		}	
		return modelAndView;
	}
	
	public GrupoDePermissoes grupoDePermissoes(Usuario usuario) {
		Long user = usuario.getGrupoDePermissoes().getId();
		GrupoDePermissoes grupoDePermissoes = grupoDePermissoeRepository.findById(user);
		return grupoDePermissoes;
	}
	
}


