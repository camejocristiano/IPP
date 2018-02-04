package br.net.ipp.daos.cursos;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.ConteudoTeoricoBasico;

public interface ConteudoTeoricoBasicoRepository extends PagingAndSortingRepository<ConteudoTeoricoBasico, Long> {
}
