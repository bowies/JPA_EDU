package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dept {
	@Id	
	@Column(name = "DEPT_ID")
	long deptId;
	
	Long deptPid;
	Integer deptDelFlg;
	Integer deptLevel;
	String deptName;
	String deptHeadname;
	String deptRemark;
	String deptCode;
	String deptFid;
	Long deptCreId;
	String deptCreDate;
	String deptCreTime;
	Long deptEdtId;
	String deptEdtDate;
	String deptEdtTime;
	String deptAbbrname;
	String deptScode;

	
	public long getDeptId() {
		return deptId;
	}

	public void setDeptId(long deptId) {
		this.deptId = deptId;
	}

	public Long getDeptPid() {
		return deptPid;
	}

	public void setDeptPid(Long deptPid) {
		this.deptPid = deptPid;
	}

	public Integer getDeptDelFlg() {
		return deptDelFlg;
	}

	public void setDeptDelFlg(Integer deptDelFlg) {
		this.deptDelFlg = deptDelFlg;
	}

	public Integer getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptHeadname() {
		return deptHeadname;
	}

	public void setDeptHeadname(String deptHeadname) {
		this.deptHeadname = deptHeadname;
	}

	public String getDeptRemark() {
		return deptRemark;
	}

	public void setDeptRemark(String deptRemark) {
		this.deptRemark = deptRemark;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getDeptFid() {
		return deptFid;
	}

	public void setDeptFid(String deptFid) {
		this.deptFid = deptFid;
	}

	public Long getDeptCreId() {
		return deptCreId;
	}

	public void setDeptCreId(Long deptCreId) {
		this.deptCreId = deptCreId;
	}

	public String getDeptCreDate() {
		return deptCreDate;
	}

	public void setDeptCreDate(String deptCreDate) {
		this.deptCreDate = deptCreDate;
	}

	public String getDeptCreTime() {
		return deptCreTime;
	}

	public void setDeptCreTime(String deptCreTime) {
		this.deptCreTime = deptCreTime;
	}

	public Long getDeptEdtId() {
		return deptEdtId;
	}

	public void setDeptEdtId(Long deptEdtId) {
		this.deptEdtId = deptEdtId;
	}

	public String getDeptEdtDate() {
		return deptEdtDate;
	}

	public void setDeptEdtDate(String deptEdtDate) {
		this.deptEdtDate = deptEdtDate;
	}

	public String getDeptEdtTime() {
		return deptEdtTime;
	}

	public void setDeptEdtTime(String deptEdtTime) {
		this.deptEdtTime = deptEdtTime;
	}

	public String getDeptAbbrname() {
		return deptAbbrname;
	}

	public void setDeptAbbrname(String deptAbbrname) {
		this.deptAbbrname = deptAbbrname;
	}

	public String getDeptScode() {
		return deptScode;
	}

	public void setDeptScode(String deptScode) {
		this.deptScode = deptScode;
	}

}
