package br.net.ipp.daos.empresas;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.RepresentanteLegal;

public interface RepresentanteLegalRepository extends PagingAndSortingRepository<RepresentanteLegal, Long> {
	RepresentanteLegal findById(Long id);
}
