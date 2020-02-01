package com.techprimers.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name = "MetaboliteName")
public class MetaboliteName {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column (name ="name", length = 500)
	private String name;
	
	
	//Foreign Key
	@ManyToOne()
	private BioanalysisMetabolite metabolite;

	
	
	//Constructor
	
	
	public MetaboliteName() {
	
	}

	
	
	public MetaboliteName(Long id, String name, BioanalysisMetabolite metabolite) {
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public BioanalysisMetabolite getMetabolite() {
		return metabolite;
	}

	public void setMetabolite(BioanalysisMetabolite metabolite) {
		this.metabolite = metabolite;
	}
	
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	
	
}
