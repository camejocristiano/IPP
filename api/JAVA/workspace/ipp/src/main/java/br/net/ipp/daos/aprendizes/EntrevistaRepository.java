package br.net.ipp.daos.aprendizes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Entrevista;

public interface EntrevistaRepository extends PagingAndSortingRepository<Entrevista, Long> {

}
