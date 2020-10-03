package br.com.atentu.proximos.controller;

import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.atentu.proximos.dto.SegmentDTO;
import br.com.atentu.proximos.model.Segment;
import br.com.atentu.proximos.repository.SegmentRepository;

@RestController
@RequestMapping(value = "segments")
public class SegmentController {

	@Autowired
	SegmentRepository segmentRepository;

	@GetMapping("/{id}")
	public ResponseEntity<SegmentDTO> getAllDetails(@PathVariable("id") Long id) {
		return segmentRepository.findById(id).map(mapToSegmentDTO).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	
	 @GetMapping("/{id}/siblings")
    public ResponseEntity<Set<SegmentDTO>> getAllSiblings(@PathVariable("id") Long id) {
        return segmentRepository.findById(id).map(findSiblings).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
	
	private Function<Segment, Set<SegmentDTO>> findSiblings = segment -> segment.getParent().getChildren().stream()
			.map(p -> SegmentDTO.builder().id(p.getId()).name(p.getName()).build()).collect(Collectors.toSet());
 
	private Function<Segment, SegmentDTO> mapToSegmentDTO = p -> 
		SegmentDTO.builder().id(p.getId()).name(p.getName())
		.parent(p.getParent()).children(p.getChildren()).build();
			

}
