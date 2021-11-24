package com.sist.vo;

public class OrdersVO {
	private String bookname;
	private int cnt;
	
	public OrdersVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrdersVO(String bookname, int cnt) {
		super();
		this.bookname = bookname;
		this.cnt = cnt;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

}
