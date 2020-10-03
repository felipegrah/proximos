package br.com.atentu.proximos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

import br.com.atentu.proximos.model.Segment;
import br.com.atentu.proximos.model.SetSegment;
import br.com.atentu.proximos.model.User;
import br.com.atentu.proximos.repository.SegmentRepository;
import br.com.atentu.proximos.repository.UserRepository;
import br.com.atentu.proximos.service.SetSegmentService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ProximosApplication {
	
	
	private static final Logger log = LoggerFactory.getLogger(ProximosApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ProximosApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(UserRepository userRepository, SetSegmentService segmentService, SegmentRepository segmentRepository) {
		return (args) -> {
			//save user 
			userRepository.save(new User("Felipe", "Silva", "123"));
			userRepository.save(new User("Amanda", "Grah", "123"));
			
			
			log.info("Find all");
			log.info("-----------");
			for(User user : userRepository.findAll()) {
				log.info(user.toString());
			}
			log.info("");
			
			segmentService.save(new SetSegment("F5 Condominio", "/f5-condominio", "48991655949"));
			segmentService.save(new SetSegment("SC SEG", "/scseg", "48991655949"));
			
			
			Segment parent = new Segment("Condominio A1");
			
			segmentRepository.save(parent);
			segmentRepository.save(new Segment("Hall", parent));
			
			Segment parent2 = new Segment("Condominio A2");
			
			segmentRepository.save(parent2);
			Segment portaria = new Segment("Portaria", parent2);
			segmentRepository.save(portaria);
			segmentRepository.save(new Segment("Hall", parent2));
			
			segmentRepository.save(new Segment("Entrada 1", portaria));
			segmentRepository.save(new Segment("Entrada 2", portaria));
			
			log.info("OK");
			
			
		};
	}

}
