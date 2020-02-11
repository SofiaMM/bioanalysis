package bioanalysis.dbMain.db.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolite;
import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolitePrice;

import bioanalysis.dbMain.bioanalysis.BioanalysisConnector;
import bioanalysis.dbMain.db.model.BioanalysisMetabolite;
import bioanalysis.dbMain.db.model.BioanalysisMetabolitePrice;
import bioanalysis.dbMain.db.model.ExternalSource;
import bioanalysis.dbMain.db.model.ExternalSourceId;
import bioanalysis.dbMain.db.model.MetaboliteName;
import bioanalysis.dbMain.db.model.Provider;
import bioanalysis.dbMain.db.repository.BioanalysisMetabolitePriceRepository;
import bioanalysis.dbMain.db.repository.BioanalysisMetaboliteRepository;
import bioanalysis.dbMain.db.repository.ExternalSourceIdRepository;
import bioanalysis.dbMain.db.repository.ExternalSourceRepository;
import bioanalysis.dbMain.db.repository.MetaboliteNameRepository;
import bioanalysis.dbMain.db.repository.ProviderRepository;

@Service
@Transactional
public class BioanalysisImporter {

	private static Logger logger = LoggerFactory.getLogger(BioanalysisImporter.class);
	@Autowired
	BioanalysisMetaboliteRepository mrepo;
	@Autowired
	BioanalysisMetabolitePriceRepository prepo;
	@Autowired
	ProviderRepository provrepo;
	@Autowired
	MetaboliteNameRepository nrepo;
	@Autowired
	ExternalSourceRepository extrepo;
	@Autowired
	ExternalSourceIdRepository idrepo;
	
