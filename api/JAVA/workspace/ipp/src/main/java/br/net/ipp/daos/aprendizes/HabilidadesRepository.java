package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Habilidades;
import br.net.ipp.models.aprendizes.Jovem;

public interface HabilidadesRepository extends PagingAndSortingRepository<Habilidades, Long> {
	List<Habilidades> findAllByJovem(Jovem jovem);
}
