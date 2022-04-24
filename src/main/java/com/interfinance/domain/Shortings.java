package com.interfinance.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="shortings")
public class Shortings {

	@Id
	private String isin;
    private String issuerName;
    @JsonBackReference
	@OneToMany(targetEntity = Events.class,cascade=CascadeType.ALL,
	            fetch = FetchType.EAGER
	           )
    @JoinColumn(name ="isin_id",referencedColumnName = "isin")
    private List<Events>  events  ;
	
	
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
