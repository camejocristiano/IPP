package br.net.ipp.daos.cursos;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.Matricula;

public interface MatriculaRepository extends PagingAndSortingRepository<Matricula, Long> {

}
