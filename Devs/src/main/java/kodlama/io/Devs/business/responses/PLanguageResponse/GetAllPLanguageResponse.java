package kodlama.io.Devs.business.responses.PLanguageResponse;

import java.util.List;

import kodlama.io.Devs.business.responses.FrameworkResponse.GetAllFrameworkResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllPLanguageResponse {
	private int id;
	private String name;
	private List<GetAllFrameworkResponse> framework;


}
