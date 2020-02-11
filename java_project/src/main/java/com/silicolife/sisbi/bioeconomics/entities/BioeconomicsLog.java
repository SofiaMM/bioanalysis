package com.silicolife.sisbi.bioeconomics.entities;

import java.io.Serializable;
import java.util.Date;

public class BioeconomicsLog implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long logId;
	
	private Long bioeconomicsMetaboliteId;
	
	private Long bioeconomicsMetabolitePriceId;
	
	private Long bioeconomicsMetaboliteMergeToId;

	private Date date;
	
	private String logType;
	
	private String logNotes;
	
	private String source;
	
	public BioeconomicsLog()
	{
		this.date = new Date();
	}

	public int compareTo(BioeconomicsLog o) {
		int comparedates = this.date.compareTo( o.getDate());
		if(comparedates==0)
		{
			return this.logId.compareTo(o.getLogId());
		}
		return comparedates;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((logId == null) ? 0 : logId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BioeconomicsLog other = (BioeconomicsLog) obj;
		if (logId == null) {
			if (other.logId != null)
				return false;
		} else if (!logId.equals(other.logId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BioeconomicsLogImpl [logId=" + logId + ", bioeconomicsMetaboliteId=" + bioeconomicsMetaboliteId
				+ ", bioeconomicsMetabolitePriceId=" + bioeconomicsMetabolitePriceId
				+ ", bioeconomicsMetaboliteMergeToId=" + bioeconomicsMetaboliteMergeToId + ", date=" + date
				+ ", logType=" + logType + ", logNotes=" + logNotes + ", source=" + source + "]";
	}

	public String toStringJson() {
		String result = new String();
		result = result + "{\n";
		result = result + "\tlogid="+logId+"\n";
		result = result + "\tbioeconomicsMetaboliteId="+bioeconomicsMetaboliteId+"\n";
		result = result + "\tbioeconomicsMetaboliteMergeToId="+bioeconomicsMetaboliteMergeToId+"\n";
		result = result + "\tbioeconomicsMetabolitePriceId="+bioeconomicsMetabolitePriceId+"\n";
		result = result + "\tdate="+date.toString()+"\n";
		result = result + "\tlogType="+logType+"\n";
		result = result + "\tlogNotes="+logNotes+"\n";
		result = result + "\tsource="+source+"\n";
		result = result + "}\n";
		return result;
	}
	
	public String toStringLineVersion() {
		String result = new String();
		result = result + "\tlogType="+logType+" "+"logNotes="+logNotes+" source="+source;
		if(bioeconomicsMetabolitePriceId!=null)
			result = result +  " priceID=[" + bioeconomicsMetabolitePriceId+"]";
		return result;
	}

	public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}

	public Long getBioeconomicsMetaboliteId() {
		return bioeconomicsMetaboliteId;
	}

	public void setBioeconomicsMetaboliteId(Long bioeconomicsMetaboliteId) {
		this.bioeconomicsMetaboliteId = bioeconomicsMetaboliteId;
	}

	public Long getBioeconomicsMetabolitePriceId() {
		return bioeconomicsMetabolitePriceId;
	}

	public void setBioeconomicsMetabolitePriceId(Long bioeconomicsMetabolitePriceId) {
		this.bioeconomicsMetabolitePriceId = bioeconomicsMetabolitePriceId;
	}

	public Long getBioeconomicsMetaboliteMergeToId() {
		return bioeconomicsMetaboliteMergeToId;
	}

	public void setBioeconomicsMetaboliteMergeToId(Long bioeconomicsMetaboliteMergeToId) {
		this.bioeconomicsMetaboliteMergeToId = bioeconomicsMetaboliteMergeToId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLogType() {
		return logType;
	}

	public void setLogType(String logType) {
		this.logType = logType;
	}

	public String getLogNotes() {
		return logNotes;
	}

	public void setLogNotes(String logNotes) {
		this.logNotes = logNotes;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

}
