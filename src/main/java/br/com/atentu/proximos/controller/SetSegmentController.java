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
import br.com.atentu.proximos.model.SetSegment;
import br.com.atentu.proximos.model.User;
import br.com.atentu.proximos.service.SetSegmentService;

@RestController
@RequestMapping(value = "set-segments")
public class SetSegmentController {
	
	@Autowired
	SetSegmentService setSegmentService;
	
	@GetMapping
	public ResponseEntity<List<SetSegment>> listAll() {
		List<SetSegment> list = setSegmentService.listAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SetSegment> user(@PathVariable Long id) {
		SetSegment obj = setSegmentService.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	
	@PostMapping
	public ResponseEntity<SetSegment> saveSegment(@RequestBody SetSegment newSegment) {
		return ResponseEntity.ok().body(setSegmentService.saveSegment(newSegment));
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<SetSegment> editSetSegment(@PathVariable Long id, @RequestBody SetSegment newSegment) {
		setSegmentService.replaceSegment(newSegment, id);
		return ResponseEntity.ok().body(newSegment);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> deleteSegment(@PathVariable Long id){
		setSegmentService.deleteSegment(id);
		return ResponseEntity.ok().body("Segmento deletado " + id);
		
	}

}
