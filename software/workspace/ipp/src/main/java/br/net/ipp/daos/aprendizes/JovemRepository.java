package br.net.ipp.daos.aprendizes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Jovem;

public interface JovemRepository extends PagingAndSortingRepository<Jovem, Long> {
	Jovem findByUsername(String username);
}
