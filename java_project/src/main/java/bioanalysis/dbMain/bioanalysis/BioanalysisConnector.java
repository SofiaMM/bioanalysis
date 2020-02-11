package bioanalysis.dbMain.bioanalysis;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolite;
import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolitePrice;

public class BioanalysisConnector {

	String url;
	
		
	public BioanalysisConnector(String url) {
		this.url = url;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public List<BioeconomicsMetabolite> getMetabolites( int pageIndex, int pageSize) throws Exception{
		return getMetabolites(pageIndex, pageSize, "DESC", "id");
	}
	
	public List<BioeconomicsMetabolite> getMetabolites( int pageIndex, int pageSize, String order, String sort) throws Exception {
		URL u = new URL(url + "/rest/metabolites/getMetabolitesPaginated/"+ pageIndex + "/" + pageSize +"/" + order + "/" + sort);
		ObjectMapper map = new ObjectMapper();
		HttpURLConnection connec = (HttpURLConnection) u.openConnection(); 
		connec.setDoOutput(true);   
		connec.setDoInput(true);    
		connec.setRequestProperty("Content-Type", "application/json");  
		connec.setRequestProperty("Accept", "application/json");  
		connec.setRequestMethod("GET"); 
		InputStream resp = connec.getInputStream();
		List<BioeconomicsMetabolite> res = map.readValue(resp, map.getTypeFactory().constructCollectionType(List.class, BioeconomicsMetabolite.class));
		return res;
	}
	
	
	public List<BioeconomicsMetabolitePrice> getBioeconomicsPriceByMetaboliteId(Long metaboliteid) throws Exception {
		System.out.println("Initiate connector.");
		URL u = new URL(url + "/rest/price/search/bymetaboliteid/" + metaboliteid);
		ObjectMapper map = new ObjectMapper();
		HttpURLConnection connec = (HttpURLConnection) u.openConnection(); 
		connec.setDoOutput(true);   
		connec.setDoInput(true);    
		connec.setRequestProperty("Content-Type", "application/json");  
		connec.setRequestProperty("Accept", "application/json");  
		connec.setRequestMethod("GET"); 
		InputStream resp = connec.getInputStream();
		List<BioeconomicsMetabolitePrice> res = map.readValue(resp, map.getTypeFactory().constructCollectionType(List.class, BioeconomicsMetabolitePrice.class));
		return res;
	}
}


