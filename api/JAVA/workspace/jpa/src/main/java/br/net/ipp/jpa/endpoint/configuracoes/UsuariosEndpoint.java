package br.net.ipp.jpa.endpoint.configuracoes;

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
import org.springframework.web.bind.annotation.RestController;

import br.net.ipp.jpa.model.configuracoes.Usuario;
import br.net.ipp.jpa.repository.configuracoes.UsuarioRepository;

@RestController
public class UsuariosEndpoint {
	
	private UsuarioRepository usuarioDAO;
	
	@Autowired
	public void UsuarioEndPoint(UsuarioRepository usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/usuarios")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(usuarioDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/usuarios/{id}")
	public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id) {
		verifyIfUsuarioExists(id);
	    Usuario usuario = usuarioDAO.findOne(id);
	    return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/usuarios")
	public ResponseEntity<?> save(@RequestBody Usuario usuario) {
	    return new ResponseEntity<>(usuarioDAO.save(usuario),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfUsuarioExists(id);
      	usuarioDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/usuarios")
    public ResponseEntity<?> update(@RequestBody Usuario usuario) {
		verifyIfUsuarioExists(usuario.getId());
        usuarioDAO.save(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfUsuarioExists(Long id){
        if (usuarioDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
	
}


