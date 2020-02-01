package com.techprimers.db.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.db.model.BioanalysisMetabolitePrice;
import com.techprimers.db.repository.BioanalysisMetabolitePriceRepository;

@RestController
@RequestMapping(value="/rest/bioanalysisMetabolitePrice")
public class BioanalysisMetabolitePriceResource {

	@Autowired
	BioanalysisMetabolitePriceRepository bioanalysisMetabolitePriceRepository;
	
	@GetMapping(value = "/all")
	public List <BioanalysisMetabolitePrice> getAll() {
		return bioanalysisMetabolitePriceRepository.findAll();
	}
	
	@PostMapping (value ="/load")
	public List<BioanalysisMetabolitePrice> persist(@RequestBody final BioanalysisMetabolitePrice bioeconomicsMetabolitePrice){
		bioanalysisMetabolitePriceRepository.save(bioeconomicsMetabolitePrice);
		return bioanalysisMetabolitePriceRepository.findAll();
	}
	
}
