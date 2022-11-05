package kodlama.io.Devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.PLanguageService;
import kodlama.io.Devs.dataAccess.concretes.InMemoryProgrammingLanguageRepository;
import kodlama.io.Devs.entites.PLanguage;
@Service
public class PLanguageManager implements PLanguageService {

	private InMemoryProgrammingLanguageRepository _inMemoryProgrammingLanguageRepository;

	@Autowired
	public PLanguageManager(InMemoryProgrammingLanguageRepository inMemoryProgrammingLanguageRepository) {
		this._inMemoryProgrammingLanguageRepository = inMemoryProgrammingLanguageRepository;
	}

	@Override
	public List<PLanguage> getAll() {
		return _inMemoryProgrammingLanguageRepository.getAll();
	}

	@Override
	public PLanguage getById(int id) {
		return _inMemoryProgrammingLanguageRepository.getById(id);
	}

	@Override
	public void add(PLanguage language) throws Exception {
		isNameEmpty(language);
		isNameExist(language);
		
				
		_inMemoryProgrammingLanguageRepository.add(language);
	}

	@Override
	public void update(int id,PLanguage language) throws Exception {
		isNameEmpty(language);
		isNameExist(language);
		_inMemoryProgrammingLanguageRepository.update(id,language);

	}

	@Override
	public void delete(int id) {
		_inMemoryProgrammingLanguageRepository.delete(id);

	}
	
	//Managere Özel Kurallar
	private void isNameExist(PLanguage language) throws Exception {
		for (PLanguage pLanguage2 : _inMemoryProgrammingLanguageRepository.getAll()) {
			if(pLanguage2.getName().equals(language.getName())) {
				throw new Exception("Girilen Programlama dilinden zaten mevcut");
			}
		}	
	}
	
	private void isNameEmpty(PLanguage language) throws Exception {
		if(language.getName().equals("")) {
			throw new Exception("Programlama dili boş olamaz");
		}
	}

}
