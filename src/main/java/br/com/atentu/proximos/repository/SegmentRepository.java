package br.com.atentu.proximos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.atentu.proximos.model.Segment;

public interface SegmentRepository extends JpaRepository<Segment, Long>{
	
}
