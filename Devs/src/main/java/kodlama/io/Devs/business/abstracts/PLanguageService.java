package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.entites.PLanguage;

public interface PLanguageService {
	List<PLanguage> getAll();
	PLanguage getById(int id);
	void add(PLanguage language) throws Exception;
	void update(int id,PLanguage language) throws Exception;
	void delete(int id);
}
