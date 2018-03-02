package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.AvaliacaoPAPEmpresa;
import br.net.ipp.models.aprendizes.Historico;

public interface AvaliacaoPAPEmpresaRepository extends PagingAndSortingRepository<AvaliacaoPAPEmpresa, Long> {
	List<AvaliacaoPAPEmpresa> findAllByHistorico(Historico historico);
	AvaliacaoPAPEmpresa findByHistorico(Historico historico);
}
