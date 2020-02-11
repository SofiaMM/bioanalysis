package bioanalysis.dbMain.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bioanalysis.dbMain.db.model.BioanalysisMetabolite;

public interface BioanalysisMetaboliteRepository extends JpaRepository <BioanalysisMetabolite, Long> {
		
	List <BioanalysisMetabolite> findByIdBioeco (String idBioeco);
}
