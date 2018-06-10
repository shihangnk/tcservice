package com.tcservice;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.validation.constraints.*;

import com.tcservice.dao.AppointmentDao;
import com.tcservice.model.Appointment;
import com.tcservice.view.AppointmentView;
import com.tcservice.view.CenterView;

// case sensitive
@Path("/appointments")
public class AppointmentService {
	AppointmentDao appointmentDao = new AppointmentDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllAppointments() {
		try{
			return Response.status(200).entity(appointmentDao.getAllAppointments()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAppointmentById(@PathParam("id") int id) {
		try{
			AppointmentView appointment = appointmentDao.getAppointmentById(id);
			if(appointment!=null){
				return Response.status(200).entity(appointment).build();
			}
			return Response.status(404).entity("No such resource!").build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response insertAppointment(final Appointment appointment) {
		try{
			return Response.status(201).entity(appointmentDao.insertAppointment(appointment)).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateAppointment(final Appointment appointment) {
		try{
			if(appointmentDao.getAppointmentById(appointment.Id)==null){
				return Response.status(404).entity("No such resource!").build();
			}
			appointmentDao.deleteAppointment(appointment.Id);
			return Response.status(200).entity(appointmentDao.insertAppointment(appointment)).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
    }

	@DELETE
	@Path("/{id}")
	public Response deleteAppointment(@PathParam("id") int id) {
		try{
			if(appointmentDao.getAppointmentById(id)==null){
				return Response.status(404).entity("No such resource!").build();
			}
			appointmentDao.deleteAppointment(id);
			return Response.status(202).entity("Resource deleted successfully!").build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}
}