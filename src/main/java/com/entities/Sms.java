package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.Null;

@Entity
public class Sms implements Serializable {
  @Id
  @GeneratedValue
  private Long Id;
  @Lob 
  private String msg;
  private String phone;
  private Boolean state;
  @Null
  private String created_date;
  @Null
  private String send_date;
  private String owner;
  private String car_number;
  
public Sms() {
	super();
	// TODO Auto-generated constructor stub
}

public Sms(String msg, String phone, Boolean state, String created_date, String send_date, String owner,
		String car_number) {
	super();
	this.msg = msg;
	this.phone = phone;
	this.state = state;
	this.created_date = created_date;
	this.send_date = send_date;
	this.owner = owner;
	this.car_number = car_number;
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

public String getMsg() {
	return msg;
}

public void setMsg(String msg) {
	this.msg = msg;
}

public String getPhone() {
	return phone;
}

public void setPhone(String phone) {
	this.phone = phone;
}

public Boolean getState() {
	return state;
}

public void setState(Boolean state) {
	this.state = state;
}

public String getCreated_date() {
	return created_date;
}

public void setCreated_date(String created_date) {
	this.created_date = created_date;
}

public String getSend_date() {
	return send_date;
}

public void setSend_date(String send_date) {
	this.send_date = send_date;
}

public String getOwner() {
	return owner;
}

public void setOwner(String owner) {
	this.owner = owner;
}

public String getCar_number() {
	return car_number;
}

public void setCar_number(String car_number) {
	this.car_number = car_number;
}
  
  
}
