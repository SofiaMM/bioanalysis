package com.techprimers.db.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class BioanalysisMetabolitePrice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	@Column (name = "log_id")
	private String logId;
	@Column(name="price")
	private double price;
	@Column(name = "amount")
	private Double amount;
	@Column (name = "currency")
	private String currency;
	@Column (name = "unity")
	private String unity;
	@Column (name = "source")
	private String source;
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date date;
	
	@ManyToOne(optional=false)
	private BioanalysisMetabolite metabolite;
	
	@ManyToOne()
	private Provider provider;
	



	//Constructor
	public BioanalysisMetabolitePrice() {
		
	}
	
	
	


	public BioanalysisMetabolitePrice(int id, String logId, double price, Double amount, String currency, String unity,
			String source, Date date, BioanalysisMetabolite metabolite, Provider provider) {
		
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public Provider getProvider() {
		return provider;
	}



	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}



	public String getUnity() {
		return unity;
	}

	public void setUnity(String unity) {
		this.unity = unity;
	}



	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}



	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	public BioanalysisMetabolite getMetabolite() {
		return metabolite;
	}
	
	public void setMetabolite(BioanalysisMetabolite metabolite) {
		this.metabolite = metabolite;
	}



	public String getLog_id() {
		return logId;
	}

	public void setLog_id(String logId) {
		this.logId = logId;
	}



}
