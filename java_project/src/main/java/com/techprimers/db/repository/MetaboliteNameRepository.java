package com.techprimers.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.db.model.MetaboliteName;

public interface MetaboliteNameRepository extends JpaRepository <MetaboliteName, Integer> {

	List <MetaboliteName> findByName(String name);
	
}
