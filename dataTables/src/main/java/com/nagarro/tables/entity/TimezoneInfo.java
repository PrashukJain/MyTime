package com.nagarro.tables.entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TimezoneInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long timezoneId;
private String utc;
private Date validFrom;
private Date validTo;
public Long getTimezoneId() {
	return timezoneId;
}
public void setTimezoneId(Long timezoneId) {
	this.timezoneId = timezoneId;
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
public String getUtc() {
	return utc;
}
public void setUtc(String utc) {
	this.utc = utc;
}
}
