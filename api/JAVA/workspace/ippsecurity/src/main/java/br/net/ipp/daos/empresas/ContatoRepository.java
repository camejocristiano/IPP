package br.net.ipp.daos.empresas;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Contato;

public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long> {
	Contato findByUsername(String username);
}
