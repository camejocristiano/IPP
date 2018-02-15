package br.net.ipp.daos.configuracoes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Unidade;
import br.net.ipp.models.configuracoes.Usuario;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Long>  {
	Usuario findByUsername(String username);
	List<Usuario> findAllByUnidade(Unidade unidade);
}
