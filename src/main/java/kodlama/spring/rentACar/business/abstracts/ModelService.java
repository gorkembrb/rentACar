package kodlama.spring.rentACar.business.abstracts;

import java.util.List;

import kodlama.spring.rentACar.business.requests.CreateModelRequest;
import kodlama.spring.rentACar.business.responses.GetAllModelsResponse;

public interface ModelService {
	List<GetAllModelsResponse> getAll();
	void add(CreateModelRequest createModelRequest);
}
