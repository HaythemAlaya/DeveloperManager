package com.entities.androidJson;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class AndroidComponent implements Serializable {
 
	private static final long serialVersionUID = -1022564963519472753L;
	private String key;
    private String type;
    private String hint;
    private String label;
    private List<String> values ;
    private List<AndroidOption> options = null ;
    private AndroidValidator v_required ;
    private AndroidValidator v_min_length ;
    private AndroidValidator v_max_length;
    private AndroidValidator v_email ;
    private AndroidValidator v_regex;
    
  
public AndroidComponent() {
	super();
	// TODO Auto-generated constructor stub
}


public String getKey() {
	return key;
}


public void setKey(String key) {
	this.key = key;
}


public String getType() {
	return type;
}


public void setType(String type) {
	this.type = type;
}


public String getHint() {
	return hint;
}


public void setHint(String hint) {
	this.hint = hint;
}


public List<String> getValues() {
	return values;
}


public void setValues(List<String> values) {
	this.values = values;
}


public List<AndroidOption> getOptions() {
	return options;
}


public void setOptions(List<AndroidOption> options) {
	this.options = options;
}


public AndroidValidator getV_required() {
	return v_required;
}


public void setV_required(AndroidValidator v_required) {
	this.v_required = v_required;
}


public AndroidValidator getV_min_length() {
	return v_min_length;
}


public void setV_min_length(AndroidValidator v_min_length) {
	this.v_min_length = v_min_length;
}


public AndroidValidator getV_max_length() {
	return v_max_length;
}


public void setV_max_length(AndroidValidator v_max_length) {
	this.v_max_length = v_max_length;
}


public AndroidValidator getV_email() {
	return v_email;
}


public void setV_email(AndroidValidator v_email) {
	this.v_email = v_email;
}


public AndroidValidator getV_regex() {
	return v_regex;
}


public void setV_regex(AndroidValidator v_regex) {
	this.v_regex = v_regex;
}


public String getLabel() {
	return label;
}


public void setLabel(String label) {
	this.label = label;
}


  
  
}
