package br.net.ipp.daos.financeiros;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.financeiros.Demonstrativo;

public interface DemonstrativoRepository extends PagingAndSortingRepository<Demonstrativo, Long> {

}
