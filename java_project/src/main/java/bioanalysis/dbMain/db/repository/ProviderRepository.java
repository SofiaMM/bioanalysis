package bioanalysis.dbMain.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import bioanalysis.dbMain.db.model.Provider;

public interface ProviderRepository extends JpaRepository <Provider, Integer> {
	
	List<Provider> findByName(String name);  // Só podemos fazer isto assim se o String Name for um campo do provider!! Senão temos de escrever mais
}
