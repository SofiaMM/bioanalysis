package com.techprimers.db;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolite;
import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolitePrice;

public class GetPricesByMetaboliteTest {
private static String serverUrl = "https://mendel.bio.di.uminho.pt/bioeconomics";

	
//	public static void main(String[] args) throws JsonParseException, JsonMappingException, JsonProcessingException, MalformedURLException, ProtocolException, IOException {
//		String metaboliteId = "991636114564271777";
//		Set<BioeconomicsMetabolitePrice> prices = getPrices(serverUrl, metaboliteId);
//		for (BioeconomicsMetabolitePrice bioeconomicsMetabolitePrice : prices) {
//			System.out.println(bioeconomicsMetabolitePrice.toString());
//		}
//	}
//	
//	
//	public static void main(String[] args) throws JsonParseException, JsonMappingException, JsonProcessingException, MalformedURLException, ProtocolException, IOException {
//		
//	}
	
	
	@Test
	public void getPricesREST() throws Exception
	{
		String metaboliteId = "991636114564271777";
		Set<BioeconomicsMetabolitePrice> prices = getPrices(serverUrl, metaboliteId);
		for (BioeconomicsMetabolitePrice bioeconomicsMetabolitePrice : prices) {
			//System.out.println(bioeconomicsMetabolitePrice.toString());
			System.out.println(bioeconomicsMetabolitePrice.getDate());
		}
	}

	
	@Test 
	public void getMetabolitesREST() throws Exception 
	{
		int pageIndex = 2029;
		int pageSize = 2;
		String order = "DESC";
		String sort = "id";
		List <BioeconomicsMetabolite> bioMetabolites = searchMetabolite(serverUrl, pageIndex, pageSize, order, sort);
		for (BioeconomicsMetabolite metabolite : bioMetabolites) {   
			System.out.println(metabolite.getId() + " " + metabolite.getName() + " " + metabolite.getInchi() + " " + metabolite.getInchiKey() );           //fazer o print de cada metabolito que está na lista de metabolitos
		}
	}

	private static Set<BioeconomicsMetabolitePrice> getPrices(String serverUrl,String metaboliteId)
			throws JsonProcessingException, MalformedURLException, IOException, ProtocolException, JsonParseException,
			JsonMappingException {
		Set<BioeconomicsMetabolitePrice> out;
		ObjectMapper mapper = new ObjectMapper();
		URL u = new URL(serverUrl + "/rest/price/search/bymetaboliteid/"+metaboliteId);
		HttpURLConnection conn = (HttpURLConnection) u.openConnection();
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestMethod("GET");
		InputStream response = conn.getInputStream();
		Set<BioeconomicsMetabolitePrice> res = mapper.readValue(response,
				mapper.getTypeFactory().constructCollectionType(Set.class, BioeconomicsMetabolitePrice.class));
		out = res;
		return out;
	}
	
	private static List<BioeconomicsMetabolite> searchMetabolite(String serverUrl, int pageIndex, int pageSize, String order, String sort) throws Exception {
		URL u = new URL(serverUrl + "/rest/metabolites/getMetabolitesPaginated/"+ pageIndex + "/" + pageSize +"/" + order + "/" + sort);
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
}

