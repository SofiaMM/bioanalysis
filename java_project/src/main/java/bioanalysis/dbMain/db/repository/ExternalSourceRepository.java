package bioanalysis.dbMain.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bioanalysis.dbMain.db.model.ExternalSource;

public interface ExternalSourceRepository extends JpaRepository <ExternalSource, Integer> {

	List<ExternalSource> findByName (String name);
}
