package com.example;

import static org.junit.Assert.assertTrue;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Emp;
import com.example.repository.EmpRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpUnitTest {
	
	@Autowired
	EmpRepository empRepository;
	
	
//	@Test
	public void createTest(){
		Emp emp = new Emp();
		
		Iterable<Emp> iter = empRepository.findAll();
		emp.setEmpName("kbid3");
		empRepository.save(emp);
		
		assertTrue(iter!=empRepository.findAll());
	}
	
//	@Test
	public void deleteTest(){
		
		empRepository.removeByEmpName("kbid3");
		
		assertTrue(empRepository.findByName("kbid3")==null);
		
	}
	

}
