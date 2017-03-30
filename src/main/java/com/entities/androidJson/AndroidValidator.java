package com.entities.androidJson;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class AndroidValidator implements Serializable{
	/**
	 * 
	 */
	

	private static final long serialVersionUID = -7028165331505361043L;
	private String  value ;
    private String err ;
    
    
	public AndroidValidator(String value, String err) {
		super();
		this.value = value;
		this.err = err;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getErr() {
		return err;
	}
	public void setErr(String err) {
		this.err = err;
	}
	
    

    

}
