package br.net.ipp.daos.empresas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.CargaHoraria;
import br.net.ipp.models.empresas.Empresa;

public interface CargaHorariaRepository extends PagingAndSortingRepository<CargaHoraria, Long> {
	List<CargaHoraria> findByEmpresa(Empresa empresa);
}
