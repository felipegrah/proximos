package br.com.atentu.proximos.controller;

import java.util.Set;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.atentu.proximos.dto.SegmentDTO;
import br.com.atentu.proximos.model.Segment;
import br.com.atentu.proximos.repository.SegmentRepository;

public class SegmentController {

	@Autowired
	SegmentRepository segmentRepository;

	@GetMapping("/{id}")
	public ResponseEntity<SegmentDTO> getAllDetails(@PathVariable("id") Long id) {
		return segmentRepository.findById(id).map(mapToSegmentDTO).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	private Function<Segment, SegmentDTO> mapToSegmentDTO = p -> 
	SegmentDTO.of(p.getId(), p.getName(), p.getParent(), p.getChildren());

}
