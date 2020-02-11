package bioanalysis.dbMain.db.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bioanalysis.dbMain.db.model.ExternalSourceId;
import bioanalysis.dbMain.db.repository.ExternalSourceIdRepository;


@RestController
@RequestMapping(value="/rest/externalSourcesIds")
public class ExternalSourceIdResource {
	
	@Autowired
	ExternalSourceIdRepository externalSourceIdRepository;
	
	@GetMapping(value = "/all")
	public List <ExternalSourceId> getAll() {
		return externalSourceIdRepository.findAll();
	}
	
	
	@PostMapping (value ="/load")
	public List<ExternalSourceId> persist(@RequestBody final ExternalSourceId externalSourceId){
		externalSourceIdRepository.save(externalSourceId);
		return externalSourceIdRepository.findAll();
	}

}
