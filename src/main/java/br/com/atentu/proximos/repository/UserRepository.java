package br.com.atentu.proximos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atentu.proximos.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findById(long id);
	
}
