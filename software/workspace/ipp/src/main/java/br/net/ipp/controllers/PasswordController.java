package br.net.ipp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.PasswordGenerator;
import br.net.ipp.services.SenderMailService;

@Controller
public class PasswordController {

	private UsuarioRepository usuarioRepository;
	private PasswordGenerator passwordGenerator;
	private SenderMailService senderMailService;
	private JavaMailSender mailSender;
	
	@Autowired
	public PasswordController(
			UsuarioRepository usuarioRepository,
			PasswordGenerator passwordGenerator,
			SenderMailService senderMailService
			) {
		this.usuarioRepository = usuarioRepository;
		this.passwordGenerator = new PasswordGenerator();
		this.senderMailService = new SenderMailService();
	}
	
	@GetMapping("/sw/alterarSenha")
	public ModelAndView alterarSenha(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("password");
		return modelAndView.addObject("usuario", usuarioRepository.findByUsername(userDetails.getUsername()));
	}
	
	@PostMapping("/sw/password")
	public ModelAndView password(@AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) throws IOException {
		Usuario usuario = usuarioRepository.findByUsername(userDetails.getUsername());
		String password = request.getParameter("password");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(passwordEncoder.encode(password));
		usuarioRepository.save(usuario);
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/usuario/"+usuario.getId());
		return modelAndView.addObject("usuario", usuario);
	}
	
	@GetMapping("/esqueciMinhaSenha")
	public ModelAndView esqueciMinhaSenha() {
		ModelAndView modelAndView = new ModelAndView("esqueci_minha_senha");
		return modelAndView;
	}
	
/*	@PostMapping("/password")
	public ModelAndView enviarMinhaSenha(HttpServletRequest request) throws IOException {
		Usuario usuario = usuarioRepository.findByUsername("camejocristiano@outlook.com");
		String password = this.passwordGenerator.getRandomPassword(); 
		usuario.setPassword(password);
		SimpleMailMessage email = new SimpleMailMessage();
        email.setTo("camejocristiano@outlook.com");
        email.setSubject("subject");
        email.setText("text");
        mailSender.send(email);
	    //this.senderMailService.enviar();
		//usuarioRepository.save(usuario);
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView; //.addObject("usuario", usuario);
	}*/
	
}