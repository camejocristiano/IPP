package br.net.ipp.daos.cursos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.enums.Status;
import br.net.ipp.models.cursos.ArcoOcupacional;
import br.net.ipp.models.cursos.Curso;

public interface CursoRepository extends PagingAndSortingRepository<Curso, Long> {
	Curso findByArcoOcupacional(ArcoOcupacional arcoOcupacional);
	List<Curso> findAllByStatus(Status status);
}
