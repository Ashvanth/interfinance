package com.interfinance.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="activePositions")
@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivePositions {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	private Date Date;
	private String ShortPercent;
	private String Shares;
	private String positionHolder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="event_id")
	private Events events;

	  public ActivePositions() {
			
		}


	public ActivePositions(Long id, Date apDate, String apShortPercent, String apShares, String positionHolder,
			Events events) {
		super();
		this.id = id;
		this.Date = apDate;
		this.ShortPercent = apShortPercent;
		this.Shares = apShares;
		this.positionHolder = positionHolder;
		this.events = events;
	}


	


	public Date getDate() {
		return Date;
	}


	public void setDate(Date date) {
		Date = date;
	}


	public String getShortPercent() {
		return ShortPercent;
	}


	public void setShortPercent(String shortPercent) {
		ShortPercent = shortPercent;
	}


	public String getShares() {
		return Shares;
	}


	public void setShares(String shares) {
		Shares = shares;
	}


	public String getPositionHolder() {
		return positionHolder;
	}


	public void setPositionHolder(String positionHolder) {
		this.positionHolder = positionHolder;
	}


	public Events getEvents() {
		return events;
	}


	public void setEvents(Events events) {
		this.events = events;
	}

}
