package br.net.ipp.daos.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Unidade;

public interface UnidadeRepository extends PagingAndSortingRepository<Unidade, Long> {
	Unidade findById(Long id);
}
