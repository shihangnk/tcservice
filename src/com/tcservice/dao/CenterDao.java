package com.tcservice.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.tcservice.model.Center;

public class CenterDao {
	public List<Center> getAllCenters() {
		List<Center> centerList = new LinkedList<Center>();
		
		for(int i = 0; i< 5; i++){
			centerList.add(new Center());
		}
		return centerList;
	}

	private void saveCenterList(List<Center> centerList) {
		for(Center item : centerList){
			System.out.println("................ "+item.Id);
		}
	}
}
