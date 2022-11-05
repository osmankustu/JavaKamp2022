package kodlama.io.Devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.Devs.dataAccess.abstracts.ProgrammingLanguageDto;
import kodlama.io.Devs.entites.PLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageDto {

	public List<PLanguage> pLanguage;

	public InMemoryProgrammingLanguageRepository() {
		pLanguage = new ArrayList<>();
	}

	@Override
	public List<PLanguage> getAll() {
		return pLanguage;
	}

	@Override
	public PLanguage getById(int id) {
		return pLanguage.get(id);
	}

	@Override
	public void add(PLanguage PLanguage) {
		pLanguage.add(PLanguage);
	}

	@Override
	public void update(int id, PLanguage language) {
		pLanguage.set(id, language);
	}

	@Override
	public void delete(int id) {
		pLanguage.remove(id);
	}

}
