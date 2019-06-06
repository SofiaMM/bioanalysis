package com.techprimers.db;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.silicolife.sisbi.bioeconomics.entities.BioeconomicsMetabolite;
import com.techprimers.bioanalysis.BioanalysisConnector;
import com.techprimers.db.utils.BioanalysisImporter;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BioanalysisImporterTest {

	
	@Autowired
	BioanalysisImporter importer;

//	@Test
//	public void problem_null() throws Exception {
//		
//		BioanalysisConnector con = new BioanalysisConnector("https://mendel.bio.di.uminho.pt/bioeconomics");
//		List<BioeconomicsMetabolite> mets = con.getMetabolites(4, 2);
//		System.out.println("=======================");
//		System.out.println(mets);
//		System.out.println(mets.size());
//
//	}
	
	@Test
	public void problem_disconection() throws Exception {
		
		BioanalysisConnector con = new BioanalysisConnector("https://mendel.bio.di.uminho.pt/bioeconomics");
		int page = 0;
		String name = " ";
		while (name != "2-Cyclopentylcyclopentyl crotonate") {
			List<BioeconomicsMetabolite> met = con.getMetabolites(page, 2);
			BioeconomicsMetabolite m1 = met.get(0);
			BioeconomicsMetabolite m2 = met.get(1);
			if (m1.getName() == "2-Cyclopentylcyclopentyl crotonate") {
				name = m1.getName();
			} else {
				name = m2.getName();
			}
			System.out.println("Page " + page);
			page ++;
		}
		
		System.out.println("Metabolite found page " + page);
	}
	
	@Test
	public void test() throws Exception {
		System.out.println("Initiate test.");
		System.out.println("Importer: " + importer);
		boolean imp = true;
		int page = 1180;  
		while(imp) {
			imp = importer.importAllFromBioeconomics("https://mendel.bio.di.uminho.pt/bioeconomics", page, 2);
//			System.out.println("Imported page " + page);
//			page++;
			try {
				System.out.println("Imported page " + page);
				page++;
			} catch (Exception e) {
				System.out.println("Importing page " + page);
			}
			
		}
				
	}
} 
