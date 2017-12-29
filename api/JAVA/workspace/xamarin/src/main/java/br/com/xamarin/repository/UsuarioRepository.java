package br.com.xamarin.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.xamarin.model.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>  {

	Usuario findByUsername(String username);

}
