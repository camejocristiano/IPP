package br.net.ipp.daos.cursos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.cursos.Turma;

public interface MatriculaRepository extends PagingAndSortingRepository<Matricula, Long> {
	List<Matricula> findAllByTurma(Turma turma);
	List<Matricula> findAllByJovem(Jovem jovem);
}
