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
	public void UsuarioEndPoint(
			UsuarioRepository usuarioDAO
			) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@GetMapping("/form")
	public ModelAndView usuario(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		modelAndView.addObject("usuario", usuario);
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
		}		
		return modelAndView;
	}

	@GetMapping("/{id}")
	public ModelAndView load(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		Usuario usuario = usuarioDAO.findOne(id);
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
	
	@PostMapping("/{id}")
	public ModelAndView update(@Valid Usuario usuario, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView("configuracoes/usuarios/usuario");
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("msg", "Algo saiu errado! Tente novamente, caso persista o erro, entre em contato com o desenvolvimento!");
			modelAndView.addObject("usuario", usuario);
		} else {
			usuarioDAO.save(usuario);
			modelAndView.addObject("usuario", usuario);
			modelAndView.addObject("msg", "Operação realizada com sucesso!");
		}	
		return modelAndView;
	}

}


