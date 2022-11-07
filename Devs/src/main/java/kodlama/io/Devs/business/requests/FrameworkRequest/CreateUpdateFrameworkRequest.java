package kodlama.io.Devs.business.requests.FrameworkRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUpdateFrameworkRequest {
	
	private String name;
	private int languageId;
	
}
