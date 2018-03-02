package br.net.ipp.daos.empresas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.empresas.Contato;
import br.net.ipp.models.empresas.Empresa;

public interface ContatoRepository extends PagingAndSortingRepository<Contato, Long> {
	Contato findByUsername(String username);
	List<Contato> findByEmpresa(Empresa empresa);
}
