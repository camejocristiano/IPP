package br.net.ipp.api.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.net.ipp.api.model.User;

public interface UserRepository extends PagingAndSortingRepository<User, Long>  {

	User findByUsername(String username);
	
}
