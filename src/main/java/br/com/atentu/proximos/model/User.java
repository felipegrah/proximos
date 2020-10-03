package br.com.atentu.proximos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.atentu.proximos.dto.UserResponseDTO;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private String name;
	private String lastName;
	private String password;
	
	public User() {}

	public User(String name, String lastName, String password) {
		this.name = name;
		this.lastName = lastName;
		this.password = password;
	}
	
	@Override
	public String toString() {
		return String.format("User[id=%s, name=%s, lastName=%s, password=%s]",
				id, name, lastName, password);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserResponseDTO toUserResponseDTO () {
		return new UserResponseDTO(this.name, this.lastName);
	}
	
}
