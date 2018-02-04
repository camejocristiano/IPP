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

import br.net.ipp.jpa.model.TodoItem;
import br.net.ipp.jpa.repository.TodoItemRepository;

@RestController
public class TodoItemEndpoint {
	
private TodoItemRepository todoItemDAO;
	
	@Autowired
	public void TodoItemEndPoint(TodoItemRepository todoItemDAO) {
		this.todoItemDAO = todoItemDAO;
	}
	@GetMapping(path = "/todoitems")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<>(todoItemDAO.findAll(), HttpStatus.OK);
    }
	@GetMapping(path = "/todoitems/{id}")
	public ResponseEntity<?> getTodoItemById(@PathVariable("id") Long id) {
		verifyIfTodoItemExists(id);
	    TodoItem todoItem = todoItemDAO.findOne(id);
	    return new ResponseEntity<>(todoItem, HttpStatus.OK);
	}
	@PostMapping(path = "/todoitems")
	public ResponseEntity<?> save(@RequestBody TodoItem todoItem) {
		TodoItem inserir = new TodoItem();
		inserir.setName(todoItem.getName());
		inserir.setDone(todoItem.isDone());
		inserir.setNotes(todoItem.getNotes());
		todoItemDAO.save(inserir);
	    return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@DeleteMapping(path = "/todoitems/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfTodoItemExists(id);
      	todoItemDAO.delete(id);
      	return new ResponseEntity<>(HttpStatus.OK);
	}
	@CrossOrigin(origins = "*")
	@PutMapping(path = "/todoitems")
    public ResponseEntity<?> update(@RequestBody TodoItem todoItem) {
		verifyIfTodoItemExists(todoItem.getId());
        todoItemDAO.save(todoItem);
        return new ResponseEntity<>(HttpStatus.OK);
    }
	
	private boolean verifyIfTodoItemExists(Long id){
        if (todoItemDAO.findOne(id) != null) {
        	return true;
        }
		return false;
    }
	
}


