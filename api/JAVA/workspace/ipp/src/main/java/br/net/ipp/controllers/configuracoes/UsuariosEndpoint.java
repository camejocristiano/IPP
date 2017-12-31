package br.net.ipp.controllers.configuracoes;

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

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.Usuario;

@Controller
@Transactional
@RequestMapping("/usuarios")
public class UsuariosEndpoint {
	
	private UsuarioRepository usuarioDAO;
	
	@Autowired
	public void UsuarioEndPoint(UsuarioRepository usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

	@GetMapping("/form")
	public ModelAndView usuario(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		return modelAndView;
	}

	@PostMapping
	public ModelAndView save(@Valid Usuario usuario, BindingResult bindingResult) {
		usuario.setEmail("testando@email");
		usuario.setUsername("username");
		usuario.setNome("nome");
		usuario.setPassword("pass");
		usuario.setAdmin(true);
		usuario.setcPF(123456789);
		
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("corMsg", "red");
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
		} else {
			usuarioDAO.save(usuario);
			modelAndView.addObject("corMsg", "green");
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
			modelAndView.addObject("usuario", usuario);
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


