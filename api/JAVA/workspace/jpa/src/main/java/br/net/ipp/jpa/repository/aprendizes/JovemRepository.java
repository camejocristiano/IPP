package br.net.ipp.jpa.repository.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.aprendizes.Jovem;

public interface JovemRepository extends PagingAndSortingRepository<Jovem, Long>  {

	List<Jovem> findByEmail(String email);
	
}
