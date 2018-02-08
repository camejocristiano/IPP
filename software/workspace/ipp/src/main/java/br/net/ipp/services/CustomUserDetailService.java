package br.net.ipp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.net.ipp.daos.aprendizes.JovemRepository;
import br.net.ipp.daos.configuracoes.UsuarioRepository;
import br.net.ipp.daos.empresas.ContatoRepository;
import br.net.ipp.daos.empresas.GestorRepository;
import br.net.ipp.daos.empresas.RepresentanteLegalRepository;
import br.net.ipp.models.User;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    private final ContatoRepository contatoRepository;
    private final RepresentanteLegalRepository representanteLegalRepository;
    private final GestorRepository gestorRepository;
    private final JovemRepository jovemRepository;

    @Autowired
    public CustomUserDetailService(
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	User user = null;
    	if (usuarioRepository.findByUsername(username) != null) {
    		user = Optional.ofNullable(usuarioRepository.findByUsername(username))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));	
    	} else if (contatoRepository.findByUsername(username) != null) {
    		user = Optional.ofNullable(contatoRepository.findByUsername(username))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    	} else if (representanteLegalRepository.findByUsername(username) != null) {
    		user = Optional.ofNullable(representanteLegalRepository.findByUsername(username))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    	} else if (gestorRepository.findByUsername(username) != null) {
    		user = Optional.ofNullable(gestorRepository.findByUsername(username))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    	} else if (jovemRepository.findByUsername(username) != null) {
    		user = Optional.ofNullable(jovemRepository.findByUsername(username))
                    .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    	}
        List<GrantedAuthority> authorityListAdmin = AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN");
        List<GrantedAuthority> authorityListUser = AuthorityUtils.createAuthorityList("ROLE_USER");
        return new org.springframework.security.core.userdetails.User
                (user.getUsername(), user.getPassword(), user.isAdmin() ? authorityListAdmin : authorityListUser);
    }

}
