package com.techprimers.db;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.techprimers.db.model.Provider;
import com.techprimers.db.repository.ProviderRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProviderTest {


	@Autowired
	ProviderRepository provrepo;

	@Test
	public void test() {
		
		for(int i =0; i < 20 ; i++) {
			Provider provider = new Provider();
			provider.setName("AAA");
//			Optional<Provider> op = provrepo.findOne(org.springframework.data.domain.Example.of(provider));
//			System.out.println(op.isPresent());
//			Provider bd_provider = null;
//			if(op.isPresent()){
//				bd_provider = op.get();
//			} else {
//				bd_provider = provrepo.saveAndFlush(provider);
//			}
			
//			List<Provider> op = provrepo.findAll(org.springframework.data.domain.Example.of(provider));
//			System.out.println(op.size());
//			if(op.size() == 0) {
//				provrepo.saveAndFlush(provider);
//			}
			
			
			List<Provider> op = provrepo.findByName("AAA");
			System.out.println(op.size());
			if(op.size() == 0) {
				provrepo.saveAndFlush(provider);
			}
		}
	}
}
