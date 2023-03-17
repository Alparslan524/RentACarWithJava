package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	// Spring özelliği ile JpaRepository extends edince bu interfacenin concretes
	// sınıfnı kurmamıza gerek kalmadı
}
