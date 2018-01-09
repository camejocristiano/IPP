package br.net.ipp.daos.aprendizes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Escolaridade;

public interface EscolaridadeRepository extends PagingAndSortingRepository<Escolaridade, Long> {
	Escolaridade findById(Long id);
}
