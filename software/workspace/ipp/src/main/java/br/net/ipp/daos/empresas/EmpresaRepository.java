package br.net.ipp.daos.empresas;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Empresa;

public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Long> {
	Empresa findById(Long id);
}
