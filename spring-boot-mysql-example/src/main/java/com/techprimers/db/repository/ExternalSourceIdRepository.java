package com.techprimers.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.db.model.ExternalSourceId;

public interface ExternalSourceIdRepository extends JpaRepository <ExternalSourceId, Integer> {

	List <ExternalSourceId> findByName(String name);
	
}
