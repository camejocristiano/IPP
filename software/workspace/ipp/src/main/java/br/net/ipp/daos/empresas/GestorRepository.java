package br.net.ipp.daos.empresas;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Gestor;

public interface GestorRepository extends PagingAndSortingRepository<Gestor, Long> {
	Gestor findById(Long id);
}
