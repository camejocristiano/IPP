package br.net.ipp.jpa.repository.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.configuracoes.GrupoDePermissoes;

public interface GrupoDePermissoesRepository extends PagingAndSortingRepository<GrupoDePermissoes, Long> {
	GrupoDePermissoes findById(Long id);
}
