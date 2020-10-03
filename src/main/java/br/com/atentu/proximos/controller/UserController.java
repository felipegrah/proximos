package br.com.atentu.proximos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atentu.proximos.dto.UserDTO;
import br.com.atentu.proximos.dto.UserResponseDTO;
import br.com.atentu.proximos.model.User;
import br.com.atentu.proximos.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> users() {
		List<User> list = userService.listAllUser();
		return ResponseEntity.ok().body(list);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<User> user(@PathVariable Long id) {
		User obj = userService.findById(id).get();
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<UserResponseDTO> saveUser(@RequestBody UserDTO newUser) {
		User user = newUser.toUser();

		userService.saveUser(user);

		return ResponseEntity.ok().body(user.toUserResponseDTO());
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<User> editUser(@PathVariable Long id, @RequestBody User newUser) {
		userService.replaceUser(newUser, id);
		return ResponseEntity.ok().body(newUser);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.ok().body("Usuário deletado " + id);
		
	}

}
