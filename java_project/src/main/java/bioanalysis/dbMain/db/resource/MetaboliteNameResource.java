package bioanalysis.dbMain.db.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bioanalysis.dbMain.db.model.MetaboliteName;
import bioanalysis.dbMain.db.repository.MetaboliteNameRepository;

@RestController
@RequestMapping(value="/rest/metaboliteName")
public class MetaboliteNameResource {

	@Autowired
	MetaboliteNameRepository metaboliteNameRepository;
	
	@GetMapping(value = "/all")
	public List <MetaboliteName> getAll() {
		return metaboliteNameRepository.findAll();
	}
	
	
	@PostMapping (value ="/load")
	public List<MetaboliteName> persist(@RequestBody final MetaboliteName metaboliteName){
		metaboliteNameRepository.save(metaboliteName);
		return metaboliteNameRepository.findAll();
	}
	
	
}
