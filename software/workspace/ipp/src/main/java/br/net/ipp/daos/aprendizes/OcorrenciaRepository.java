package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Historico;
import br.net.ipp.models.aprendizes.Ocorrencia;

public interface OcorrenciaRepository extends PagingAndSortingRepository<Ocorrencia, Long> {
	List<Ocorrencia> findAllByHistorico(Historico historico);
	Ocorrencia findByHistorico(Historico historico);
}
