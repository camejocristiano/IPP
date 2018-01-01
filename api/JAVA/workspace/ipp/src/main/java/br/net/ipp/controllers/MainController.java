package br.net.ipp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.AgendamentoRepository;
import br.net.ipp.daos.configuracoes.ArquivoRepository;
import br.net.ipp.daos.configuracoes.CanalRepository;
import br.net.ipp.daos.configuracoes.GrupoDePermissoesRepository;
import br.net.ipp.daos.configuracoes.UnidadeRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.GrupoDePermissoes;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
public class MainController {

	private UnidadeRepository unidadeDAO;
	private UsuarioRepository usuarioDAO;
	private AgendamentoRepository agendamentoDAO;
	private ArquivoRepository arquivoDAO;
	private GrupoDePermissoesRepository grupoDePermissoesDAO;
	private CanalRepository canalDAO;

	@Autowired
	public MainController(
			UnidadeRepository unidadeDAO, 
			UsuarioRepository usuarioDAO,
			AgendamentoRepository agendamentoDAO,
			ArquivoRepository arquivoDAO,
			GrupoDePermissoesRepository grupoDePermissoesDAO,
			CanalRepository canalDAO
			) {
		this.usuarioDAO = usuarioDAO;
		this.unidadeDAO = unidadeDAO;
		this.agendamentoDAO = agendamentoDAO;
		this.arquivoDAO = arquivoDAO;
		this.grupoDePermissoesDAO = grupoDePermissoesDAO;
		this.canalDAO = canalDAO;
	}

	@GetMapping("/")
	public ModelAndView index(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}

	@GetMapping("configuracoes")
	public ModelAndView configuracoes() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/configuracoes");
		Usuario usuario = new Usuario();
		GrupoDePermissoes grupoDePermissoes = grupoDePermissoesDAO.findById((long) 1);
		usuario.setGrupoDePermissoes(grupoDePermissoes);
		if (usuario.getGrupoDePermissoes().isUsuarioListar() == true) {
			modelAndView.addObject("usuarios", usuarioDAO.findAll());
		} 		
		modelAndView.addObject("unidades", unidadeDAO.findAll());
		modelAndView.addObject("arquivos", arquivoDAO.findAll());
		modelAndView.addObject("canais", canalDAO.findAll());
		modelAndView.addObject("gruposDePermissoes", grupoDePermissoesDAO.findAll());
		modelAndView.addObject("agendamentos", agendamentoDAO.findAll());
		return modelAndView;
	}
	
	@PostMapping("login")
	public ModelAndView login() {
		return this.configuracoes();
	}
		
}
