package br.net.ipp.daos.aprendizes;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.aprendizes.Ocorrencia;

public interface OcorrenciaRepository extends PagingAndSortingRepository<Ocorrencia, Long> {

}
