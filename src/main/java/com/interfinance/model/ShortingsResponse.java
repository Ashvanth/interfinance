
package com.interfinance.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"isin",
"issuerName",
"events"
})
public class ShortingsResponse {

@JsonProperty("isin")
private String isin;
@JsonProperty("issuerName")
private String issuerName;
@JsonProperty("events")
private List<Events> events = null;

@JsonProperty("isin")
public String getIsin() {
return isin;
}

@JsonProperty("isin")
public void setIsin(String isin) {
this.isin = isin;
}

@JsonProperty("issuerName")
public String getIssuerName() {
return issuerName;
}

@JsonProperty("issuerName")
public void setIssuerName(String issuerName) {
this.issuerName = issuerName;
}

@JsonProperty("events")
public List<Events> getEvents() {
return events;
}

@JsonProperty("events")
public void setEvents(List<Events> events) {
this.events = events;
}

}