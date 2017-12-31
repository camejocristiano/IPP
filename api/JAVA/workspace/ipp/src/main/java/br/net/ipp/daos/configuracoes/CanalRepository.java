package br.net.ipp.daos.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Canal;

public interface CanalRepository extends PagingAndSortingRepository<Canal, Long> {
	Canal findById(Long id);
	Canal findByCanal(String canal);
}
