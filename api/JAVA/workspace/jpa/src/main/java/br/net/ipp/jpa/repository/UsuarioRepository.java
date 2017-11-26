package br.net.ipp.jpa.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>  {

	List<Usuario> findByNome(String nome);
	
}
