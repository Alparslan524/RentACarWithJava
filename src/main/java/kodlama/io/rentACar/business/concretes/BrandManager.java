package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.core.utilities.mappers.abstracts.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // Ioc'ye bu manageri ekliyor. Ve her defasında newlemek yerinde 1 tane newliyor
			// ve onu veriyor

@AllArgsConstructor
public class BrandManager implements BrandService {

//	public BrandManager(BrandRepository brandRepository) {
//	this.brandRepository = brandRepository;
//}//@AllArgsConstructor sayesinde bu satırı otomatik yaptık(Lombok ile)

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = brandRepository.findAll();
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		// brands elemanlarını stream() ile geziyor ve brand elemanına atıyor.
		// Sonra map ile brand elemanını GetAllBrandsResponseye çeviriyor
		// En sonda Collectors.toList() ile listeye çeviriyor

		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {

		// Brand brand = new Brand();
		// brand.setName(createBrandRequest.getName());
		// ......
		// ......
		// ......
		// Mapping ile bu spagetti koddan kurtulduk

		Brand brand = modelMapperService.forRequest().map(createBrandRequest, Brand.class);

		brandRepository.save(brand);
	}
}
