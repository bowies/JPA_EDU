package com.example.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.Emp;

@Repository
public interface EmpRepository extends CrudRepository<Emp, Long> {

	@Transactional
	public void removeByEmpName(String empName);
	
	public void deleteByEmpName(String empName);
	
	public Emp findByEmpId(Long empId);
	

	@Query(nativeQuery=true)
	public Emp findByName(@Param("empName") String empName);
//	@Query(nativeQuery=true, value=" select * from emp where emp_name = :empName ")
	
	@Transactional //수정될 때는 트랜잭셔널 추가 - delete/update☆
	@Modifying
	@Query(nativeQuery=true)
	public void deleteByName(@Param("empName") String empName);
//	@Query(nativeQuery=true, value=" update emp set EMP_DEL_FLG = 1 where emp_name = :empName ")

	
//	public void removeByEmpIdAndEmpName(long empId, String empName);
	
	//과제
	//조회조건을 3개 이상 만들어서 조회/삭제

	//1개 - emploginid
	@Query(nativeQuery=true)
	public List <Emp> findByID(@Param("empLoginId") String empLoginId);
	
	
	@Transactional //수정될 때는 트랜잭셔널 추가 - delete/update☆
	@Modifying
	@Query(nativeQuery=true)
	public void deleteByID(@Param("empLoginId") String empLoginId);
	
	
	
	
}
