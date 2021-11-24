package com.sist.vo;

import java.util.Date;

public class ReserveVO {
	private String theaterName;
	private int cinemaNo;
	private String title;
	private Date date;
	private int seatNo;
	private int price;
	
	public ReserveVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReserveVO(String theaterName, int cinemaNo, String title, Date date, int seatNo, int price) {
		super();
		this.theaterName = theaterName;
		this.cinemaNo = cinemaNo;
		this.title = title;
		this.date = date;
		this.seatNo = seatNo;
		this.price = price;
	}
	public String getTheaterName() {
		return theaterName;
	}
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}
	public int getCinemaNo() {
		return cinemaNo;
	}
	public void setCinemaNo(int cinemaNo) {
		this.cinemaNo = cinemaNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
