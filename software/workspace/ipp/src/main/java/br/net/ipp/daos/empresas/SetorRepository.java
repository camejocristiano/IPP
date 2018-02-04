package br.net.ipp.daos.empresas;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Setor;

public interface SetorRepository extends PagingAndSortingRepository<Setor, Long> {
	Setor findById(Long id);
}
