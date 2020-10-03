package br.com.atentu.proximos.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Segment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Segment parent;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parent")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private  Set<Segment> children;
	
	public Segment() {}

	public Segment(String name, Segment parent, Set<Segment> children) {
		this.name = name;
		this.parent = parent;
		this.children = children;
	}
	
	public Segment(Long id, String name, Segment parent, Set<Segment> children) {
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.children = children;
	}

	public Segment(String name) {
		this.name = name;
	}
	
	public Segment(String name, Segment parent) {
		this.name = name;
		this.parent = parent;
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

	public Segment getParent() {
		return parent;
	}

	public void setParent(Segment parent) {
		this.parent = parent;
	}
	
	@JsonIgnore
	public Set<Segment> getChildren() {
		return children;
	}

	public void setChildren(Set<Segment> children) {
		this.children = children;
	};
	

}
