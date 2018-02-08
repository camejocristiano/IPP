package br.net.ipp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;

@Service
public class UserService {

	private UsuarioRepository usuarioRepository;
	private JovemRepository jovemRepository;
	private ContatoRepository contatoRepository;
	private RepresentanteLegalRepository representanteLegalRepository;
	private GestorRepository gestorRepository;
	
	@Autowired
	public UserService(
			UsuarioRepository usuarioRepository,
			JovemRepository jovemRepository,
			ContatoRepository contatoRepository,
			RepresentanteLegalRepository representanteLegalRepository,
			GestorRepository gestorRepository
			) {
		this.usuarioRepository = usuarioRepository;
		this.jovemRepository = jovemRepository;
		this.contatoRepository = contatoRepository;
		this.representanteLegalRepository = representanteLegalRepository;
		this.gestorRepository = gestorRepository;
	}

	public Object permissao(@AuthenticationPrincipal UserDetails userDetails) {
		Object object = null;
		if (usuarioRepository.findByUsername(userDetails.getUsername()) != null) {
			object = contatoRepository.findByUsername(userDetails.getUsername());
    	} else if (contatoRepository.findByUsername(userDetails.getUsername()) != null) {
    		object = contatoRepository.findByUsername(userDetails.getUsername());
    	} else if (representanteLegalRepository.findByUsername(userDetails.getUsername()) != null) {
    		object = representanteLegalRepository.findByUsername(userDetails.getUsername());
    	} else if (gestorRepository.findByUsername(userDetails.getUsername()) != null) {
    		object = gestorRepository.findByUsername(userDetails.getUsername());
    	} else if (jovemRepository.findByUsername(userDetails.getUsername()) != null) {
    		object = jovemRepository.findByUsername(userDetails.getUsername());
    	}
		return object;
	}
	
}
