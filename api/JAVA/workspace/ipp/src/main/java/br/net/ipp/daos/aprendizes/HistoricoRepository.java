package br.net.ipp.daos.aprendizes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Historico;

public interface HistoricoRepository extends PagingAndSortingRepository<Historico, Long> {

}
