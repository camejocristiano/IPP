package br.net.ipp.daos.financeiros;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.models.financeiros.VR;

public interface VRRepository extends PagingAndSortingRepository<VR, Long> {

}
