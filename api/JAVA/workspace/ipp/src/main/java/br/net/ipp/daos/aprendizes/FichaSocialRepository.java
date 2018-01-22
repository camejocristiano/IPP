package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.FichaSocial;
import br.net.ipp.models.aprendizes.Jovem;

public interface FichaSocialRepository extends PagingAndSortingRepository<FichaSocial, Long> {
	List<FichaSocial> findAllByJovem(Jovem jovem);
}
