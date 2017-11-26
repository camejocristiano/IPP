package br.net.ipp.jpa.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.jpa.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>  {

	User findByUsername(String username);
	
}
