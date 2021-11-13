package com.sist.vo;

public class DeptEmpVO {
	private int eno;
	private String ename;
	private int salary;
	private int comm;
	private int totalsalary = salary + comm; //�Ǽ��ɾ�
	private int dno;
	private String dname;
	public DeptEmpVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DeptEmpVO(int eno, String ename, int salary, int comm, int totalsalary, int dno, String dname) {
		super();
		this.eno = eno;
		this.ename = ename;
		this.salary = salary;
		this.comm = comm;
		this.totalsalary = totalsalary;
		this.dno = dno;
		this.dname = dname;
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
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public int getComm() {
		return comm;
	}
	public void setComm(int comm) {
		this.comm = comm;
	}
	public int getDno() {
		return dno;
	}
	public void setDno(int dno) {
		this.dno = dno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}

	public int getTotalsalary() {
		return totalsalary;
	}

	public void setTotalsalary(int totalsalary) {
		this.totalsalary = totalsalary;
	}
	
}
