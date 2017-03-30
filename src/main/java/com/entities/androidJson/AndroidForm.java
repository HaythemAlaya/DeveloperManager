package com.entities.androidJson;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.entities.JpaConverterJson;

import net.minidev.json.annotate.JsonIgnore;
@Entity
public class AndroidForm implements Serializable
{
	 @Id
	  @GeneratedValue
	  private Long Id;
	 @JsonIgnore
      private Step step1  ;


public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


public Step getStep1() {
	return step1;
}




public AndroidForm() {
	super();
	step1 =  new Step();
}


public void setStep1(Step step1) {
	this.step1 = step1;
}

public class Step implements Serializable
{
	
private List<AndroidComponent> fields = null;
private String title;
private String next;
private final static long serialVersionUID = -1893006574351601807L;

public List<AndroidComponent> getFields() {
return fields;
}

public void setFields(List<AndroidComponent> fields) {
this.fields = fields;
}

public String getTitle() {
return title;
}

public void setTitle(String title) {
this.title = title;
}

public String getNext() {
return next;
}

public void setNext(String next) {
this.next = next;
}

public Long getId() {
	return Id;
}

public void setId(Long id) {
	Id = id;
}

}
}
