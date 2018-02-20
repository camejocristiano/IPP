package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.AvaliacaoPIT;
import br.net.ipp.models.aprendizes.Jovem;

public interface AvaliacaoPITRepository extends PagingAndSortingRepository<AvaliacaoPIT, Long> {
	List<AvaliacaoPIT> findAllByJovem(Jovem jovem);
}
