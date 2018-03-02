package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.AvaliacaoPIP;
import br.net.ipp.models.aprendizes.Historico;

public interface AvaliacaoPIPRepository extends PagingAndSortingRepository<AvaliacaoPIP, Long> {
	List<AvaliacaoPIP> findAllByHistorico(Historico historico);
	AvaliacaoPIP findByHistorico(Historico historico);
}
