package br.net.ipp.daos.empresas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Empresa;
import br.net.ipp.models.empresas.Gestor;

public interface GestorRepository extends PagingAndSortingRepository<Gestor, Long> {
	Gestor findByUsername(String username);
	List<Gestor> findByEmpresa(Empresa empresa);
}
