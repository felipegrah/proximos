package br.com.atentu.proximos.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atentu.proximos.model.User;
import br.com.atentu.proximos.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public List<User> listAllUser() {
		return userRepository.findAll();
	}

	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}

	public User replaceUser(User newUser, Long id) {
		return userRepository.findById(id).map(user -> {
			user.setName(newUser.getName());
			user.setLastName(newUser.getLastName());
			user.setPassword(newUser.getPassword());
			return userRepository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return userRepository.save(newUser);
		});

	}
	
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
