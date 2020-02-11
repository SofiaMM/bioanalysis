package bioanalysis.dbMain.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bioanalysis.dbMain.db.model.ExternalSourceId;

public interface ExternalSourceIdRepository extends JpaRepository <ExternalSourceId, Integer> {

	List <ExternalSourceId> findByIdName(String idName);
	
}