	public boolean importAllFromBioeconomics(String url, int page, int size) throws Exception {
			System.out.println("Initiate import.");
			BioanalysisConnector con = new BioanalysisConnector(url);
			
			List<BioeconomicsMetabolite> mets = con.getMetabolites(page, size);
			if(mets.size() == 0) {return false;}
			System.out.println(mets);
			List<BioeconomicsMetabolitePrice> prices = new ArrayList<>();
			for(BioeconomicsMetabolite x : mets) {
				prices.addAll(con.getBioeconomicsPriceByMetaboliteId(x.getId()));
				System.out.println(prices);
			}
			
			saveInfoOnDB(mets, prices);
			System.out.println("Metabolites and prices saved on DB.");
			return true;
		
	}

	
	private void saveInfoOnDB(List<BioeconomicsMetabolite> mets, List<BioeconomicsMetabolitePrice> prices) {
		
		logger.info("Inserting {} metabolites", mets);
		Map <String, BioanalysisMetabolite> savedMetabolites = new HashMap<String, BioanalysisMetabolite>(); //Criar dicionário que terá id do bioeconomics e o metabolito correspondente que já foi salvo		
		for (BioeconomicsMetabolite x : mets) {
			if(x == null ) {
				System.out.println("");
			}
			BioanalysisMetabolite met = this.saveSingleMetabolite(x); //Converte o metabolito do bioeco para o metabolito do bioanalysis
			
			savedMetabolites.put(met.getId_bioeco(), met); //Coloca o matabolito salvo atrás no dicionário de metabolitos salvos
			System.out.println("Metabolites saved.");		
		}
		
		
		logger.info("Inserting {} prices", prices.size());
		for (BioeconomicsMetabolitePrice p : prices) {
			BioanalysisMetabolitePrice price = this.convertPrice(p);  //Converter o preco de bioeconomics num preco de bioanalysis
			String bioeco_id = p.getMetaboliteId() + "";    //Guardar o id do bioeco para um metabolito
			BioanalysisMetabolite met = new BioanalysisMetabolite(); // Criar um novo metabolito
			met.setId(savedMetabolites.get(bioeco_id).getId()); // Ir buscar o metabolito para este preço através do id do bioeconomics
			price.setMetabolite(met);  // Fazer corresponder o preco a um metabolito
			
			String log = price.getLog_id();
			List <BioanalysisMetabolitePrice> prs = prepo.findByLogId(log);
			if (prs.size() == 0 ) {
				price = prepo.save(price);  // Salvar o preço no bioanalysis
			} else {
				price = prs.get(0);
			}
			
//			price = prepo.save(price);  // Salvar o preço no bioanalysis
			System.out.println("Prices saved.");
		}
	
		
	}
	
	
	protected BioanalysisMetabolite saveSingleMetabolite(BioeconomicsMetabolite m) {
		
		
		
		BioanalysisMetabolite met = new BioanalysisMetabolite();
		met.setId_bioeco(m.getId()+"");
		met.setInchi(m.getInchi());
		met.setInchi_key(m.getInchiKey());
		met.setSmiles(m.getSmiles());
		met.setCommon_name(m.getName());		
//		
//		met = mrepo.save(met);   //Salva o metabolito no bioanalysis
		String IdBio = met.getId_bioeco();
		
		List <BioanalysisMetabolite> mts = mrepo.findByIdBioeco(IdBio);
		if (mts.size() == 0) {
//			met.setId_bioeco(m.getId()+"");
//			met.setInchi(m.getInchi());
//			met.setInchi_key(m.getInchiKey());
//			met.setSmiles(m.getSmiles());
//			met.setCommon_name(m.getName());		
			met = mrepo.save(met);   //Salva o metabolito no bioanalysis
		} else {
			met = mts.get(0);
		}
				
		
		//Converter os nomes 
		Set<String> names = m.getOtherNames(); //Criar set com todo o conjunto de nomes que o metabolito pode ter
		if(names == null) names = new HashSet<>();
		if(m.getName()!= null) names.add(m.getName());
		
		
		for (String n : names) {
			MetaboliteName name = new MetaboliteName();   //Criar um nome
			name.setName(n);                              //Colocar no objeto nome o campo nome que será um nome do set criado antes
			name.setMetabolite(met);
			
//			name = nrepo.save(name);
			
			List <MetaboliteName> nms = nrepo.findByName(n);  //Making sure it only saves one time the same metabolite name
			if (nms.size() == 0) {
				name = nrepo.save(name);
			} else {
				name = nms.get(0);
			}
		}
		
		

		Map<String, Set<String>> ext = m.getMapSourceExternalIdSet();     // Getting the map and saving as ext
		for(String id : ext.keySet()) { 								  // Go through the keys of the map aka the sources	
			
			List <ExternalSource> exts = extrepo.findByName(id);          // See if there is any external sources already saved with that name
			ExternalSource extsource = new ExternalSource();			  // Create a new externalSource	
			if(exts.size() > 0) {  										  // If there is set as external source the first element of the list	
				extsource = exts.get(0);
			} else {                                                      // If there is not:
				extsource.setName(id); 										 // Set the name of the source in the new external source object				
				extsource = extrepo.save(extsource);                         // And save it
			}
			
			for(String extName : ext.get(id)) {							  // Then go through the list of ids in a specific external source
				ExternalSourceId extId = new ExternalSourceId();		  // Create a new external source id as extId	
				extId.setExternalSource(extsource);                       // Set the external source to the new object  
				extId.setMetabolite(met);         						  // And set the related metabolite
				
				List <ExternalSourceId> ids = idrepo.findByIdName(extName);// See if there is already saved ids with the same id 
				if (ids.size()==0) {                                      // If not:
					extId.setIdName(extName); 								// Then set the id to the existing one 
					extId = idrepo.save(extId);                             // And save the new external source id to the database 
				} else {                                                  // If yes:  
//					extId.setName(extName); 								// Then set the id to the existing one  (não faz sentido para mim isto)
					extId = ids.get(0);               						// And instead of saving, set as extId the first element of the list
				}
			}
		}
	
        
		System.out.println("Metabolite converted.");
		return met;
		
	}
	
	protected BioanalysisMetabolitePrice convertPrice(BioeconomicsMetabolitePrice p) {
		BioanalysisMetabolitePrice pr = new BioanalysisMetabolitePrice();
		pr.setLog_id(p.getId() + "");
		pr.setPrice(p.getPrice());
		pr.setCurrency(p.getCurrency());
		pr.setAmount(p.getAmount());
		pr.setUnit(p.getUnit());
		pr.setSource(p.getSource());
		pr.setDate(p.getDate());
		
		
		//Converter o provider
		Provider provider = new Provider();   //Criar um novo provider
		provider.setName(p.getProvider());    //Dar um nome ao provider através do nome desse no preco do bioeconomics
		
		List<Provider> op = provrepo.findByName(provider.getName());  //Criar uma lista com todos os nomes dos providers salvos
		Provider bd_provider = null; //provider no bioanalysis e null
		if(op.size() == 0) {  //Se a lista for zero
			bd_provider = provrepo.saveAndFlush(provider);    // Salva o provider no bioanalysis, bd_provider deixa de ser nulo e passa a ser o provider que foi guardado 
		} else {
			bd_provider = op.get(0);  //Senao bd_provider passa a ser o provider que está no início da lista
		}
		
	
		pr.setProvider(bd_provider); //Guardar o bd_provider no bioeconomics
		
		System.out.println("Price converted.");
		return pr;
		 	
	}
	
}
