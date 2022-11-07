package kodlama.io.Devs.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.Devs.business.abstracts.FrameworkService;
import kodlama.io.Devs.business.constants.Messages;
import kodlama.io.Devs.business.requests.FrameworkRequest.CreateFrameworkRequest;
import kodlama.io.Devs.business.requests.FrameworkRequest.CreateUpdateFrameworkRequest;
import kodlama.io.Devs.business.responses.FrameworkResponse.GetAllFrameworkResponse;
import kodlama.io.Devs.dataAccess.abstracts.FrameworkRepository;
import kodlama.io.Devs.dataAccess.abstracts.PLanguageRepository;
import kodlama.io.Devs.entites.concretes.Framework;
import kodlama.io.Devs.entites.concretes.PLanguage;

@Service
public class FrameworkManager implements FrameworkService {

	private FrameworkRepository _frameworkRepository;
	private PLanguageRepository _languageRepository;

	@Autowired
	public FrameworkManager(FrameworkRepository frameworkRepository, PLanguageRepository languageRepository) {
		this._frameworkRepository = frameworkRepository;
		this._languageRepository = languageRepository;
	}

	@Override
	public List<GetAllFrameworkResponse> getAll() {

		List<Framework> framework = _frameworkRepository.findAll();
		List<GetAllFrameworkResponse> frameworksResponse = new ArrayList<GetAllFrameworkResponse>();

		for (Framework frameworks : framework) {
			GetAllFrameworkResponse responseItem = new GetAllFrameworkResponse();

			responseItem.setId(frameworks.getId());
			responseItem.setName(frameworks.getName());
			responseItem.setLanguageId(frameworks.getLanguage().getId());
			frameworksResponse.add(responseItem);
		}

		return frameworksResponse;
	}

	@Override
	public void add(CreateFrameworkRequest request) throws Exception {
		isNameEmpty(request.getName());
		IsnameExist(request.getName());
		Framework framework = new Framework();
		PLanguage language = _languageRepository.findById(request.getLanguageId()).get();

		framework.setName(request.getName());
		framework.setLanguage(language);

		_frameworkRepository.save(framework);

	}

	@Override
	public void delete(int id) {
		_frameworkRepository.deleteById(id);

	}

	@Override
	public void update(int id, CreateUpdateFrameworkRequest request) throws Exception {
		isNameEmpty(request.getName());
		IsnameExist(request.getName());

		PLanguage language = _languageRepository.findById(request.getLanguageId()).get();
		Framework framework = _frameworkRepository.findById(id).get();

		framework.setName(request.getName());
		framework.setLanguage(language);

		_frameworkRepository.save(framework);

	}

	private void isNameEmpty(String name) throws Exception {
		if(name.isEmpty() || name.isBlank()) {
		
			 throw new Exception(Messages.nameEmpty); 
		}
		
	}

	private void IsnameExist(String name) throws Exception {

		var frameworkList = _frameworkRepository.findAll();
		for (Framework language : frameworkList) {
			if (language.getName().toLowerCase().equals(name.toLowerCase())) {
				throw new Exception(Messages.nameExist);
			}
		}

	
	}
}
