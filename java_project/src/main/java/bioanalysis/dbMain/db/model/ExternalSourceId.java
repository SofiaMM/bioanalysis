package bioanalysis.dbMain.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ExternalSourceId{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "id_name")
	private String idName;
		
	@ManyToOne(optional=false)
	private BioanalysisMetabolite metabolite;
	
	@ManyToOne(optional=false)
	private ExternalSource externalSource;




	public ExternalSource getExternalSource() {
		return externalSource;
	}


	public void setExternalSource(ExternalSource externalSource) {
		this.externalSource = externalSource;
	}



	public BioanalysisMetabolite getMetabolite() {
		return metabolite;
	}


	public void setMetabolite(BioanalysisMetabolite metabolite) {
		this.metabolite = metabolite;
	}



	//Constructor
	public ExternalSourceId() {
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}
		
}
