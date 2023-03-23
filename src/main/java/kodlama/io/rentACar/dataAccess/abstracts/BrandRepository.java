package kodlama.io.rentACar.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.rentACar.entities.concretes.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
	// Spring özelliği ile JpaRepository extends edince bu interfacenin concretes
	// sınıfnı kurmamıza gerek kalmadı

	// Spring JPA da bu metod olmadığı için kendimiz yazdık
	// Burada exists keywordunu kullandık. JPA kendisi otoamtik veritabanına gidecek
	// ve kontrol edecek
	boolean existsByName(String name);

}