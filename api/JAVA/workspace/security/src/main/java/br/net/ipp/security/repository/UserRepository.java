package br.net.ipp.security.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.security.model.User;


public interface UserRepository extends PagingAndSortingRepository<User, Long>  {
	
	User findByUsername(String username);
	
}
