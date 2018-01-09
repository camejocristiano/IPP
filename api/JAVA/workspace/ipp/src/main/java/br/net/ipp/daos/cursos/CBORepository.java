package br.net.ipp.daos.cursos;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.CBO;

public interface CBORepository extends PagingAndSortingRepository<CBO, Long> {

}
