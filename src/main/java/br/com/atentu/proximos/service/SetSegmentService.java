package br.com.atentu.proximos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.atentu.proximos.model.SetSegment;
import br.com.atentu.proximos.repository.SetSegmentRepository;

@Service
public class SetSegmentService {
	
	@Autowired
	SetSegmentRepository segmentRepository;
	
	public List<SetSegment> listAll() {
		return segmentRepository.findAll();
	}
	
	public SetSegment save(SetSegment newSegment) {
		return segmentRepository.save(newSegment);
	}

	public SetSegment findById(Long id) {
		return segmentRepository.findById(id).get();
	}

	public SetSegment saveSegment(SetSegment segment) {
		return segmentRepository.save(segment);		
	}

	public SetSegment replaceSegment(SetSegment newSegment, Long id) {
		return segmentRepository.findById(id).map(segment -> {
			segment.setName(newSegment.getName());
			segment.setPhone(newSegment.getPhone());
			segment.setSlug(newSegment.getSlug());
			return segmentRepository.save(segment);
		}).orElseGet(() -> {
			newSegment.setId(id);
			return segmentRepository.save(newSegment);
		});
	}

	public void deleteSegment(Long id) {
		segmentRepository.deleteById(id);
	}
	

}
