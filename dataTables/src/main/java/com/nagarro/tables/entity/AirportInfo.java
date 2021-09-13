package com.nagarro.tables.entity;


import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AirportInfo {
	@Id
	@Column(name="airportId")
	@GeneratedValue(strategy=GenerationType.AUTO)
private long AirportId;
private String city;
private String country;
private String iata;
private String icao;
private String timezone;
private String title;
private Date validFrom;
private Date validTo;
public long getAirportId() {
	return AirportId;
}
public void setAirportId(long airportId) {
	AirportId = airportId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}
public String getIata() {
	return iata;
}
public void setIata(String iata) {
	this.iata = iata;
}
public String getIcao() {
	return icao;
}
public void setIcao(String icao) {
	this.icao = icao;
}
public String getTimezone() {
	return timezone;
}
public void setTimezone(String timezone) {
	this.timezone = timezone;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Date getValidFrom() {
	return validFrom;
}
public void setValidFrom(Date validFrom) {
	this.validFrom = validFrom;
}
public Date getValidTo() {
	return validTo;
}
public void setValidTo(Date validTo) {
	this.validTo = validTo;
}

}
