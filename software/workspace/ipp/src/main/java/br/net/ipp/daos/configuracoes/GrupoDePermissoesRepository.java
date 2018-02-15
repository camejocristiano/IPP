package br.net.ipp.daos.configuracoes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.GrupoDePermissoes;
import br.net.ipp.models.configuracoes.Unidade;

public interface GrupoDePermissoesRepository extends PagingAndSortingRepository<GrupoDePermissoes, Long> {
	List<GrupoDePermissoes> findAllByUnidade(Unidade unidade);
}
