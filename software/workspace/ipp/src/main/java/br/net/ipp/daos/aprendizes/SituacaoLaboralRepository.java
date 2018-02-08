package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.SituacaoLaboral;

public interface SituacaoLaboralRepository extends PagingAndSortingRepository<SituacaoLaboral, Long> {
	List<SituacaoLaboral> findAllByJovem(Jovem jovem);
	SituacaoLaboral findByJovem(Jovem jovem);
}
