package com.interfinance.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor
//@Embeddable
@Entity
//@Table(name="events")
@Table
@JsonIgnoreProperties(ignoreUnknown = true)
public class Events {
	
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	private Long id;
	private Date date;
	private String shortPercent;
	private String shares;
	
	@ManyToOne
	@JoinColumn(name="isin_id")
	private Shortings shortings;
	
	@OneToMany(
            cascade=CascadeType.ALL,
            orphanRemoval=true,
            fetch = FetchType.LAZY)
	@JoinColumn(name="isin_id")
	private List<ActivePositions> activePositions= new ArrayList<ActivePositions>();
	
	  public Events() {
			
		}

	public Events(Long id, Date date, String shortPercent, String shares, Shortings shortings,
			List<ActivePositions> activePositions) {
		super();
		this.id = id;
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

	
	    
	    

}
