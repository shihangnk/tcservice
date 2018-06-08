package com.tcservice.model;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "center") 

public class Center {
	private int id;
	
	@XmlElement
	public void setId(int id_){
		id = id_;
	}
	
	public int getId(){
		return id;
	}
	
	public Center(int id_){
		id = id_;
	}
}
