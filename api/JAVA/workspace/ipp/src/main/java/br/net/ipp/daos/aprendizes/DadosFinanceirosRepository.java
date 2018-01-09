package br.net.ipp.daos.aprendizes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.DadosFinanceiros;

public interface DadosFinanceirosRepository extends PagingAndSortingRepository<DadosFinanceiros, Long> {

}
