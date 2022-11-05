package kodlama.io.Devs.dataAccess.abstracts;

import java.util.List;

import kodlama.io.Devs.entites.PLanguage;



public interface ProgrammingLanguageDto {
	List<PLanguage> getAll();
	
	PLanguage getById(int id);
	
	void add(PLanguage programmingLanguage);
	
	void update(int id,PLanguage language);
	
	void delete(int id);
	
}
