package com.interfinance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@ToString
@Data
@Entity
@Table(name="events")
public class Events {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long event_id;
	private Date date;
	private String shortPercent;
	private String shares;
	
	
	@ManyToOne
	@JoinColumn(name="isin_id")
	private Shortings shortings;
	
	@JsonBackReference
	@OneToMany(
            cascade=CascadeType.ALL,
            orphanRemoval=true
            )
	@JoinColumn(name="event_id")
	private List<ActivePositions> activePositions= new ArrayList<ActivePositions>();
	
	  public Events() {
			
		}

	public Events(Long id, Date date, String shortPercent, String shares, Shortings shortings,
			List<ActivePositions> activePositions) {
		super();
		this.event_id = id;
		this.date = date;
		this.shortPercent = shortPercent;
		this.shares = shares;
		this.shortings = shortings;
		this.activePositions = activePositions;
	}

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
	

	public Shortings getShortings() {
		return shortings;
	}

	public void setShortings(Shortings shortings) {
		this.shortings = shortings;
	}

	public List<ActivePositions> getActivePositions() {
		return activePositions;
	}

	public void setActivePositions(List<ActivePositions> activePositions) {
		this.activePositions = activePositions;
	}

	public Long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}

	
	    
	    

}
