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
import org.springframework.web.bind.annotation.RestController;

import br.net.ipp.jpa.model.aprendizes.Jovem;
import br.net.ipp.jpa.repository.aprendizes.JovemRepository;

@RestController
public class JovensEndpoint {
	
private JovemRepository jovemDAO;
	
	@Autowired
	public void JovemEndPoint(JovemRepository jovemDAO) {
		this.jovemDAO = jovemDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/jovens")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(jovemDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/jovens/{id}")
	public ResponseEntity<?> getJovemById(@PathVariable("id") Long id) {
		verifyIfJovemExists(id);
	    Jovem jovem = jovemDAO.findOne(id);
	    return new ResponseEntity<>(jovem, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/jovens")
	public ResponseEntity<?> save(@RequestBody Jovem jovem) {
	    return new ResponseEntity<>(jovemDAO.save(jovem),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/jovens/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfJovemExists(id);
      	jovemDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/jovens")
    public ResponseEntity<?> update(@RequestBody Jovem jovem) {
		verifyIfJovemExists(jovem.getId());
        jovemDAO.save(jovem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfJovemExists(Long id){
        if (jovemDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
}


