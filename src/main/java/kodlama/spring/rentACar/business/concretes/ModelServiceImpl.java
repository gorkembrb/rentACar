package kodlama.spring.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.spring.rentACar.business.abstracts.ModelService;
import kodlama.spring.rentACar.business.requests.CreateModelRequest;
import kodlama.spring.rentACar.business.responses.GetAllModelsResponse;
import kodlama.spring.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.spring.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.spring.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelServiceImpl implements ModelService{
	
	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;
	
	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		
		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.modelMapperService.forResponse()
						.map(model,GetAllModelsResponse.class)).collect(Collectors.toList());
		return modelsResponse;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = this.modelMapperService.forRequest().map(createModelRequest, Model.class); //elimdeki createModelRequest nesnesini Model nesnesıne çevir

		this.modelRepository.save(model);
		
	}
	
}
