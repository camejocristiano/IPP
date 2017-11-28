package br.net.ipp.jpa.repository.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.configuracoes.Arquivo;

public interface ArquivoRepository extends PagingAndSortingRepository<Arquivo, Long> {
	Arquivo findById(Long id);
}
