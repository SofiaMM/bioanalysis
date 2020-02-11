package bioanalysis.dbMain.db.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bioanalysis.dbMain.db.model.BioanalysisMetabolite;
import bioanalysis.dbMain.db.repository.BioanalysisMetaboliteRepository;

@RestController
@RequestMapping(value="/rest/bioanalysisMetabolite")
public class BioanalysisMetaboliteResource {

	@Autowired
	BioanalysisMetaboliteRepository bioanalysisMetaboliteRepository;
	
	@GetMapping(value = "/all")
	public List <BioanalysisMetabolite> getAll() {
		return bioanalysisMetaboliteRepository.findAll();
	}
	
	@PostMapping (value ="/load")
	public List<BioanalysisMetabolite> persist(@RequestBody final BioanalysisMetabolite bioeconomicsMetabolite){
		bioanalysisMetaboliteRepository.save(bioeconomicsMetabolite);
		return bioanalysisMetaboliteRepository.findAll();
	}
}
