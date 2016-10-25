package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.TestKb;
import com.example.repository.TestKbRepository;

@RequestMapping("/testkb")
@RestController
public class TestController {
	@Autowired
	private TestKbRepository testKbRepository;

	// @RequestMapping("test")
	//// @ResponseBody
	// public String TestFunction(){
	//
	// String test = "test";
	//
	// return test;
	// }
	//
	//
	// @RequestMapping("day1loginAccess")
	// public void loginAccess(Model model) {
	//
	// model.addAttribute("id1", "day1id");
	// model.addAttribute("pw1", "day1pw");
	//
	// }
	//

	@RequestMapping(value = "/") // get인데 메소드에 get 쓰면 안 돌아감 왜지...
	// @ResponseBody _ 이거 restcontroller 사용하면 안 써도 됨
	// 를 안 사용하고 굳이 뷰에서 list 출력하고 싶으면 일단 저거 하고 해봐야지 - 는 controller 사용해야함
	public List<TestKb> list() {
		List<TestKb> list = testKbRepository.findAll();

		return list;
	}

	// @RequestMapping(value="/", params = {"address"})
	// public TestKb getAddress( @RequestParam(name="address") String address){
	//
	// TestKb testkb = (TestKb) testKbRepository.findByAddress(address);
	// return testkb;
	//
	// }

	// @RequestMapping(value="/", params={"address","name"})
	// public List<TestKb> joinAddressName(@RequestParam(name="address") String
	// address,@RequestParam(name="name") String name){
	// //컨트롤러-연결 만 / 리파지토리 -db 연결하는 기능만 / 서비스 - 비즈니스
	//
	// List<TestKb> testkb = testKbRepository.findByAddressAndName(address,
	// name);
	// return testkb;
	//
	// }

	@RequestMapping(value = "/{id}", method = { RequestMethod.GET })
	// @ResponseBody
	public TestKb view(@PathVariable String id) {
		TestKb testkb = testKbRepository.findOne(id);
		return testkb;
	}

	// put -> update
	@RequestMapping(value = "/{id}", method = { RequestMethod.PUT })
	public void sample1(@PathVariable String id, @RequestBody TestKb testkb) {
		testKbRepository.save(testkb);
	}

	// post -> create
	@RequestMapping(value = "/", method = { RequestMethod.POST })
	public void sample2forsave(@RequestBody TestKb testkb) {

		testKbRepository.save(testkb);
	}

	// delete -> delete
	@RequestMapping(value = "/{id}", method = { RequestMethod.DELETE })
	public void sample3fordelete(@PathVariable String id) {
		testKbRepository.delete(id);

	}

	
	
	
	// //put -> update
	// public TestKb sample4forupdate(@PathVariable(name="id") String id,
	// @RequestBody TestKb testkb){
	// testKbRepository.save(testkb); // save == update // 없 - 만 / 있 - 가져옴
	// return testkb;
	// }

}
