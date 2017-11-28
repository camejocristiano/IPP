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

import br.net.ipp.jpa.model.configuracoes.GrupoDePermissoes;
import br.net.ipp.jpa.repository.configuracoes.GrupoDePermissoesRepository;

@RestController
public class GruposDePermissoesEndpoint {
	
	private GrupoDePermissoesRepository grupoDePermissoesDAO;
	
	@Autowired
	public void GrupoDePermissoesEndPoint(GrupoDePermissoesRepository grupoDePermissoesDAO) {
		this.grupoDePermissoesDAO = grupoDePermissoesDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/grupoDePermissoess")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(grupoDePermissoesDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/grupoDePermissoess/{id}")
	public ResponseEntity<?> getGrupoDePermissoesById(@PathVariable("id") Long id) {
		verifyIfGrupoDePermissoesExists(id);
	    GrupoDePermissoes grupoDePermissoes = grupoDePermissoesDAO.findOne(id);
	    return new ResponseEntity<>(grupoDePermissoes, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/grupoDePermissoess")
	public ResponseEntity<?> save(@RequestBody GrupoDePermissoes grupoDePermissoes) {
	    return new ResponseEntity<>(grupoDePermissoesDAO.save(grupoDePermissoes),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/grupoDePermissoess/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfGrupoDePermissoesExists(id);
      	grupoDePermissoesDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/grupoDePermissoess")
    public ResponseEntity<?> update(@RequestBody GrupoDePermissoes grupoDePermissoes) {
		verifyIfGrupoDePermissoesExists(grupoDePermissoes.getId());
        grupoDePermissoesDAO.save(grupoDePermissoes);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfGrupoDePermissoesExists(Long id){
        if (grupoDePermissoesDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
	
}


