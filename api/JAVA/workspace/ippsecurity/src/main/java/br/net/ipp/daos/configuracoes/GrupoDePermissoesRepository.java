package br.net.ipp.daos.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.GrupoDePermissoes;

public interface GrupoDePermissoesRepository extends PagingAndSortingRepository<GrupoDePermissoes, Long> {
	GrupoDePermissoes findById(Long id);
}
