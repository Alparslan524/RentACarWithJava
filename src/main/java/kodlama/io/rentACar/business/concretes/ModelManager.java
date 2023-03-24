package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetByIdModelResponse;
import kodlama.io.rentACar.core.utilities.mappers.abstracts.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService modelMapperService;

	@Override
	public List<GetAllModelsResponse> getAll() {
		List<Model> models = modelRepository.findAll();
		List<GetAllModelsResponse> response = models.stream()// foreach yapıyor gibi düşünebiliriz
				.map(model -> modelMapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public GetByIdModelResponse getById(int id) {
		Model model = modelRepository.findById(id).orElseThrow();
		GetByIdModelResponse response = modelMapperService.forResponse().map(model, GetByIdModelResponse.class);
		return response;
	}

	@Override
	public void add(CreateModelRequest createModelRequest) {
		Model model = modelMapperService.forRequest().map(createModelRequest, Model.class);
		modelRepository.save(model);
	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {
		Model model = modelMapperService.forRequest().map(updateModelRequest, Model.class);
		modelRepository.save(model);
	}

	@Override
	public void delete(int id) {
		modelRepository.deleteById(id);
	}
}