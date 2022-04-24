package com.interfinance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
//@AllArgsConstructor
@Entity
@Table(name="shortings")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shortings {

	 
	 // @GeneratedValue( strategy = GenerationType.AUTO )
	 // private Long id;
	@Id
	private String isin;
    private String issuerName;
   
	@OneToMany(
	            cascade=CascadeType.ALL,
	            orphanRemoval=true,
	            fetch = FetchType.LAZY)
	@JoinColumn(name="isin_id")
    private List<Events>  events = new ArrayList<>() ;
	
	
	
	public Shortings() {
		
	}
	
	
	public Shortings(String isin, String issuerName, List<Events> events) {
		super();
		this.isin = isin;
		this.issuerName = issuerName;
		this.events = events;
	}


	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	public String getIssuerName() {
		return issuerName;
	}
	public void setIssuerName(String issuerName) {
		this.issuerName = issuerName;
	}
	public List<Events> getEvents() {
		return events;
	}
	public void setEvents(List<Events> events) {
		this.events = events;
	}

	
	

	
    
    

}
