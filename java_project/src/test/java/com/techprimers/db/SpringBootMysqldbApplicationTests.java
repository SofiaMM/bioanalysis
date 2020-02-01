package com.techprimers.db;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techprimers.db.model.BioanalysisMetabolite;
import com.techprimers.db.model.BioanalysisMetabolitePrice;
import com.techprimers.db.repository.BioanalysisMetabolitePriceRepository;
import com.techprimers.db.repository.BioanalysisMetaboliteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMysqldbApplicationTests {

	@Autowired
	BioanalysisMetaboliteRepository mrepo;
	@Autowired
	BioanalysisMetabolitePriceRepository prepo;
	
	@Test
	public void contextLoads() {
		BioanalysisMetabolite en_citrate = new BioanalysisMetabolite();
		en_citrate.setId_bioeco("991636114564271777");
		en_citrate.setInchi("InChI=1S/C26H28ClNO.C6H8O7/c1-3-28(4-2)19-20-29-24-17-15-22(16-18-24)25(21-11-7-5-8-12-21)26(27)23-13-9-6-10-14-23;7-3(8)1-6(13,5(11)12)2-4(9)10/h5-18H,3-4,19-20H2,1-2H3;13H,1-2H2,(H,7,8)(H,9,10)(H,11,12)/b26-25+");
		en_citrate.setInchi_key("PYTMYKVIJXPNBD-BTKVJIOYSA-N");
		en_citrate.setSmiles("CCN(CC)CCOC1=CC=C(C=C1)C(=C(C2=CC=CC=C2)Cl)C3=CC=CC=C3.C(C(=O)O)C(CC(=O)O)(C(=O)O)O");		

		
		BioanalysisMetabolite di_mesylate = new BioanalysisMetabolite();
		di_mesylate.setId_bioeco("4137401369215699925");
//		di_mesylate.setInchi ("InChI=1S/C33H37N5O5.CH4O3S/c1-32(35-29(39)21-15-23-22-10-6-11-24-28(22)20(17-34-24)16-25(23)36(2)18-21)31(41)38-26(14-19-8-4-3-5-9-19)30(40)37-13-7-12-27(37)33(38,42)43-32;1-5(2,3)4/h3-6,8-11,17,21,23,25-27,34,42H,7,12-16,18H2,1-2H3,(H,35,39);1H3,(H,2,3,4"); // )/t21-,23?,25-,26+,27+,32-,33+;/m1./s1");
		di_mesylate.setInchi_key("ADYPXRFPBQGGAH-WVVAGBSPSA-N");
		di_mesylate.setSmiles("CC1(C(=O)N2C(C(=O)N3CCCC3C2(O1)O)CC4=CC=CC=C4)NC(=O)C5CC6C(CC7=CNC8=CC=CC6=C78)N(C5)C.CS(=O)(=O)O");
		
		BioanalysisMetabolite ta_hy_hydrate = new BioanalysisMetabolite();
		ta_hy_hydrate.setId_bioeco("8028748455202179632");
		ta_hy_hydrate.setInchi("InChI=1S/C13H14N2.ClH.H2O/c14-13-9-5-1-3-7-11(9)15-12-8-4-2-6-10(12)13;;/h1,3,5,7H,2,4,6,8H2,(H2,14,15);1H;1H2");
		ta_hy_hydrate.setInchi_key("PXGRMZYJAOQPNZ-UHFFFAOYSA-N");
		ta_hy_hydrate.setSmiles("C1CCC2=NC3=CC=CC=C3C(=C2C1)N.O.Cl");
		
		BioanalysisMetabolite hex = new BioanalysisMetabolite();
		hex.setId_bioeco("31770837233490023");
		hex.setInchi("InChI=1S/C6H12O/c1-2-3-4-5-6-7/h3-4,7H,2,5-6H2,1H3");
		hex.setInchi_key("UFLHIIWVXFIJGU-UHFFFAOYSA-N");
		hex.setSmiles("CCC=CCCO");
		
		BioanalysisMetabolite gl_caprate = new BioanalysisMetabolite();
		gl_caprate.setId_bioeco("373144576646484638");
		gl_caprate.setInchi("InChI=1S/C21H40O6/c1-2-3-4-10-13-18(21(26)27-17-19(23)16-22)14-11-8-6-5-7-9-12-15-20(24)25/h18-19,22-23H,2-17H2,1H3,(H,24,25)/p-1");
		gl_caprate.setInchi_key("YWHITOKQSMJXEA-UHFFFAOYSA-M");
		gl_caprate.setSmiles("CCCCCCC(CCCCCCCCCC(=O)[O-])C(=O)OCC(CO)O");
		
								
		en_citrate = mrepo.save(en_citrate);
		di_mesylate = mrepo.save(di_mesylate);    //isto não faz update!! Cria sempre um metabolito novo
		ta_hy_hydrate = mrepo.save(ta_hy_hydrate);
		hex = mrepo.save(hex);
		gl_caprate = mrepo.save(gl_caprate);
		
		
		//prices
		BioanalysisMetabolitePrice cit_p = new BioanalysisMetabolitePrice();
//		cit_p.setId(1);
		cit_p.setLog_id("6032129065830610737");
		cit_p.setAmount(100.0);
		cit_p.setUnit("mg");
		cit_p.setPrice(38.6);
		cit_p.setCurrency("USD");
//		cit_p.setProvider("AK Scientific, Inc.");
		cit_p.setSource("MolPort");
//		cit_p.setDate("2017-12-07 04:10:55");
		cit_p.setMetabolite(en_citrate);
		
		
		//prices
		cit_p = prepo.save(cit_p);
		
		System.out.println("ID: " + cit_p.getId());
//		System.out.println(en_citrate.getId());
		
		
	}
	
	
//	@Test
//	public void price() {
//		
//		BioeconomicsMetabolitePrice cit_p = new BioeconomicsMetabolitePrice();
//		cit_p.setLog_id("6032129065830610737");
//		cit_p.setAmount(100);
//		cit_p.setUnity("mg");
//		cit_p.setPrice(38.6);
//		cit_p.setCurrency("USD");
//		cit_p.setProvider("AK Scientific, Inc.");
//		cit_p.setSource("MolPort");
//		cit_p.setDate("2017-12-07 04:10:55");
//		cit_p.setMetabolite(en_citrate);
//		
//		System.out.println("Price: " + cit_p);
////		System.out.println("LOG_ID: " + cit_p.getLog_id());
//		
//		cit_p = prepo.save(cit_p);
//		
//
//	}
	
	
	@Test
	public void test() {
		saveOve();
		
	}
	
	
	public void saveOve() {
		BioanalysisMetabolite met =new BioanalysisMetabolite();
		met.setId((long) 2);
		System.out.println(met.getId());
		met.setInchi("InChI=1S/C33H37N5O5.CH4O3S/c1-32(35-29(39)21-15-23-22-10-6-11-24-28(22)20(17-34-24)16-25(23)36(2)18-21)31(41)38-26(14-19-8-4-3-5-9-19)30(40)37-13-7-12-27(37)33(38,42)43-32;1-5(2,3)4/h3-6,8-11,17,21,23,25-27,34,42H,7,12-16,18H2,1-2H3,(H,35,39);1H3,(H,2,3,4\"); // )/t21-,23?,25-,26+,27+,32-,33+;/m1./s1");
		met.setId_bioeco("4137401369215699925");
		met.setInchi_key("ADYPXRFPBQGGAH-WVVAGBSPSA-N");
		met.setSmiles("CC1(C(=O)N2C(C(=O)N3CCCC3C2(O1)O)CC4=CC=CC=C4)NC(=O)C5CC6C(CC7=CNC8=CC=CC6=C78)N(C5)C.CS(=O)(=O)O");
		mrepo.saveAndFlush(met);
	}

}
