package br.net.ipp.daos.financeiros;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.financeiros.Banco;

public interface BancoRepository extends PagingAndSortingRepository<Banco, Long> {

}
