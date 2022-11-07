package kodlama.io.Devs.business.abstracts;

import java.util.List;


import kodlama.io.Devs.business.requests.FrameworkRequest.CreateFrameworkRequest;
import kodlama.io.Devs.business.requests.FrameworkRequest.CreateUpdateFrameworkRequest;
import kodlama.io.Devs.business.responses.FrameworkResponse.GetAllFrameworkResponse;


public interface FrameworkService {
	
	List<GetAllFrameworkResponse> getAll();
	void add(CreateFrameworkRequest request) throws Exception;
	
	void delete(int id);
	
	void update(int id, CreateUpdateFrameworkRequest request) throws Exception;
}
