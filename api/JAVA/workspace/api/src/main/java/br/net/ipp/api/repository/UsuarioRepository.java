package br.net.ipp.api.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.api.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>  {

	List<Usuario> findByNome(String nome);
	
}
