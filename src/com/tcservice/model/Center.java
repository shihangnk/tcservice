package com.tcservice.model;

import java.io.Serializable;  

public class Center {
	public int Id;
	public String Name;
	public String StreetAddress;
	public int CenterTypeId;
	public String CenterTypeValue;
	
/*	public void setId(int id_){
		id = id_;
	}
	
	public int getId(){
		return id;
	}
*/	
	public Center(){}
	
	public Center(int id_, String name, String streetAddress, int centerTypeId, String centerTypeValue){
		Id = id_;
		Name = name;
		StreetAddress = streetAddress;
		CenterTypeId = centerTypeId;
		CenterTypeValue = centerTypeValue;
	}
}
