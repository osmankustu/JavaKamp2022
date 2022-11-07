package kodlama.io.Devs.business.responses.FrameworkResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdFrameworkResponse {

	private int id;
	private String name;
	private int languageId;
}
