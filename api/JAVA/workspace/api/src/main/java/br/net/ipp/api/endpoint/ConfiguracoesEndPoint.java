package br.net.ipp.api.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.net.ipp.api.model.Usuario;
import br.net.ipp.api.repository.UsuarioRepository;

@RestController
@RequestMapping("/configuracoes")
public class ConfiguracoesEndPoint {
	
	private UsuarioRepository usuarioDAO;
	
	@Autowired
	public void UsuarioEndPoint(UsuarioRepository usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}
	
	@GetMapping(path = "/usuarios")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(usuarioDAO.findAll(), HttpStatus.OK);
    }
	
	@GetMapping(path = "/usuarios/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
	    verifyIfUsuarioExists(id);
	    Usuario usuario = usuarioDAO.findOne(id);
	    return new ResponseEntity<>(usuario, HttpStatus.OK);
	}
	
	@PostMapping(path = "/usuarios")
	public ResponseEntity<?> save(@RequestBody Usuario usuario) {
	    return new ResponseEntity<>(usuarioDAO.save(usuario),HttpStatus.CREATED);
	}
	 
	@DeleteMapping(path = "/usuarios/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfUsuarioExists(id);
      	usuarioDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	
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
	
	
	@GetMapping(path = "/test")
	public ResponseEntity<?> listAllTest() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario usu1 = new Usuario();
		Usuario usu2 = new Usuario();
		usu1.setNome("cristiano");
		usu1.setNome("camejo");
		usuarios.add(usu1);
		usuarios.add(usu2);
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
}

