package kodlama.io.rentACar.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBrandRequest {
	private String name;
	// Yaratmak-Marka-İstek
	//Marka yaratmak için arayüzden gelen istek
}
