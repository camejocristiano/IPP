package br.net.ipp.daos.cursos;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.ArcoOcupacional;
import br.net.ipp.models.cursos.Curso;

public interface CursoRepository extends PagingAndSortingRepository<Curso, Long> {
	Curso findByArcoOcupacional(ArcoOcupacional arcoOcupacional);
}
