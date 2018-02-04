package br.net.ipp.jpa.repository.configuracoes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.configuracoes.Agendamento;

public interface AgendamentoRepository extends PagingAndSortingRepository<Agendamento, Long> {
	Agendamento findById(Long id);
}
