package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.AvaliacaoPAPIPP;
import br.net.ipp.models.aprendizes.Historico;

public interface AvaliacaoPAPIPPRepository extends PagingAndSortingRepository<AvaliacaoPAPIPP, Long> {
	List<AvaliacaoPAPIPP> findAllByHistorico(Historico historico);
	AvaliacaoPAPIPP findByHistorico(Historico historico);
}
