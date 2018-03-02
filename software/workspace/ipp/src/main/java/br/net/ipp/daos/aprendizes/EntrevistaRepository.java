package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Entrevista;
import br.net.ipp.models.aprendizes.FichaProfissional;

public interface EntrevistaRepository extends PagingAndSortingRepository<Entrevista, Long> {
	List<Entrevista> findAllByFichaProfissional(FichaProfissional fichaProfissional);
	Entrevista findByFichaProfissional(FichaProfissional fichaProfissional);
}
