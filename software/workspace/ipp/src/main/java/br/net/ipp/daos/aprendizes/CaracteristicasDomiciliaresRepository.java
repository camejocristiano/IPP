package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.CaracteristicasDomiciliares;
import br.net.ipp.models.aprendizes.Jovem;

public interface CaracteristicasDomiciliaresRepository extends PagingAndSortingRepository<CaracteristicasDomiciliares, Long> {
	List<CaracteristicasDomiciliares> findAllByJovem(Jovem jovem);
	CaracteristicasDomiciliares findByJovem(Jovem jovem);
}
