package br.net.ipp.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Gestor;
import br.net.ipp.models.empresas.RepresentanteLegal;

@Controller
public class PasswordController {

	private UsuarioRepository usuarioRepository;
	private ContatoRepository contatoRepository;
    private RepresentanteLegalRepository representanteLegalRepository;
    private GestorRepository gestorRepository;
    private JovemRepository jovemRepository;
	
	@Autowired
	public PasswordController(
			UsuarioRepository usuarioRepository,
			ContatoRepository contatoRepository,
    		RepresentanteLegalRepository representanteLegalRepository,
    		GestorRepository gestorRepository,
    		JovemRepository jovemRepository
			) {
		this.usuarioRepository = usuarioRepository;
		this.contatoRepository = contatoRepository;
        this.representanteLegalRepository = representanteLegalRepository;
        this.gestorRepository = gestorRepository;
        this.jovemRepository = jovemRepository;
	}
	
	@GetMapping("/sw/alterarSenha")
	public ModelAndView alterarSenha(@AuthenticationPrincipal UserDetails userDetails) {
		ModelAndView modelAndView = new ModelAndView("password");
		return modelAndView.addObject("usuario", usuarioRepository.findByUsername(userDetails.getUsername()));
	}
	
	@PostMapping("/sw/password")
	public ModelAndView password(@AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) throws IOException {
		ModelAndView modelAndView = null;
		String password = request.getParameter("password");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			Usuario usuario = usuarioRepository.findByUsername(userDetails.getUsername());
			usuario.setPassword(passwordEncoder.encode(password));
			usuarioRepository.save(usuario);
		} else
		if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
			Contato contato = contatoRepository.findByUsername(userDetails.getUsername());
			contato.setPassword(passwordEncoder.encode(password));
			contatoRepository.save(contato);
		} else
		if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
			RepresentanteLegal representanteLegal = representanteLegalRepository.findByUsername(userDetails.getUsername());
			representanteLegal.setPassword(passwordEncoder.encode(password));
			representanteLegalRepository.save(representanteLegal);
		} else
		if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
			Gestor gestor = gestorRepository.findByUsername(userDetails.getUsername());
			gestor.setPassword(passwordEncoder.encode(password));
			gestorRepository.save(gestor);
		} else
		if (jovemRepository.findByUsername(userDetails.getUsername()) != null) {
			Jovem jovem = jovemRepository.findByUsername(userDetails.getUsername());
			jovem.setPassword(passwordEncoder.encode(password));
			jovemRepository.save(jovem);
		}
		modelAndView = new ModelAndView("redirect:/logout");
		return modelAndView;
	}
	
	/*@PostMapping("/sw/password")
	public ModelAndView password(@AuthenticationPrincipal UserDetails userDetails, HttpServletRequest request) throws IOException {
		Usuario usuario = usuarioRepository.findByUsername(userDetails.getUsername());
		String password = request.getParameter("password");
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(passwordEncoder.encode(password));
		usuarioRepository.save(usuario);
		ModelAndView modelAndView = new ModelAndView("redirect:/sw/usuario/"+usuario.getId());
		return modelAndView.addObject("usuario", usuario);
	}*/
	
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