package kodlama.io.Devs.business.requests.FrameworkRequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateFrameworkRequest {
	private int languageId;
	private String name;
	
}
