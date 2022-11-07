package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.PLanguageService;
import kodlama.io.Devs.business.constants.Messages;
import kodlama.io.Devs.business.requests.PLanguageRequest.CreatePLangugeRequest;
import kodlama.io.Devs.business.responses.FrameworkResponse.GetAllFrameworkResponse;
import kodlama.io.Devs.business.responses.PLanguageResponse.GetAllPLanguageResponse;
import kodlama.io.Devs.business.responses.PLanguageResponse.GetByIdPLanguageResponse;
import kodlama.io.Devs.dataAccess.abstracts.FrameworkRepository;
import kodlama.io.Devs.dataAccess.abstracts.PLanguageRepository;
import kodlama.io.Devs.entites.concretes.Framework;
import kodlama.io.Devs.entites.concretes.PLanguage;

@Service
public class PLanguageManager implements PLanguageService {

	private PLanguageRepository _languageRepository;
	private FrameworkRepository _frameworkRepository;

	@Autowired
	public PLanguageManager(PLanguageRepository languageRepository, FrameworkRepository frameworkRepository) {
		this._languageRepository = languageRepository;
		this._frameworkRepository = frameworkRepository;

	}

	// Anlamakta Zorlandığım nokta bu algoritmayla çözdüm çok zorlandım
	@Override
	public List<GetAllPLanguageResponse> getAll() {
		// Dil ve Framework listelerini aldım
		List<PLanguage> language = _languageRepository.findAll();
		List<Framework> framework = _frameworkRepository.findAll();
		// Boş Liste Oluşturdum
		List<GetAllPLanguageResponse> pLanguageResponse = new ArrayList<GetAllPLanguageResponse>();
		// önce gelen dil listesini döndüm
		for (PLanguage languages : language) {
			// boş framework listesi oluşturdum
			List<GetAllFrameworkResponse> frameworkResponses = new ArrayList<GetAllFrameworkResponse>();
			// framework listesini döndüm
			for (Framework frame : framework) {
				// frameworkün dil id si dil id sine eşit olanı respons nesnesine ekle
				if (frame.getLanguage().getId() == languages.getId()) {
					frameworkResponses.add(
							new GetAllFrameworkResponse(frame.getId(), frame.getName(), frame.getLanguage().getId()));

				}
			}
			// respons nesnelerini birleştir
			pLanguageResponse
					.add(new GetAllPLanguageResponse(languages.getId(), languages.getName(), frameworkResponses));

		}
		// responsu döndür
		return pLanguageResponse;
	}

	@Override
	public List<GetByIdPLanguageResponse> getById(int id) {

		List<GetByIdPLanguageResponse> pLanguageResponse = new ArrayList<GetByIdPLanguageResponse>();
		PLanguage languages = _languageRepository.findById(id).get();
		List<Framework> frameworks = _frameworkRepository.findAll();
		List<GetAllFrameworkResponse> frameworkResponse = new ArrayList<GetAllFrameworkResponse>();
		for (Framework framework : frameworks) {

			if (framework.getLanguage().getId() == languages.getId()) {

				frameworkResponse.add(new GetAllFrameworkResponse(framework.getId(), framework.getName(),
						framework.getLanguage().getId()));
			}

		}
		pLanguageResponse.add(new GetByIdPLanguageResponse(languages.getId(), languages.getName(), frameworkResponse));

		return pLanguageResponse;

	}

	@Override
	public void add(CreatePLangugeRequest request) throws Exception {
		isNameEmpty(request.getName());
		isNameExist(request.getName());
		PLanguage language = new PLanguage();
		language.setName(request.getName());
		_languageRepository.save(language);
	}

	@Override
	public void update(int id, CreatePLangugeRequest request) throws Exception {
		isNameEmpty(request.getName());
		isNameExist(request.getName());
		var result = _languageRepository.findAll();

		for (PLanguage languages : result) {

			if (languages.getId() == id) {

				languages.setName(request.getName());
			}
			_languageRepository.save(languages);
		}
	}

	@Override
	public void delete(int id) {

		_languageRepository.deleteById(id);
	}

	// Managere Özel Kurallar
	private void isNameEmpty(String name) throws Exception {
		if(name.isEmpty() || name.isBlank()) {
			throw new Exception(Messages.nameEmpty);
		}
	}

	private void isNameExist(String name) throws Exception {

		var languageList = _languageRepository.findAll();
		for (PLanguage language : languageList) {
			if (language.getName().toLowerCase().equals(name.toLowerCase())) {
				throw new Exception(Messages.nameExist);
			}
		}
	}
}
