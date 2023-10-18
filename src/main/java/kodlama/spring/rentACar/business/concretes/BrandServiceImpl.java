package kodlama.spring.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.spring.rentACar.business.abstracts.BrandService;
import kodlama.spring.rentACar.business.requests.CreateBrandRequest;
import kodlama.spring.rentACar.business.requests.UpdateBrandRequest;
import kodlama.spring.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.spring.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.spring.rentACar.business.rules.BrandBusinessRules;
import kodlama.spring.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.spring.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.spring.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service // benım ıcın otomatık olarak onu bır servis katmanı olarak newle demek -- Bu sınıf bır busıness nesnesıdır
@AllArgsConstructor
public class BrandServiceImpl implements BrandService {

	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	@Override
	public List<GetAllBrandsResponse> getAll() {
		// iş kuralları

		List<Brand> brands = brandRepository.findAll();

		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());

		return brandsResponse;
	}

	@Override
	public void add(CreateBrandRequest createBrandRequest) {

		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());//kuralları buraya alt alta yazabilirsin
		
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		// forRequest bizim yerimize arka planda Brand new yapıyor
		// sonra creteBrandRequest(source) içerisindeki alanlara bakıp Brand ile aynı
		// olanları newledigi Brand içerisine aktarıyor.

		this.brandRepository.save(brand); //id yoksa save insert yapar

	}

	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		this.brandRepository.save(brand); //id oldugu için save update yapar
	}

	@Override
	public void delete(int id) {
		this.brandRepository.deleteById(id);
		
	}

	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response = this.modelMapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		
		return response;
	}

}
