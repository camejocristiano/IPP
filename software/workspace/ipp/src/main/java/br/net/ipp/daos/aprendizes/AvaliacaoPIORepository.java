package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.AvaliacaoPIO;
import br.net.ipp.models.aprendizes.Historico;

public interface AvaliacaoPIORepository extends PagingAndSortingRepository<AvaliacaoPIO, Long> {
	List<AvaliacaoPIO> findAllByHistorico(Historico historico);
	AvaliacaoPIO findByHistorico(Historico historico);
}
