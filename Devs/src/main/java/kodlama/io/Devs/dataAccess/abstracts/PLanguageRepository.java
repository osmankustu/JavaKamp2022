package kodlama.io.Devs.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.Devs.entites.concretes.PLanguage;



public interface PLanguageRepository extends JpaRepository<PLanguage,Integer> {
	
	
}
