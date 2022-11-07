package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.PLanguageService;
import kodlama.io.Devs.business.requests.PLanguageRequest.CreatePLangugeRequest;
import kodlama.io.Devs.business.responses.PLanguageResponse.GetAllPLanguageResponse;
import kodlama.io.Devs.business.responses.PLanguageResponse.GetByIdPLanguageResponse;

@RestController
@RequestMapping("/api/PLanguage")
public class PLanguageControllers {

	private PLanguageService _languageService;

	@Autowired
	public PLanguageControllers(PLanguageService languageService) {
		this._languageService = languageService;
	}

	@GetMapping("getall")
	List<GetAllPLanguageResponse> getAll() {

		return _languageService.getAll();
	}

	@PostMapping("add")
	void add(CreatePLangugeRequest request) throws Exception {

		_languageService.add(request);
	}

	@GetMapping("getbyıd")
	List<GetByIdPLanguageResponse> getById(int id) {

		return _languageService.getById(id);
	}

	@DeleteMapping("delete")
	void Delete(int id) {

		_languageService.delete(id);
	}

	@PutMapping("uptade")
	void update(int id, CreatePLangugeRequest request) throws Exception {
		_languageService.update(id, request);
	}

}
