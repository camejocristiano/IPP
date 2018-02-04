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

import br.net.ipp.jpa.model.configuracoes.Unidade;
import br.net.ipp.jpa.repository.configuracoes.UnidadeRepository;

@RestController
public class UnidadesEndpoint {
	
	private UnidadeRepository unidadeDAO;
	
	@Autowired
	public void UnidadeEndPoint(UnidadeRepository unidadeDAO) {
		this.unidadeDAO = unidadeDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/unidades")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(unidadeDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/unidades/{id}")
	public ResponseEntity<?> getUnidadeById(@PathVariable("id") Long id) {
		verifyIfUnidadeExists(id);
	    Unidade unidade = unidadeDAO.findOne(id);
	    return new ResponseEntity<>(unidade, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/unidades")
	public ResponseEntity<?> save(@RequestBody Unidade unidade) {
	    return new ResponseEntity<>(unidadeDAO.save(unidade),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/unidades/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfUnidadeExists(id);
      	unidadeDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/unidades")
    public ResponseEntity<?> update(@RequestBody Unidade unidade) {
		verifyIfUnidadeExists(unidade.getId());
        unidadeDAO.save(unidade);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfUnidadeExists(Long id){
        if (unidadeDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
	
}


