package com.silicolife.sisbi.bioeconomics.entities;

import java.io.Serializable;
import java.util.Date;

public class BioeconomicsMetabolitePrice implements Serializable{
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMetaboliteId() {
		return metaboliteId;
	}

	public void setMetaboliteId(Long metaboliteId) {
		this.metaboliteId = metaboliteId;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
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

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
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

	public BioeconomicsLog getLog() {
		return log;
	}

	public void setLog(BioeconomicsLog log) {
		this.log = log;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private Long metaboliteId;
	
	private Double price;
	
	private Double amount;
	
	private String currency;
	
	private String unit;
	
	private String provider;
	
	private String source;
	
	private Date date;
	
	private BioeconomicsLog log;
	
	public BioeconomicsMetabolitePrice()
	{
	}

	@Override
	public String toString() {
		return "BioeconomicsMetabolitePriceResult [id=" + id + ", price=" + price + ", amount=" + amount + ", currency="
				+ currency + ", unit=" + unit + ", provider=" + provider + ", source=" + source + ", date=" + date
				+ ", log=" + log + "]";
	}
	
	public String toStringTabFormat() 
	{
		return id + "\t" + amount + "\t" + unit + "\t" + price + "\t" + currency + "\t"+provider + "\t" + source + "\t" + date;
	}

}
