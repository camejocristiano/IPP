package br.net.ipp.jpa.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.TodoItem;

public interface TodoItemRepository extends PagingAndSortingRepository<TodoItem, Long>  {

	List<TodoItem> findById(Long id);
	
}
