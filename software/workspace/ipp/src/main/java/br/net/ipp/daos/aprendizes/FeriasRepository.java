package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Ferias;
import br.net.ipp.models.aprendizes.FichaProfissional;

public interface FeriasRepository extends PagingAndSortingRepository<Ferias, Long> {
	List<Ferias> findAllByFichaProfissional(FichaProfissional fichaProfissional);
	Ferias findByFichaProfissional(FichaProfissional fichaProfissional);
}
