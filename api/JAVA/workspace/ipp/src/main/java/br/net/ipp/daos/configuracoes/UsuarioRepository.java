package br.net.ipp.daos.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>  {
	Usuario findByEmail(String email);
}
