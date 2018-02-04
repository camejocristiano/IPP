package br.net.ipp.controllers.configuracoes;

import java.util.ArrayList;
import java.util.Arrays;
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
import br.net.ipp.enums.EstadoCivil;
import br.net.ipp.enums.Regiao;
import br.net.ipp.enums.RelacaoFuncional;
import br.net.ipp.enums.Sexo;
import br.net.ipp.enums.Status;
import br.net.ipp.models.configuracoes.GrupoDePermissoes;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/usuarios")
public class UsuariosEndpoint {
	
	private UsuarioRepository usuarioDAO;
	private GrupoDePermissoesRepository grupoDePermissoeDAO;
	
	@Autowired
	public void UsuarioEndPoint(
			UsuarioRepository usuarioDAO,
			GrupoDePermissoesRepository grupoDePermissoeDAO
			) {
		this.usuarioDAO = usuarioDAO;
		this.grupoDePermissoeDAO = grupoDePermissoeDAO;
	}

	@GetMapping("/form")
	public ModelAndView usuario(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		List<String> status = carregarStatus();
		modelAndView.addObject("status", status);
		List<String> estadoCivil = carregarEstadoCivil();
		modelAndView.addObject("estadoCivil", estadoCivil);
		List<String> sexo = carregarSexo();
		modelAndView.addObject("sexo", sexo);
		List<String> relacaoFuncional = carregarRelacaoFuncional();
		modelAndView.addObject("relacaoFuncional", relacaoFuncional);
		List<String> regiao = carregarRegiao();
		modelAndView.addObject("regiao", regiao);
		List<GrupoDePermissoes> gruposDePermissoes = (List<GrupoDePermissoes>) grupoDePermissoeDAO.findAll();
		modelAndView.addObject("gruposDePermissoes", gruposDePermissoes);
		/*Long user = usuario.getGrupoDePermissoes().getId();
		GrupoDePermissoes grupoDePermissoes = grupoDePermissoeDAO.findById(user);
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
			usuarioDAO.save(usuario);
			modelAndView.addObject("usuario", usuario);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			List<String> status = carregarStatus();
			modelAndView.addObject("status", status);
			List<String> estadoCivil = carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> sexo = carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> relacaoFuncional = carregarRelacaoFuncional();
			modelAndView.addObject("relacaoFuncional", relacaoFuncional);
			List<String> regiao = carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			/*Long user = usuario.getGrupoDePermissoes().getId();
			GrupoDePermissoes grupoDePermissoes = grupoDePermissoeDAO.findById(user);
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);*/
			this.load(usuario.getId());
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		Usuario usuario = usuarioDAO.findOne(id);
		modelAndView.addObject("usuario", usuario);
		List<String> status = carregarStatus();
		modelAndView.addObject("status", status);
		List<String> estadoCivil = carregarEstadoCivil();
		modelAndView.addObject("estadoCivil", estadoCivil);
		List<String> sexo = carregarSexo();
		modelAndView.addObject("sexo", sexo);
		List<String> relacaoFuncional = carregarRelacaoFuncional();
		modelAndView.addObject("relacaoFuncional", relacaoFuncional);
		List<String> regiao = carregarRegiao();
		modelAndView.addObject("regiao", regiao);
		List<GrupoDePermissoes> gruposDePermissoes = (List<GrupoDePermissoes>) grupoDePermissoeDAO.findAll();
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
			GrupoDePermissoes grupoDePermissoes = grupoDePermissoeDAO.findById(usuario.getId());
			modelAndView.addObject("grupoDePermissoes", grupoDePermissoes);
		} else {
			usuarioDAO.save(usuario);
			modelAndView.addObject("usuario", usuario);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			List<String> status = carregarStatus();
			modelAndView.addObject("status", status);
			List<String> estadoCivil = carregarEstadoCivil();
			modelAndView.addObject("estadoCivil", estadoCivil);
			List<String> sexo = carregarSexo();
			modelAndView.addObject("sexo", sexo);
			List<String> relacaoFuncional = carregarRelacaoFuncional();
			modelAndView.addObject("relacaoFuncional", relacaoFuncional);
			List<String> regiao = carregarRegiao();
			modelAndView.addObject("regiao", regiao);
			List<GrupoDePermissoes> gruposDePermissoes = (List<GrupoDePermissoes>) grupoDePermissoeDAO.findAll();
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
		GrupoDePermissoes grupoDePermissoes = grupoDePermissoeDAO.findById(user);
		return grupoDePermissoes;
	}
	
	public List<String> carregarStatus() {
		List<Status> lista = Arrays.asList(Status.values());
		List<String> status = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			status.add(lista.get(i).name());
		}
		return status;
	}
	
	public List<String> carregarSexo() {
		List<Sexo> lista = Arrays.asList(Sexo.values());
		List<String> sexo = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			sexo.add(lista.get(i).name());
		}
		return sexo;
	}
	
	public List<String> carregarEstadoCivil() {
		List<EstadoCivil> lista = Arrays.asList(EstadoCivil.values());
		List<String> estadoCivil = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			estadoCivil.add(lista.get(i).name());
		}
		return estadoCivil;
	}
	
	public List<String> carregarRelacaoFuncional() {
		List<RelacaoFuncional> lista = Arrays.asList(RelacaoFuncional.values());
		List<String> relacaoFuncional = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			relacaoFuncional.add(lista.get(i).name());
		}
		return relacaoFuncional;
	}
	
	public List<String> carregarRegiao() {
		List<Regiao> lista = Arrays.asList(Regiao.values());
		List<String> regiao = new ArrayList<String>();
		for (int i = 0; i < lista.size(); i++) {
			regiao.add(lista.get(i).name());
		}
		return regiao;
	}
}


