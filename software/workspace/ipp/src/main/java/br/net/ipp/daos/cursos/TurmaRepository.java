package br.net.ipp.daos.cursos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Usuario;
import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Turma;

public interface TurmaRepository extends PagingAndSortingRepository<Turma, Long> {
	List<Turma> findAllByCurso(Curso curso);
	List<Turma> findAllByOrientadorTurma(Usuario usuario);
}
