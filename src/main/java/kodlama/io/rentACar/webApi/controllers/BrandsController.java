package kodlama.io.rentACar.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController // annotation. C# da [] ile yapıyorduk. Javada @ ile yapıyoruz
@RequestMapping("/api/brands")
@AllArgsConstructor
public class BrandsController {
	private BrandService brandService;

	@GetMapping()
	List<GetAllBrandsResponse> getAll() {
		return brandService.getAll();
	}

	@GetMapping("/{id}")
	public GetByIdBrandResponse getById(@PathVariable int id) {
		return brandService.getById(id);
	}// Url'e girilen sayıya sahip brandi getirir. PathVariable bu işe yarar

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}

	@PutMapping
	public void update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {
		brandService.update(updateBrandRequest);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		brandService.delete(id);
	}

}