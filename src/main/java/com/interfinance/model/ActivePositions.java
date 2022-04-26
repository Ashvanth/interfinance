package com.interfinance.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"date",
"shortPercent",
"shares",
"positionHolder"
})
public class ActivePositions {

@JsonProperty("date")
private String date;
@JsonProperty("shortPercent")
private Float shortPercent;
@JsonProperty("shares")
private Integer shares;
@JsonProperty("positionHolder")
private String positionHolder;

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

@JsonProperty("positionHolder")
public String getPositionHolder() {
return positionHolder;
}

@JsonProperty("positionHolder")
public void setPositionHolder(String positionHolder) {
this.positionHolder = positionHolder;
}

}

