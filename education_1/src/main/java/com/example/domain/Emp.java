package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "EMP")
public class Emp {
	@TableGenerator(name = "empGen", table = "ID_GEN", pkColumnName = "GEN_KEY", 
			valueColumnName = "GEN_VALUE", pkColumnValue = "EMP_ID", allocationSize = 1)
	//시퀀스같은것 
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "empGen")
	@Column(name = "EMP_ID")
	Long empId;



	@Column(name = "DEPT_ID")
	Long deptId;

	

	@ManyToOne // 다 대 일 조인
	@JoinColumn(name = "DEPT_ID", referencedColumnName = "DEPT_ID", 
	insertable = false, updatable = false)
	Dept dept;
	
	
//	@Column(name = "EMP_DEL_FLG")
	Integer empDelFlg;
	
	String empName;
	String empLoginId;
	String empPass;
	String empPosition;
	String empTel;
	String empMobile;
	String empEmail;
	String empRemark;
	String empCode;
	String empPower;
	String empEnterDate;
	String empResignDate;
	Integer empCreId;
	String empCreDate;
	String empCreTime;
	Integer empEdtId;
	String empEdtDate;
	String empEdtTime;
	String grpcode;
	String empTitle;
	
	
	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public Long getDeptId() {
		return deptId;
	}
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
	public Integer getEmpDelFlg() {
		return empDelFlg;
	}
	public void setEmpDelFlg(Integer empDelFlg) {
		this.empDelFlg = empDelFlg;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpLoginId() {
		return empLoginId;
	}
	public void setEmpLoginId(String empLoginId) {
		this.empLoginId = empLoginId;
	}
	public String getEmpPass() {
		return empPass;
	}
	public void setEmpPass(String empPass) {
		this.empPass = empPass;
	}
	public String getEmpPosition() {
		return empPosition;
	}
	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}
	public String getEmpTel() {
		return empTel;
	}
	public void setEmpTel(String empTel) {
		this.empTel = empTel;
	}
	public String getEmpMobile() {
		return empMobile;
	}
	public void setEmpMobile(String empMobile) {
		this.empMobile = empMobile;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpRemark() {
		return empRemark;
	}
	public void setEmpRemark(String empRemark) {
		this.empRemark = empRemark;
	}
	public String getEmpCode() {
		return empCode;
	}
	public void setEmpCode(String empCode) {
		this.empCode = empCode;
	}
	public String getEmpPower() {
		return empPower;
	}
	public void setEmpPower(String empPower) {
		this.empPower = empPower;
	}
	public String getEmpEnterDate() {
		return empEnterDate;
	}
	public void setEmpEnterDate(String empEnterDate) {
		this.empEnterDate = empEnterDate;
	}
	public String getEmpResignDate() {
		return empResignDate;
	}
	public void setEmpResignDate(String empResignDate) {
		this.empResignDate = empResignDate;
	}
	public Integer getEmpCreId() {
		return empCreId;
	}
	public void setEmpCreId(Integer empCreId) {
		this.empCreId = empCreId;
	}
	public String getEmpCreDate() {
		return empCreDate;
	}
	public void setEmpCreDate(String empCreDate) {
		this.empCreDate = empCreDate;
	}
	public String getEmpCreTime() {
		return empCreTime;
	}
	public void setEmpCreTime(String empCreTime) {
		this.empCreTime = empCreTime;
	}
	public Integer getEmpEdtId() {
		return empEdtId;
	}
	public void setEmpEdtId(Integer empEdtId) {
		this.empEdtId = empEdtId;
	}
	public String getEmpEdtDate() {
		return empEdtDate;
	}
	public void setEmpEdtDate(String empEdtDate) {
		this.empEdtDate = empEdtDate;
	}
	public String getEmpEdtTime() {
		return empEdtTime;
	}
	public void setEmpEdtTime(String empEdtTime) {
		this.empEdtTime = empEdtTime;
	}
	public String getGrpcode() {
		return grpcode;
	}
	public void setGrpcode(String grpcode) {
		this.grpcode = grpcode;
	}
	public String getEmpTitle() {
		return empTitle;
	}
	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}

	
	

}
