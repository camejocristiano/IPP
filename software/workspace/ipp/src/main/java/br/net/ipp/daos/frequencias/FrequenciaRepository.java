package br.net.ipp.daos.frequencias;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.frequencias.Frequencia;

public interface FrequenciaRepository extends PagingAndSortingRepository<Frequencia, Long> {
	List<Frequencia> findAllByMatricula(Matricula matricula);
	List<Frequencia> findByMes(Integer mes);
	List<Frequencia> findByMatricula(Matricula matricula);
	List<Frequencia> findByMatriculaAndDia(Matricula matricula, Integer dia);
	List<Frequencia> findByMatriculaAndMes(Matricula matricula, Integer mes);
	List<Frequencia> findByMatriculaAndAno(Matricula matricula, Integer ano);
	void save(List<Frequencia> frequencias);
	List<Frequencia> findDistinctFrequenciaByMatriculaAndMes(Matricula matricula, Integer id);
}
