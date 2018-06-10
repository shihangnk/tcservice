package com.tcservice.dao;

import java.util.LinkedList;
import java.util.List;

import com.tcservice.model.Center;
import com.tcservice.view.CenterView;

public class AppointmentDao extends DaoBase {
	
	private final String selectSql = "select t1.Id Id, t1.Name name, t1.StreetAddress StreetAddress, t2.Name CenterTypeValue from centers t1 left join CenterTypes t2 on t1.CenterTypeId=t2.Id";

	public List<CenterView> getAllCenters() throws Exception{
		List<CenterView> list = new LinkedList<CenterView>();
		
		sql = selectSql;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			for (; rs.next();) {
				CenterView center = new CenterView();

				center.Id = rs.getInt("Id");
				center.Name = rs.getString("Name");
				center.StreetAddress = rs.getString("StreetAddress");
				center.CenterTypeValue = rs.getString("CenterTypeValue");

				list.add(center);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		} finally {
			releaseConnection();
		}

		return list;
	}
	
	public CenterView getCenterById(int id) throws Exception{
		sql = selectSql + " where Id="+id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			for (; rs.next();) {
				CenterView center = new CenterView();

				center.Id = rs.getInt("Id");
				center.Name = rs.getString("Name");
				center.StreetAddress = rs.getString("StreetAddress");
				center.CenterTypeValue = rs.getString("CenterTypeValue");

				return center;
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		} finally {
			releaseConnection();
		}
	}
	
	public CenterView insertCenter(Center center) throws Exception{
		sql = "insert into Centers values("+center.Id+", '"+center.Name+"', '"+center.StreetAddress+"', "+center.CenterTypeId+")";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			int ret = stmt.executeUpdate(sql);
			System.out.println(".............. inserted "+ret);
			return getCenterById(center.Id);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		} finally {
			releaseConnection();
		}
	}
	
	public void deleteCenter(int id)throws Exception{
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			sql = "delete from centers where id="+id;
			stmt.executeUpdate(sql);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		}finally{
			releaseConnection();
		}
	}
}
