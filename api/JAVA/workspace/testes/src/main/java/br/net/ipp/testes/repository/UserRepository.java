package br.net.ipp.testes.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.testes.model.User;


public interface UserRepository extends PagingAndSortingRepository<User, Long>  {
	
	User findByUsername(String username);
	
}
