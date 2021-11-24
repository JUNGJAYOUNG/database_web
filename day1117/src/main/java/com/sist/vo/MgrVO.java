package com.sist.vo;

import java.util.Date;

public class MgrVO {
	private int eno;
	private String ename;
	private String hiredate;
	private int salary;
	private String jumin;
	private String id;
	public MgrVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MgrVO(int eno, String ename, String hiredate, int salary, String jumin, String id) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.hiredate = hiredate;
		this.salary = salary;
		this.jumin = jumin;
		this.id = id;
	}
	public int getEno() {
		return eno;
	}
	public void setEno(int eno) {
		this.eno = eno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getHiredate() {
		return hiredate;
	}
	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getJumin() {
		return jumin;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}
