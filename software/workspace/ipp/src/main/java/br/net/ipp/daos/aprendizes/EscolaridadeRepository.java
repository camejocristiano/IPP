package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Escolaridade;
import br.net.ipp.models.aprendizes.Jovem;

public interface EscolaridadeRepository extends PagingAndSortingRepository<Escolaridade, Long> {
	List<Escolaridade> findAllByJovem(Jovem jovem);
	Escolaridade findByJovem(Jovem jovem);
}
