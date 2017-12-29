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

import br.com.contatos.model.Evento;
import br.com.contatos.repository.EventoRepository;

@RestController
public class EventoEndpoint {
	
private EventoRepository eventoDAO;
	
	@Autowired
	public void EventoEndPoint(EventoRepository eventoDAO) {
		this.eventoDAO = eventoDAO;
	}
	@GetMapping(path = "/api/eventoapi")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(eventoDAO.findAll(), HttpStatus.OK);
    }
	@GetMapping(path = "/api/eventoapi/{id}")
	public ResponseEntity<?> getEventoById(@PathVariable("id") Long id) {
		verifyIfEventoExists(id);
	    Evento evento = eventoDAO.findOne(id);
	    return new ResponseEntity<>(evento, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/api/eventoapi")
	public ResponseEntity<?> save(@RequestBody Evento evento) {
	    return new ResponseEntity<>(eventoDAO.save(evento),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/api/eventoapi/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfEventoExists(id);
      	eventoDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/api/eventoapi")
    public ResponseEntity<?> update(@RequestBody Evento evento) {
		verifyIfEventoExists(evento.getId());
        eventoDAO.save(evento);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfEventoExists(Long id){
        if (eventoDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
}
