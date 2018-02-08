package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.SituacaoDeSaude;

public interface SituacaoDeSaudeRepository extends PagingAndSortingRepository<SituacaoDeSaude, Long> {
	List<SituacaoDeSaude> findAllByJovem(Jovem jovem);
	SituacaoDeSaude findByJovem(Jovem jovem);
}
