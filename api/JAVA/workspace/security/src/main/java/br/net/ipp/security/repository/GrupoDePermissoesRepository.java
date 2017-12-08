package br.net.ipp.security.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.security.model.GrupoDePermissoes;


public interface GrupoDePermissoesRepository extends PagingAndSortingRepository<GrupoDePermissoes, Long>  {

	GrupoDePermissoes findById(Long id);
}
