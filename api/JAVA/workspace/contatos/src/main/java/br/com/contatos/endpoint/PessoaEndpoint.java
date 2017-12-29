package br.com.contatos.endpoint;

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

import br.com.contatos.model.Pessoa;
import br.com.contatos.repository.PessoaRepository;

@RestController
public class PessoaEndpoint {
	
private PessoaRepository pessoaDAO;
	
	@Autowired
	public void PessoaEndPoint(PessoaRepository pessoaDAO) {
		this.pessoaDAO = pessoaDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/api/pessoaapi")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(pessoaDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/api/pessoaapi/{id}")
	public ResponseEntity<?> getPessoaById(@PathVariable("id") Long id) {
		verifyIfPessoaExists(id);
	    Pessoa pessoa = pessoaDAO.findOne(id);
	    return new ResponseEntity<>(pessoa, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/api/pessoaapi")
	public ResponseEntity<?> save(@RequestBody Pessoa pessoa) {
	    return new ResponseEntity<>(pessoaDAO.save(pessoa),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/api/pessoaapi/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfPessoaExists(id);
      	pessoaDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/api/pessoaapi")
    public ResponseEntity<?> update(@RequestBody Pessoa pessoa) {
		verifyIfPessoaExists(pessoa.getId());
        pessoaDAO.save(pessoa);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfPessoaExists(Long id){
        if (pessoaDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
}
