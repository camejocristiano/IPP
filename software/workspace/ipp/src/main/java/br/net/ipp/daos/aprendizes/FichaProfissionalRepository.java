package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.FichaProfissional;
import br.net.ipp.models.aprendizes.Jovem;

public interface FichaProfissionalRepository extends PagingAndSortingRepository<FichaProfissional, Long> {
	List<FichaProfissional> findAllByJovem(Jovem jovem);
	FichaProfissional findByJovem(Jovem jovem);
}
