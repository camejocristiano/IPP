package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.configuracoes.Unidade;

public interface JovemRepository extends PagingAndSortingRepository<Jovem, Long> {
	Jovem findByUsername(String username);
	List<Jovem> findAllByUnidade(Unidade unidade);
}
