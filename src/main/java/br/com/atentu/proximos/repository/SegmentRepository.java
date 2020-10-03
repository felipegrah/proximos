package br.com.atentu.proximos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.atentu.proximos.model.Segment;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Long>{
	
}
