package com.techprimers.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ExternalSource {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;   // se for *private* nenhuma classe que ascenda esta, consegue aceder aos campos, se for *protected* as classes ascendentes conseguem aceder, se for *public* todas as classes conseguem aceder
	@Column(name = "name")
	private String name;
	
	
	@OneToMany(mappedBy = "externalSource")
	private List <ExternalSourceId> externalSourceIds;
	
	//Constructor
		
	public ExternalSource(int id, String name) {
		
	}
	
	public ExternalSource() {

	}




	public List<ExternalSourceId> getExternalSourceIds() {
		return externalSourceIds;
	}


	public void setExternalSourceIds(List<ExternalSourceId> externalSourceIds) {
		this.externalSourceIds = externalSourceIds;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
	
}
