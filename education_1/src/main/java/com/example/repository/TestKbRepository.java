package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.TestKb;

@Repository
public interface TestKbRepository extends JpaRepository<TestKb, String> {
	// 여기서 Test_KB table 조작 가능

	// 이게 ...구현하는 게 없고 그냥 이렇게 한 다음에
	// 메소드명에 기반해서 쿼리를 날려줌 -.-);;
	// 인터페이슨데 이렇게까지만 하면 되나 봐

	// id는 기본적으로 ?? 라서 안 해줘도 되나 보다
	public List<TestKb> findByAddress(String address);

	public List<TestKb> findByName(String name);

	public List<TestKb> findByPassword(String password);
	// 이렇게까지만 만들면 알아서 채워지나 봄
	// 인터넷 찾아보기!

	public List<TestKb> findByAddressAndName(String address, String name);
	// 얘는 And 쓰고 자동완성 쓰면 추천 배리어블 나옴 짱신기;;


	//<<findBy표현식 >> 얘들은 where 조건절을 생성해줌 짱좋음
	
	//And - where id = ?? and name = ??
	public List<TestKb> findByIdAndName(String id, String name);
	//Or - where id = ?? or name = ??
	public List<TestKb> findByIdOrName(String id, String name);

	//Between - where 시작일 between ? and ? // 얘는 날짜가 있어야 하나 봥
//	public List<TestKb> find시작일Between;
	//LessThan - where 숫자 < ? // 얘는 숫자용임
//	public List<TestKb> findBy숫자LessThan(숫자);
	//GreaterThan - where 숫자 > ?
//	public List<TestKb> findBy숫자GreaterThan(숫자);
	//IsNull - where 숫자 is null
//	public List<TestKb> findBy숫자IsNull;
	//IsNotNull, NotNull - where 숫자 not null
//	public List<TestKb> findBy숫자(Is)NotNull;
	
	//Like - where name like 파라미터의name
	public List<TestKb> findByNameLike(String name);
	
	//NotLike - where name not like 파라미터의 name
	public List<TestKb> findByNameNotLike(String name);
	
	//OrderBy - where 나이 > 파라미터숫자 order by 이름 desc
//	public List<TestKb> findBy나이OrderBy이름Desc;
	
	//Not - where 이름 <> 파라미터
	public List<TestKb> findByNameNot(String name);
	

}
