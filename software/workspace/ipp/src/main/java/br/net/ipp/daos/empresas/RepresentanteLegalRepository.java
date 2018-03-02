package br.net.ipp.daos.empresas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.RepresentanteLegal;

public interface RepresentanteLegalRepository extends PagingAndSortingRepository<RepresentanteLegal, Long> {
	RepresentanteLegal findByUsername(String username);
	List<RepresentanteLegal> findByEmpresa(Empresa empresa);
}
