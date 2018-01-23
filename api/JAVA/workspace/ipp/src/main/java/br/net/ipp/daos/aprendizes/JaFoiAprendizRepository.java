package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.JaFoiAprendiz;
import br.net.ipp.models.aprendizes.Jovem;

public interface JaFoiAprendizRepository extends PagingAndSortingRepository<JaFoiAprendiz, Long> {
	List<JaFoiAprendiz> findAllByJovem(Jovem jovem);
}
