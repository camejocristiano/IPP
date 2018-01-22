package br.net.ipp.daos.frequencias;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.cursos.Matricula;
import br.net.ipp.models.frequencias.PITEPIP;

public interface PITEPIPRepository extends PagingAndSortingRepository<PITEPIP, Long> {
	List<PITEPIP> findAllByMatricula(Matricula matricula);
	void save(List<PITEPIP> pitsepips);
}
