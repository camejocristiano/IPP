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

import br.net.ipp.jpa.model.configuracoes.Arquivo;
import br.net.ipp.jpa.repository.configuracoes.ArquivoRepository;

@RestController
public class ArquivoEndpoint {
	
	private ArquivoRepository arquivoDAO;
	
	@Autowired
	public void ArquivoEndPoint(ArquivoRepository arquivoDAO) {
		this.arquivoDAO = arquivoDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/arquivos")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(arquivoDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/arquivos/{id}")
	public ResponseEntity<?> getArquivoById(@PathVariable("id") Long id) {
		verifyIfArquivoExists(id);
	    Arquivo arquivo = arquivoDAO.findOne(id);
	    return new ResponseEntity<>(arquivo, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/arquivos")
	public ResponseEntity<?> save(@RequestBody Arquivo arquivo) {
	    return new ResponseEntity<>(arquivoDAO.save(arquivo),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/arquivos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfArquivoExists(id);
      	arquivoDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/arquivos")
    public ResponseEntity<?> update(@RequestBody Arquivo arquivo) {
		verifyIfArquivoExists(arquivo.getId());
        arquivoDAO.save(arquivo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfArquivoExists(Long id){
        if (arquivoDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
	
}


