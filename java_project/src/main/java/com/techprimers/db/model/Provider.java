package com.techprimers.db.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Provider {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Identity porque se ficar em Auto aparece uma tabela a mais na BD
	private int id;
	@Column (name ="name")
	private String name;
	@Column (name = "address")
	private String address;
	@Column (name = "zip_code")
	private String zipCode;
	@Column (name = "city")
	private String city;
	@Column (name = "country")
	private String country;
	@Column (name = "contact")
	private Integer contact;
	
	
	@OneToMany(mappedBy="provider")
	private List <BioanalysisMetabolitePrice> bioanalysisMetabolitePrices;
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


//	public List<BioeconomicsMetabolitePrice> getBioeconomicsMetabolitePrices() {
//		return bioeconomicsMetabolitePrices;
//	}
//
//
//	public void setBioeconomicsMetabolitePrices(List<BioeconomicsMetabolitePrice> bioeconomicsMetabolitePrices) {
//		this.bioeconomicsMetabolitePrices = bioeconomicsMetabolitePrices;
//	}


	//Constructor
	public Provider() {
		
	}

	
	public int getIdProvider() {
		return id;
	}

	public void setIdProvider(int idProvider) {
		this.id = idProvider;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	
	
	
	public Integer getContact() {
		return contact;
	}

	public void setContact(Integer contact) {
		this.contact = contact;
	}
	
	

}
