package br.net.ipp.daos.cursos;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.Curso;
import br.net.ipp.models.cursos.Validacao;

public interface ValidacaoRepository extends PagingAndSortingRepository<Validacao, Long> {
	List<Validacao> findByCurso(Curso curso);
}
