package br.net.ipp.daos.empresas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Historicos;

public interface HistoricosRepository extends PagingAndSortingRepository<Historicos, Long> {
	List<Historicos> findByEmpresa(Empresa empresa);
}
