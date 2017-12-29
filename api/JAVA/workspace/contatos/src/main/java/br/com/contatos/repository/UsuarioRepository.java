package br.com.contatos.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.contatos.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>  {

	List<Usuario> findById(Long id);
	
}
