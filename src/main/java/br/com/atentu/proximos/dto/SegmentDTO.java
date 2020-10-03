package br.com.atentu.proximos.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import br.com.atentu.proximos.model.Segment;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties({"hibernate_lazy_initializer", "handler"})
public class SegmentDTO {
	
	private Long id;
	private String name;
	private Segment parent;
	private Set<Segment> children;
	
	public SegmentDTO() {}

	public SegmentDTO(Long id, String name, Segment parent, Set<Segment> children) {
		super();
		this.id = id;
		this.name = name;
		this.parent = parent;
		this.children = children;
	}
	
	public static SegmentDTO of(Long id, String name, Segment parent, Set<Segment> children) {
		return new SegmentDTO(id, name, parent, children);
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

	public Set<Segment> getChildren() {
		return children;
	}

	public void setChildren(Set<Segment> children) {
		this.children = children;
	}

	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	};

}
