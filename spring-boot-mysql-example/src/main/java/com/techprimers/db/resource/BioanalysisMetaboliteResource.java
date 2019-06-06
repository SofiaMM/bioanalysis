package com.techprimers.db.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.db.model.BioanalysisMetabolite;
import com.techprimers.db.repository.BioanalysisMetaboliteRepository;

@RestController
@RequestMapping(value="/rest/bioeconomicsMetabolite")
public class BioanalysisMetaboliteResource {

	@Autowired
	BioanalysisMetaboliteRepository bioeconomicsMetaboliteRepository;
	
	@GetMapping(value = "/all")
	public List <BioanalysisMetabolite> getAll() {
		return bioeconomicsMetaboliteRepository.findAll();
	}
	
	@PostMapping (value ="/load")
	public List<BioanalysisMetabolite> persist(@RequestBody final BioanalysisMetabolite bioeconomicsMetabolite){
		bioeconomicsMetaboliteRepository.save(bioeconomicsMetabolite);
		return bioeconomicsMetaboliteRepository.findAll();
	}
}
