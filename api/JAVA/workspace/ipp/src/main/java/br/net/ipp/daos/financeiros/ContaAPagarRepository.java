package br.net.ipp.daos.financeiros;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.financeiros.ContaAPagar;

public interface ContaAPagarRepository extends PagingAndSortingRepository<ContaAPagar, Long> {

}
