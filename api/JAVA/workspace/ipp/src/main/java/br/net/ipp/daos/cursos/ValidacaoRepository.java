package br.net.ipp.daos.cursos;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.Validacao;

public interface ValidacaoRepository extends PagingAndSortingRepository<Validacao, Long> {

}
