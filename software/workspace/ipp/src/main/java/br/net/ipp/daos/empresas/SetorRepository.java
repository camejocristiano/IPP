package br.net.ipp.daos.empresas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Setor;

public interface SetorRepository extends PagingAndSortingRepository<Setor, Long> {
	List<Setor> findByEmpresa(Empresa empresa);
}
