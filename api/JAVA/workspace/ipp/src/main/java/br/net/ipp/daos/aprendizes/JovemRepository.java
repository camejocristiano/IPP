package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Jovem;

public interface JovemRepository extends PagingAndSortingRepository<Jovem, Long>  {

	List<Jovem> findByEmail(String email);
	
}
