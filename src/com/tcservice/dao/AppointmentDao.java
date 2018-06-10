package com.tcservice.dao;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.tcservice.model.Appointment;
import com.tcservice.view.AppointmentView;
import com.tcservice.view.CenterView;

public class AppointmentDao extends DaoBase {

	private final String selectSql = "select t1.Id Id, T1.ClientFullName ClientFullName,"
			+ " t1.AppointmentDate AppointmentDate, t2.Id CenterId, t2.Name Name,"
			+ " t2.StreetAddress StreetAddress, t3.Name CenterTypeValue "
			+ " from Appointments t1 left join Centers t2 on t1.CenterId=t2.Id "
			+ " left join CenterTypes t3 on t2.CenterTypeId=t3.Id";

	public List<AppointmentView> getAllAppointments() throws Exception {
		List<AppointmentView> list = new LinkedList<AppointmentView>();

		sql = selectSql + " order by t1.Id";
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			for (; rs.next();) {
				list.add(getAppointmentViewFromRs());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   [" + sql + "]");
		} finally {
			releaseConnection();
		}

		return list;
	}

	private AppointmentView getAppointmentViewFromRs() throws SQLException {
		AppointmentView appointment = new AppointmentView();

		appointment.Id = rs.getInt("Id");
		appointment.ClientFullName = rs.getString("ClientFullName");
		appointment.Date = rs.getString("AppointmentDate");

		CenterView center = new CenterView();
		center.Id = rs.getInt("CenterId");
		center.Name = rs.getString("Name");
		center.StreetAddress = rs.getString("StreetAddress");
		center.CenterTypeValue = rs.getString("CenterTypeValue");
		appointment.Center = center;
		return appointment;
	}

	public AppointmentView getAppointmentById(int id) throws Exception {
		sql = selectSql + " where t1.Id=" + id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			for (; rs.next();) {
				return getAppointmentViewFromRs();
			}
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   [" + sql + "]");
		} finally {
			releaseConnection();
		}
	}

	public AppointmentView insertAppointment(Appointment appointment) throws Exception{
		sql = "insert into Appointments(ClientFullName, AppointmentDate, CenterId) values('"+appointment.ClientFullName+"', '"+appointment.Date+"', "+appointment.CenterId+")";
		int newId=0;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			int ret = stmt.executeUpdate(sql);
			System.out.println(".............. inserted "+ret);
			
			sql = "select max(Id) Id from Appointments;";
			rs = stmt.executeQuery(sql);
			for (; rs.next();) {
				newId = rs.getInt("Id");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		} finally {
			releaseConnection();
		}
		try{
			return getAppointmentById(newId);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		}
	}

	public AppointmentView updateAppointment(Appointment appointment) throws Exception{
		sql = "update Appointments set ClientFullName='"+appointment.ClientFullName+"', AppointmentDate='"+appointment.Date+"', CenterId="+appointment.CenterId+" where Id="+appointment.Id;
		try {
			conn = getConnection();
			stmt = conn.createStatement();
			int ret = stmt.executeUpdate(sql);
			System.out.println(".............. inserted "+ret +"["+sql+"]");
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		} finally {
			releaseConnection();
		}
		try{
			return getAppointmentById(appointment.Id);
		}catch(Exception ex){
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   ["+sql+"]");
		}
	}

	public void deleteAppointment(int id) throws Exception {
		try {
			conn = getConnection();
			stmt = conn.createStatement();

			sql = "delete from appointments where id=" + id;
			stmt.executeUpdate(sql);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new Exception(ex.getMessage() + "   [" + sql + "]");
		} finally {
			releaseConnection();
		}
	}
}
