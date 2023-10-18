package kodlama.spring.rentACar.business.abstracts;

import java.util.List;

import kodlama.spring.rentACar.business.requests.CreateBrandRequest;
import kodlama.spring.rentACar.business.requests.UpdateBrandRequest;
import kodlama.spring.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.spring.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService { //iş kurallarını yazacagımız yapıyı tasarlıyoruz
	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	void update(UpdateBrandRequest updateBrandRequest);
	void delete(int id);
	GetByIdBrandResponse getById(int id);
	
}
