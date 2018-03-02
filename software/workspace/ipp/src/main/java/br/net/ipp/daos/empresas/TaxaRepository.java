package br.net.ipp.daos.empresas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Taxa;

public interface TaxaRepository extends PagingAndSortingRepository<Taxa, Long> {
	List<Taxa> findByEmpresa(Empresa empresa);
}
