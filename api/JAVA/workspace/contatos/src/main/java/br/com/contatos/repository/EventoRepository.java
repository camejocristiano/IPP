package br.com.contatos.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.contatos.model.Evento;

public interface EventoRepository extends PagingAndSortingRepository<Evento, Long>  {

	List<Evento> findById(Long id);
}
