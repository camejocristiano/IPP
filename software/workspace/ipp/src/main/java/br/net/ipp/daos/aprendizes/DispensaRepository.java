package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Dispensa;
import br.net.ipp.models.aprendizes.Jovem;

public interface DispensaRepository extends PagingAndSortingRepository<Dispensa, Long> {
	List<Dispensa> findAllByJovem(Jovem jovem);
	Dispensa findByJovem(Jovem jovem);
}
