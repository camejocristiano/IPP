package br.com.xamarin.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.xamarin.model.TodoItem;

public interface TodoItemRepository extends PagingAndSortingRepository<TodoItem, Long>  {

	List<TodoItem> findById(Long id);
	
}
