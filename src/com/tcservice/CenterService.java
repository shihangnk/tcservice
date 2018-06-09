package com.tcservice;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.validation.constraints.*;

import com.tcservice.dao.CenterDao;
import com.tcservice.model.Center;

// case sensitive
@Path("/centers")
public class CenterService {
	CenterDao centerDao = new CenterDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Center> getUsers() {
		return centerDao.getAllCenters();
	}

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Center getMsg(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		return new Center(2);
	}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    @NotNull(message = "{contact.already.exist}")
    public Response addContact(final Center center) {
    	center.setId(center.getId()+1);
    	return Response.status(201).entity(center).build();
    }

}