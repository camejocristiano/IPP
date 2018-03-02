package br.net.ipp.daos.empresas;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Unidade;
import br.net.ipp.models.empresas.Empresa;

public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Long> {
	List<Empresa> findAllByUnidade(Unidade unidade);
}
