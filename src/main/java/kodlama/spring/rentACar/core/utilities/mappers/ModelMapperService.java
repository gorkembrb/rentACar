package kodlama.spring.rentACar.core.utilities.mappers;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
	ModelMapper forResponse(); //Response ve Request için bana mapper veren metodlar
	ModelMapper forRequest();
}
