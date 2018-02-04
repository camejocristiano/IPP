package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Jovem;
import br.net.ipp.models.aprendizes.OutroCurso;

public interface OutroCursoRepository extends PagingAndSortingRepository<OutroCurso, Long> {
	List<OutroCurso> findAllByJovem(Jovem jovem);
}
