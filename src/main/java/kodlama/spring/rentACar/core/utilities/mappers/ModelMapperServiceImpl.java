package kodlama.spring.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service //bu sayede her seferınde ModelMapper üretilmez ve bu IoC ye yerleşir. 1 ModelMapper olsun hep onu kullansın
@AllArgsConstructor
public class ModelMapperServiceImpl implements ModelMapperService{

	private ModelMapper modelMapper;
	@Override
	public ModelMapper forResponse() { //stratejinin belirlendiği kısım
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)// belirsizlik oldugunda onu ignore et hata verme demek
		.setMatchingStrategy(MatchingStrategies.LOOSE); // gevsek mappleme yapıyor. 
		return this.modelMapper;
	}

	@Override
	public ModelMapper forRequest() {
		this.modelMapper.getConfiguration()
		.setAmbiguityIgnored(true)
		.setMatchingStrategy(MatchingStrategies.STANDARD); // her şey maplensın yanı her seyın karsılıgı olsun yoksa kız
		return this.modelMapper;
	}
	
}
