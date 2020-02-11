package com.silicolife.sisbi.bioeconomics.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class BioeconomicsMetabolite implements Serializable{

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEntry() {
		return entry;
	}

	public void setEntry(String entry) {
		this.entry = entry;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInchi() {
		return inchi;
	}

	public void setInchi(String inchi) {
		this.inchi = inchi;
	}

	public String getInchiKey() {
		return inchiKey;
	}

	public void setInchiKey(String inchiKey) {
		this.inchiKey = inchiKey;
	}

	public String getSmiles() {
		return smiles;
	}

	public void setSmiles(String smiles) {
		this.smiles = smiles;
	}

	public Set<String> getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(Set<String> otherNames) {
		this.otherNames = otherNames;
	}

	public Map<String, Set<String>> getMapSourceExternalIdSet() {
		return mapSourceExternalIdSet;
	}

	public void setMapSourceExternalIdSet(Map<String, Set<String>> mapSourceExternalIdSet) {
		this.mapSourceExternalIdSet = mapSourceExternalIdSet;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getLastPriceSearchDate() {
		return lastPriceSearchDate;
	}

	public void setLastPriceSearchDate(Date lastPriceSearchDate) {
		this.lastPriceSearchDate = lastPriceSearchDate;
	}

	public String getEntranceSource() {
		return entranceSource;
	}

	public void setEntranceSource(String entranceSource) {
		this.entranceSource = entranceSource;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String entry;
	
	private String name;
	
	private String description;
	
	private String inchi;
	
	private String inchiKey;
	
	private String smiles;
	
	private Set<String> otherNames;
	
	private Map<String, Set<String>> mapSourceExternalIdSet;
	
	private Date createDate;
	
	private Date updateDate;
	
	private Date lastPriceSearchDate;
	
	private String entranceSource;
	
	public BioeconomicsMetabolite() {
		this.mapSourceExternalIdSet = new HashMap<>();
		this.createDate = new Date();
		this.lastPriceSearchDate = new Date();
	}
	
	public Set<String> getExternalIdsBySource(String source)
	{
		if(mapSourceExternalIdSet==null)
			return null;
		return mapSourceExternalIdSet.get(source);
	}

	@Override
	public String toString() {
		return "BioeconomicsMetabolite [inchi=" + inchi + ", inchiKey=" + inchiKey + ", smiles=" + smiles
				+ ", otherNames=" + otherNames + ", mapSourceExternalIdSet=" + mapSourceExternalIdSet + ", id=" + id
				+ ", entry=" + entry + ", name=" + name + "]";
	}
	
	public String toString2() {
		return "BioeconomicsMetabolite ["+lastPriceSearchDate+"id=" + id
				+ ", entry=" + entry + ", name=" + name + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BioeconomicsMetabolite other = (BioeconomicsMetabolite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	
}
