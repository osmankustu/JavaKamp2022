package kodlama.io.Devs.business.abstracts;

import java.util.List;

import kodlama.io.Devs.business.requests.PLanguageRequest.CreatePLangugeRequest;
import kodlama.io.Devs.business.responses.PLanguageResponse.GetAllPLanguageResponse;
import kodlama.io.Devs.business.responses.PLanguageResponse.GetByIdPLanguageResponse;

public interface PLanguageService {
	List<GetAllPLanguageResponse> getAll();
	List<GetByIdPLanguageResponse> getById(int id);
	void add(CreatePLangugeRequest request) throws Exception;
	void update(int id,CreatePLangugeRequest request) throws Exception;
	void delete(int id);
}
