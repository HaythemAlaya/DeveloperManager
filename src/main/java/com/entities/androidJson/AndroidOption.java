package com.entities.androidJson;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize

public class AndroidOption implements Serializable{

	/**
	 * 
*/
	private static final long serialVersionUID = 1L;
	private String key;
	private String text;
	private	String value;
	
	
	public AndroidOption(String key, String text, String value) {
		super();
		this.key = key;
		this.text = text;
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}
