package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entites.concretes.Framework;

public interface FrameworkRepository extends JpaRepository<Framework,Integer>{
	
	
	
}
