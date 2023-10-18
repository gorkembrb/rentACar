package kodlama.spring.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlama.spring.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.spring.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service //ben bunu enjekte ederek kullanıcam newleme yapmayacagım, IoC ye yerleştir demek
public class BrandBusinessRules {
	
	private BrandRepository brandRepository;
	
	public void checkIfBrandNameExists(String name) {
		if(this.brandRepository.existsByName(name)) {
			throw new BusinessException("Brand name already exists");
		}
	}
	
}
