package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Historico;
import br.net.ipp.models.aprendizes.Jovem;

public interface HistoricoRepository extends PagingAndSortingRepository<Historico, Long> {
	List<Historico> findAllByJovem(Jovem jovem);
}
