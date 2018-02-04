package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.AvaliacaoPIO;
import br.net.ipp.models.aprendizes.Jovem;

public interface AvaliacaoPIORepository extends PagingAndSortingRepository<AvaliacaoPIO, Long> {
	List<AvaliacaoPIO> findAllByJovem(Jovem jovem);
}
