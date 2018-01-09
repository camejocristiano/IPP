package br.net.ipp.daos.financeiros;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.financeiros.Parametro;

public interface ParametroRepository extends PagingAndSortingRepository<Parametro, Long> {

}
