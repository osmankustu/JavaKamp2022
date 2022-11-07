package kodlama.io.Devs.webApi.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.Devs.business.abstracts.FrameworkService;
import kodlama.io.Devs.business.requests.FrameworkRequest.CreateFrameworkRequest;
import kodlama.io.Devs.business.requests.FrameworkRequest.CreateUpdateFrameworkRequest;
import kodlama.io.Devs.business.responses.FrameworkResponse.GetAllFrameworkResponse;


@RestController
@RequestMapping("/api/framework")
public class FrameworkControllers {

	private FrameworkService _frameworkService;
	
	public FrameworkControllers(FrameworkService frameworkService) {
		this._frameworkService = frameworkService;
	}
	
	@GetMapping("getall")
	public List<GetAllFrameworkResponse> getAll(){
		return _frameworkService.getAll();
	}
	
	@PostMapping("add")
	public void add( CreateFrameworkRequest request) throws Exception {
		
		 _frameworkService.add(request);
	}
	
	@DeleteMapping("delete")
	public void delete(int id) {
		_frameworkService.delete(id);
	}
	
	@PutMapping("update")
	public void update(int id , CreateUpdateFrameworkRequest request) throws Exception {
		_frameworkService.update(id,request);
	}
}
