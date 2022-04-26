package com.interfinance.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"date",
"shortPercent",
"shares",
"activePositions"
})
public class Events {

@JsonProperty("date")
private String date;
@JsonProperty("shortPercent")
private Float shortPercent;
@JsonProperty("shares")
private Integer shares;
@JsonProperty("activePositions")
private List<ActivePositions> activePositions = null;

@JsonProperty("date")
public String getDate() {
return date;
}

@JsonProperty("date")
public void setDate(String date) {
this.date = date;
}

@JsonProperty("shortPercent")
public Float getShortPercent() {
return shortPercent;
}

@JsonProperty("shortPercent")
public void setShortPercent(Float shortPercent) {
this.shortPercent = shortPercent;
}

@JsonProperty("shares")
public Integer getShares() {
return shares;
}

@JsonProperty("shares")
public void setShares(Integer shares) {
this.shares = shares;
}

@JsonProperty("activePositions")
public List<ActivePositions> getActivePositions() {
return activePositions;
}

@JsonProperty("activePositions")
public void setActivePositions(List<ActivePositions> activePositions) {
this.activePositions = activePositions;
}

}