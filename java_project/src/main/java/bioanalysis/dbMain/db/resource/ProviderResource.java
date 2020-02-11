package bioanalysis.dbMain.db.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bioanalysis.dbMain.db.model.Provider;
import bioanalysis.dbMain.db.repository.ProviderRepository;


@RestController
@RequestMapping(value="/rest/provider")
public class ProviderResource {
	
	@Autowired
	ProviderRepository providerRepository;
	
	@GetMapping(value = "/all")
	public List <Provider> getAll() {
		return providerRepository.findAll();
	}
	
	
	@PostMapping (value ="/load")
	public List<Provider> persist(@RequestBody final Provider provider){
		providerRepository.save(provider);
		return providerRepository.findAll();
	}

}
