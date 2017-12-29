package br.net.ipp.controllers.configuracoes;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
public class UsuariosEndpoint {
	
	private UsuarioRepository usuarioDAO;
	
	@Autowired
	public void UsuarioEndPoint(UsuarioRepository usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@GetMapping("usuarios")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuarios");
		modelAndView.addObject("usuarios", usuarioDAO.findAll());
		return modelAndView;
	}

	@GetMapping("/usuario")
	public ModelAndView usuario() {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		return modelAndView;

	}

	@PostMapping("/usuarios")
	public ModelAndView save(@Valid Usuario usuario) {
		ModelAndView modelAndView = null;
		String email = usuario.getEmail();
		usuarioDAO.save(usuario);	
		Usuario usu = usuarioDAO.findByEmail(email);
		if (usu != null) {
			modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("usuario", usu);
		} else {
			modelAndView = new ModelAndView("configuracoes/usuarios/usuarios");			
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("usuarios", usuarioDAO.findAll());
		}		
		return modelAndView;
	}

	@GetMapping("/usuarios/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		modelAndView.addObject("usuario", usuarioDAO.findOne(id));
		return modelAndView;
	}
	
	@PostMapping("/usuarios/{id}")
	public ModelAndView update(@Valid Usuario usuario) {
		ModelAndView modelAndView = null;
		String email = usuario.getEmail();
		usuarioDAO.save(usuario);	
		Usuario usu = usuarioDAO.findByEmail(email);
		if (usu != null) {
			modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("usuario", usu);
		} else {
			modelAndView = new ModelAndView("configuracoes/usuarios/usuarios");			
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("usuarios", usuarioDAO.findAll());
		}		
		return modelAndView;

	}
	
}


