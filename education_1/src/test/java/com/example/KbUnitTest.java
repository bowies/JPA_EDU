package com.example;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.TestKb;
import com.example.repository.TestKbRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KbUnitTest {
	
	@Autowired
	TestKbRepository testKbRepository;
	
	List<TestKb> testlist = null;
	
	
	
	@Test
	public void test() {
		TestKb testKb = new TestKb();
		
		testKb.setId("isid2");
		testKb.setName("isname2");
		testKb.setPassword("ispw2");
		testKb.setAddress("isaddress2");
		testKbRepository.save(testKb);
		testlist = testKbRepository.findAll();
		
		assertTrue(testlist.size() == 1);
		
		
	}
	
	
}
