package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.DadosFinanceiros;
import br.net.ipp.models.aprendizes.Jovem;

public interface DadosFinanceirosRepository extends PagingAndSortingRepository<DadosFinanceiros, Long> {
	List<DadosFinanceiros> findAllByJovem(Jovem jovem);
	DadosFinanceiros findByJovem(Jovem jovem);
}
