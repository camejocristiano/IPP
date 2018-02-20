package br.net.ipp.daos.configuracoes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.configuracoes.Agendamento;
import br.net.ipp.models.configuracoes.Usuario;

public interface AgendamentoRepository extends PagingAndSortingRepository<Agendamento, Long> {
	Agendamento findById(Long id);
	List<Agendamento> findAlByUsuarioResponsavel(Usuario usuario);
	List<Agendamento> findAlByUsuariosEnvolvidos(Usuario usuario);
}
