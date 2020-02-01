package com.techprimers.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techprimers.db.model.ExternalSource;

public interface ExternalSourceRepository extends JpaRepository <ExternalSource, Integer> {

	List<ExternalSource> findByName (String name);
}
