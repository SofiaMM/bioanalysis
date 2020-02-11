package bioanalysis.dbMain.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bioanalysis.dbMain.db.model.BioanalysisMetabolitePrice;


public interface BioanalysisMetabolitePriceRepository extends JpaRepository <BioanalysisMetabolitePrice, Integer> {
	
	List <BioanalysisMetabolitePrice> findByLogId(String logId);
	
}
