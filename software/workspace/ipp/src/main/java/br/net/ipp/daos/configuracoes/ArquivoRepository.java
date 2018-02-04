package br.net.ipp.daos.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Arquivo;

public interface ArquivoRepository extends PagingAndSortingRepository<Arquivo, Long> {
	Arquivo findById(Long id);
}
