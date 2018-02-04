package br.net.ipp.daos.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Agendamento;

public interface AgendamentoRepository extends PagingAndSortingRepository<Agendamento, Long> {
	Agendamento findById(Long id);
}
