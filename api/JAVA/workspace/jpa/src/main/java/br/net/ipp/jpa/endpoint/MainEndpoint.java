package br.net.ipp.jpa.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.net.ipp.jpa.model.User;
import br.net.ipp.jpa.repository.UserRepository;

@RestController
@RequestMapping("/endpoint")
public class MainEndpoint {
	
	private UserRepository userDAO;
	
	@Autowired
	public void UsuarioEndPoint(UserRepository userDAO) {
		this.userDAO = userDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/users")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/users/{id}")
	public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
		verifyIfUserExists(id);
	    User user = userDAO.findOne(id);
	    return new ResponseEntity<>(user, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/users")
	public ResponseEntity<?> save(@RequestBody User user) {
	    return new ResponseEntity<>(userDAO.save(user),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfUserExists(id);
      	userDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/users")
    public ResponseEntity<?> update(@RequestBody User user) {
		verifyIfUserExists(user.getId());
        userDAO.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfUserExists(Long id){
        if (userDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
	
}


