package com.interfinance.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonPOJOBuilder
public class ShortingsModel {
	
	
	private String isin;
    private String issuerName;
    
    @Autowired
    private List<EventsModel> EventsModel;

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

	public List<EventsModel> getEventsModel() {
		return EventsModel;
	}

	public void setEventsModel(List<EventsModel> eventsModel) {
		EventsModel = eventsModel;
	}
    

}
