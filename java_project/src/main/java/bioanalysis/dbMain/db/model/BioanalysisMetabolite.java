package bioanalysis.dbMain.db.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity 
@Table (name = "BioanalysisMetabolite")
public class BioanalysisMetabolite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // para tirar tabela hibernate_sequence que se criava sozinha
	private Long id;
	@Column (name = "id_bioeco")
	private String idBioeco;
	@Column (name = "common_name", length = 1500)
	private String commonName;
	@Column(name = "inchi", length=5000)
	private String inchi;
	@Column(name = "inchi_key", length = 1500)
	private String inchiKey;
	@Column(name = "smiles", length = 1500)
	private String smiles;
	
	
	@OneToMany(mappedBy="metabolite", cascade = CascadeType.ALL)
	private List <BioanalysisMetabolitePrice> bioanalysisMetabolitePrices;
	
	@OneToMany(mappedBy="metabolite", cascade = CascadeType.ALL)
	private Set <MetaboliteName> metaboliteNames;
	
	
	@OneToMany(mappedBy="metabolite")
	private List <ExternalSourceId> externalSourceId;

	public List<ExternalSourceId> getExternalSourcesIds() {
		return externalSourceId;
	}

	
	
	//Constructor
	
	public BioanalysisMetabolite() {
	}



	public BioanalysisMetabolite(Long id, String idBioeco, String commonName, String inchi, String inchiKey,
			String smiles, List<BioanalysisMetabolitePrice> bioanalysisMetabolitePrices,
			Set<MetaboliteName> metaboliteNames, List<ExternalSourceId> externalSourceId) {
		
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

	public String getCommon_name() {
		return commonName;
	}

	public void setCommon_name(String commonName) {
		this.commonName = commonName;
	}
	
	
	

	public String getInchi() {
		return inchi;
	}

	public void setInchi(String inchi) {
		this.inchi = inchi;
	}

	
	
	
	public String getInchi_key() {
		return inchiKey;
	}

	public void setInchi_key(String inchiKey) {
		this.inchiKey = inchiKey;
	}

	
	
	
	public String getSmiles() {
		return smiles;
	}

	public void setSmiles(String smiles) {
		this.smiles = smiles;
	}
	
	
	

	public String getId_bioeco() {
		return idBioeco;
	}

	public void setId_bioeco(String idBioeco) {
		this.idBioeco = idBioeco;
	}

	
	

	public List<BioanalysisMetabolitePrice> getBioanalysisMetabolitePrices() {
		return bioanalysisMetabolitePrices;
	}

	public void setBioanalysisMetabolitePrices(List<BioanalysisMetabolitePrice> bioanalysisMetabolitePrices) {
		this.bioanalysisMetabolitePrices = bioanalysisMetabolitePrices;
	}
	
	
	

	public Set<MetaboliteName> getMetaboliteNames() {
		return metaboliteNames;
	}

	public void setMetaboliteNames(Set<MetaboliteName> metaboliteNames) {
		this.metaboliteNames = metaboliteNames;
	}
	
	
	
	
	public void setExternalSourceId(List<ExternalSourceId> externalSourceId) {
		this.externalSourceId = externalSourceId;
	}

	public List<ExternalSourceId> getExternalSourceId() {
		return externalSourceId;
	}
	
	
}
