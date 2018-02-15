package br.net.ipp.controllers;

import java.io.IOException;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.services.PasswordGenerator;

@Controller
public class SimpleEmailController {
    
    @Autowired
    private JavaMailSender sender;
    private PasswordGenerator passwordGenerator;
    private UsuarioRepository usuarioRepository;

    public SimpleEmailController(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}
    
    @PostMapping("/password")
    public ModelAndView home(HttpServletRequest request) throws IOException {
    	ModelAndView modelAndView = new ModelAndView("login");
    	String destino = request.getParameter("email");
    	String password = this.passwordGenerator();
        try {
            sendEmail(destino, password);
            savePassword(destino, password);
            modelAndView.addObject("color", "green");
            modelAndView.addObject("msg", "Nova senha enviada ao email digitado!");
            return modelAndView;
        }catch(Exception ex) {
            modelAndView.addObject("color", "red");
        	modelAndView.addObject("msg", "Tente novamente!");
            return modelAndView;
        }
    }

    private void sendEmail(String destino, String password) throws Exception {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);
        helper.setTo(destino);
        helper.setText(password);
        helper.setSubject("Senha Provisória!");
        
        sender.send(message);
    }
    
    private void savePassword(String destino, String password) throws Exception {
    	Usuario usuario = this.usuarioRepository.findByUsername(destino);
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		usuario.setPassword(passwordEncoder.encode(password));
    	this.usuarioRepository.save(usuario);
    }
    
    private String passwordGenerator() {
    	passwordGenerator = new PasswordGenerator();
    	String password = passwordGenerator.getRandomPassword();
		return password;
    	
    }
}