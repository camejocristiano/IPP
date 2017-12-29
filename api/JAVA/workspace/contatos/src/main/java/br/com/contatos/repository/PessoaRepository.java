package br.com.contatos.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.contatos.model.Pessoa;

public interface PessoaRepository extends PagingAndSortingRepository<Pessoa, Long>  {

	List<Pessoa> findById(Long id);
	
}
