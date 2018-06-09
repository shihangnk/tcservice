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

public class CenterDao extends DaoBase {
	public List<Center> getAllCenters() throws Exception{
		List<Center> list = new LinkedList<Center>();
		
		sql = "select * from centers";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			for (; rs.next();) {
				Center center = new Center();

				center.Id = rs.getInt("Id");
				center.Name = rs.getString("Name");
				center.StreetAddress = rs.getString("StreetAddress");
				center.CenterTypeId = rs.getInt("CenterTypeId");
				center.CenterTypeValue = rs.getString("CenterTypeValue");

				list.add(center);
			}
		} catch (Exception ex) {
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		} finally {
			releaseConnection();
		}

		return list;
	}
	
	public Center getCenterById(int id) throws Exception{
		sql = "select * from centers where id="+id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			for (; rs.next();) {
				Center center = new Center();

				center.Id = rs.getInt("Id");
				center.Name = rs.getString("Name");
				center.StreetAddress = rs.getString("StreetAddress");
				center.CenterTypeId = rs.getInt("CenterTypeId");
				center.CenterTypeValue = rs.getString("CenterTypeValue");

				return center;
			}
			return null;
		} catch (Exception ex) {
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		} finally {
			releaseConnection();
		}
	}
	
	public Center insertCenter(Center center) throws Exception{
		sql = "insert into Centers values("+center.Id+", '"+center.Name+"', '"+center.StreetAddress+"', "+center.CenterTypeId+", '"+center.CenterTypeValue+"')";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
			
			return getCenterById(center.Id);
		} catch (Exception ex) {
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		} finally {
			releaseConnection();
		}
	}
	
	public void deleteCenter(int id)throws Exception{
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			sql = "delete centers where id="+id;
			stmt.executeUpdate(sql);
		}catch(Exception ex){
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		}finally{
			releaseConnection();
		}
	}
}
