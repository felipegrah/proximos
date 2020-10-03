package br.com.atentu.proximos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SetSegment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name; 
	private String slug;
	private String phone;
	
	
	public SetSegment() {};
	
	public SetSegment(Long id, String name, String slug, String phone) {
		this.id = id;
		this.name = name;
		this.slug = slug;
		this.phone = phone;
	}
	
	public SetSegment(String name, String slug, String phone) {
		this.name = name;
		this.slug = slug;
		this.phone = phone;
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

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
