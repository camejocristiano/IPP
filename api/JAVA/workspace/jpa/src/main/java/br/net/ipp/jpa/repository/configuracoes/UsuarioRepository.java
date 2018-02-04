package br.net.ipp.jpa.repository.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.configuracoes.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>  {

	Usuario findByUsername(String username);

}
