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

import br.net.ipp.jpa.model.configuracoes.Agendamento;
import br.net.ipp.jpa.repository.configuracoes.AgendamentoRepository;

@RestController
public class AgendamentoEndpoint {
	
	private AgendamentoRepository agendamentoDAO;
	
	@Autowired
	public void AgendamentoEndPoint(AgendamentoRepository agendamentoDAO) {
		this.agendamentoDAO = agendamentoDAO;
	}
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/agendamentos")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(agendamentoDAO.findAll(), HttpStatus.OK);
    }
	@CrossOrigin(origins = "*")
	@GetMapping(path = "/agendamentos/{id}")
	public ResponseEntity<?> getAgendamentoById(@PathVariable("id") Long id) {
		verifyIfAgendamentoExists(id);
		Agendamento agendamento = agendamentoDAO.findOne(id);
	    return new ResponseEntity<>(agendamento, HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PostMapping(path = "/agendamentos")
	public ResponseEntity<?> save(@RequestBody Agendamento agendamento) {
		agendamento.setData(agendamento.getData());
	    return new ResponseEntity<>(agendamentoDAO.save(agendamento),HttpStatus.CREATED);
	}
	@CrossOrigin(origins = "*")
	@DeleteMapping(path = "/agendamentos/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfAgendamentoExists(id);
      	agendamentoDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/agendamentos")
    public ResponseEntity<?> update(@RequestBody Agendamento agendamento) {
		verifyIfAgendamentoExists(agendamento.getId());
        agendamentoDAO.save(agendamento);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfAgendamentoExists(Long id){
        if (agendamentoDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
	
}


