package bioanalysis.dbTest;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolite;
import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolitePrice;

import bioanalysis.dbMain.bioanalysis.BioanalysisConnector;

public class BioanalysisConnectorTest {

	
	@Test
	public void test() throws Exception {
		BioanalysisConnector con = new BioanalysisConnector("https://mendel.bio.di.uminho.pt/bioeconomics");
		List<BioeconomicsMetabolite> mets = con.getMetabolites(0, 50, "DESC", "Id");
		
		
		for(BioeconomicsMetabolite x : mets) {
			System.out.println(x.getMapSourceExternalIdSet());
		}
//		System.out.println(mets);
		
		
	}
	
	
	@Test
	public void test1() throws Exception {
		BioanalysisConnector con = new BioanalysisConnector("https://mendel.bio.di.uminho.pt/bioeconomics");
		List<BioeconomicsMetabolite> met_ids = con.getMetabolites(0, 2);
//		for (int i = 0; i < met_ids.size(); i++) {
//			
//		}
		
		for(BioeconomicsMetabolite m : met_ids) {
			Long id = m.getId();
			
			List<BioeconomicsMetabolitePrice> prices = con.getBioeconomicsPriceByMetaboliteId(id);
			
			System.out.println("Precos para o metabolito " + m.getId() + "  " + m.getName());
			prices.stream().forEach(this::printPrice);
			
		}
	}
	
	
	public void printPrice(BioeconomicsMetabolitePrice x) {
		
		if(x == null) {
			System.out.println("Preço a null");
			return;
		}
		List<Object> info = Arrays.asList(x.getId(), x.getAmount(), x.getPrice() , x.getCurrency(), x.getProvider(), x.getDate());
		
		String varprint = "";
		for(Object o : info) varprint += o+"\t";
		System.out.println(varprint);
//		System.out.println(info.stream().map(Object::toString).collect(Collectors.joining("\t")));
	}
}
