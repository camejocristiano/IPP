package br.net.ipp.jpa.repository.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.configuracoes.Unidade;

public interface UnidadeRepository extends PagingAndSortingRepository<Unidade, Long> {
	Unidade findById(Long id);
}
