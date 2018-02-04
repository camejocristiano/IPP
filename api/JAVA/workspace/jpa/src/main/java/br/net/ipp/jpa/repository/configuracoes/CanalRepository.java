package br.net.ipp.jpa.repository.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.configuracoes.Canal;

public interface CanalRepository extends PagingAndSortingRepository<Canal, Long> {
	Canal findById(Long id);
}
