package com.interfinance.model;

import java.util.Date;

public class EventsModel {
	
	private Date date;
	private String shortPercent;
	private String shares;
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getShortPercent() {
		return shortPercent;
	}
	public void setShortPercent(String shortPercent) {
		this.shortPercent = shortPercent;
	}
	public String getShares() {
		return shares;
	}
	public void setShares(String shares) {
		this.shares = shares;
	}
	
	

}
