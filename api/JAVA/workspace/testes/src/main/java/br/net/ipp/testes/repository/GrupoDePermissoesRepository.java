package br.net.ipp.testes.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.testes.model.GrupoDePermissoes;


public interface GrupoDePermissoesRepository extends PagingAndSortingRepository<GrupoDePermissoes, Long>  {

	GrupoDePermissoes findById(Long id);
}
