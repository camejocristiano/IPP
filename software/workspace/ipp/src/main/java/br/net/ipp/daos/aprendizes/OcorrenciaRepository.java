package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.Ocorrencia;

public interface OcorrenciaRepository extends PagingAndSortingRepository<Ocorrencia, Long> {
	List<Ocorrencia> findAllByJovem(Jovem jovem);
}
