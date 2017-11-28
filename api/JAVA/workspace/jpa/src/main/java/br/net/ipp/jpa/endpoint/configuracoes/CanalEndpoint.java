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

import br.net.ipp.jpa.model.configuracoes.Canal;
import br.net.ipp.jpa.repository.configuracoes.CanalRepository;

@RestController
public class CanalEndpoint {
	
	private CanalRepository canalDAO;
	
	@Autowired
	public void CanalEndPoint(CanalRepository canalDAO) {
		this.canalDAO = canalDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/canais")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(canalDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/canais/{id}")
	public ResponseEntity<?> getCanalById(@PathVariable("id") Long id) {
		verifyIfCanalExists(id);
	    Canal canal = canalDAO.findOne(id);
	    return new ResponseEntity<>(canal, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/canais")
	public ResponseEntity<?> save(@RequestBody Canal canal) {
	    return new ResponseEntity<>(canalDAO.save(canal),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/canais/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfCanalExists(id);
      	canalDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/canais")
    public ResponseEntity<?> update(@RequestBody Canal canal) {
		verifyIfCanalExists(canal.getId());
        canalDAO.save(canal);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfCanalExists(Long id){
        if (canalDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
	
}


