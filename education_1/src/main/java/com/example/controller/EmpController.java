package com.example.controller;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Emp;
import com.example.repository.EmpRepository;

@RequestMapping("/emp")
@RestController
public class EmpController {
	private final Log log = LogFactory.getLog(getClass());
	@Autowired
	private EmpRepository empRepository;

	@RequestMapping("/")
	public Iterable<Emp> list() {
		Iterable<Emp> list = empRepository.findAll();
		log.info(list);
		return list;
	}
	

	// EMP 이름으로 검색해서 삭제 할꺼임
	// 본인이름 으로
	// emp 만들고 삭제
	//
	@RequestMapping(method = { RequestMethod.POST })
	public void createEmp(@RequestBody Emp emp) {

		emp.setEmpId(null);
		empRepository.save(emp);
	}
	// 생성은 됨...
	// 삭제가 안됨 ㅠㅠ

	@RequestMapping(value = "/{empId}", method = { RequestMethod.DELETE }) // 이게
																			// 패스베리어블
																			// ㅠㅠ..ㄴㅁㅇㄴㅇㄴㅁㅇㅁㅇㄴㅁ
	public void deleteEmp(@PathVariable long empId) { // id, 특별한 명령어, 지시자만
														// pathvariable

		log.info(empId);
		empRepository.delete(empId);
	}

	@RequestMapping(params = { "empName" }, method = { RequestMethod.DELETE })
	public void deleteByEmp(@RequestParam(name = "empName") String empName) {

		empRepository.removeByEmpName(empName);
	}

	@RequestMapping(params = { "empName" }, method = { RequestMethod.GET })
	public Emp findByName(@RequestParam(name = "empName") String empName) {
		return empRepository.findByName(empName);
	}

	@RequestMapping(params = { "empId" }, method = { RequestMethod.GET })
	public Emp findByEmpId(@RequestParam(name = "empId") Long empId) {
		return empRepository.findByEmpId(empId);
	}
	
	@RequestMapping(params = { "empName" }, method = { RequestMethod.PUT })
	public void deleteByFlag(@RequestParam(name = "empName") String empName) {
		empRepository.deleteByName(empName);
	}

	// public void 하나 생성하고 삭제 하고 개수 확인 하는 거...(){
	// https://docs.google.com/presentation/d/1pQ-wG-6pLEAPjVU80Ggny57ub2qT6sRRBxP2o96voI8/edit#slide=id.g185ddc8d8b_0_140
	// 과제
	// }
	
	@RequestMapping(params = { "empLoginId" }, method = { RequestMethod.GET })
	public Iterable<Emp> findByEmpLoginId(@RequestParam(name="empLoginId") String empLoginId) {
		Iterable<Emp> list = empRepository.findByEmpLoginId(empLoginId);

		return list;
	}

	@RequestMapping(params = { "empLoginId" }, method = { RequestMethod.PUT })
	public void deleteByID(@RequestParam(name = "empLoginId") String empLoginId) {
		empRepository.deleteByID(empLoginId);
	}



}
