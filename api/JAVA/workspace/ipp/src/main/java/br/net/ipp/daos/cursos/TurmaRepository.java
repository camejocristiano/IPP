package br.net.ipp.daos.cursos;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.Turma;

public interface TurmaRepository extends PagingAndSortingRepository<Turma, Long> {

}
