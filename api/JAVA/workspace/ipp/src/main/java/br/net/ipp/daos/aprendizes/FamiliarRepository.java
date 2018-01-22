package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Familiar;
import br.net.ipp.models.aprendizes.Jovem;

public interface FamiliarRepository extends PagingAndSortingRepository<Familiar, Long> {
	List<Familiar> findAllByJovem(Jovem jovem);
}
