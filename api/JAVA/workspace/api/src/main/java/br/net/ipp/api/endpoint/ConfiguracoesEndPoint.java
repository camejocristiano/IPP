package br.net.ipp.api.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.ipp.api.model.User;
import br.net.ipp.api.repository.UserRepository;

@RestController
@RequestMapping("/configuracoes")
public class ConfiguracoesEndPoint {
	
	private UserRepository usuarioDAO;
	
	@Autowired
	public void UsuarioEndPoint(UserRepository usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@GetMapping(path = "/usuarios")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(usuarioDAO.findAll(), HttpStatus.OK);
    }
	
	@GetMapping(path = "/protected/usuarios/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id, 
			@AuthenticationPrincipal UserDetails userDetails) {
		verifyIfUserExists(id);
	    User user = usuarioDAO.findOne(id);
	    return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@PostMapping(path = "/admin/usuarios")
	public ResponseEntity<?> save(@RequestBody User user) {
	    return new ResponseEntity<>(usuarioDAO.save(user),HttpStatus.CREATED);
	}
	 
	@DeleteMapping(path = "/admin/usuarios/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfUserExists(id);
      	usuarioDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/admin/usuarios")
    public ResponseEntity<?> update(@RequestBody User user) {
		verifyIfUserExists(user.getId());
        usuarioDAO.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfUserExists(Long id){
        if (usuarioDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
	
	@GetMapping(path = "/test")
	public ResponseEntity<?> listAllTest() {
		List<User> users = new ArrayList<User>();
		User usu1 = new User();
		User usu2 = new User();
		usu1.setNome("cristiano");
		usu1.setNome("camejo");
		users.add(usu1);
		users.add(usu2);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}
	
}

