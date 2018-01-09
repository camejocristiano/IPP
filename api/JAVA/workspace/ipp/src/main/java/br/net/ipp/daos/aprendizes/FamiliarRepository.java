package br.net.ipp.daos.aprendizes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Familiar;

public interface FamiliarRepository extends PagingAndSortingRepository<Familiar, Long> {

}
