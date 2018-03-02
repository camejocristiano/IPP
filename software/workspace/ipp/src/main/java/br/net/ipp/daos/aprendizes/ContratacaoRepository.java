package br.net.ipp.daos.aprendizes;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Contratacao;
import br.net.ipp.models.aprendizes.FichaProfissional;

public interface ContratacaoRepository extends PagingAndSortingRepository<Contratacao, Long> {
	List<Contratacao> findAllByFichaProfissional(FichaProfissional fichaProfissional);
	Contratacao findByFichaProfissional(FichaProfissional fichaProfissional);
}
