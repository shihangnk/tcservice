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
	public Response getAllCenters() {
		try{
//			return centerDao.getAllCenters();
			return Response.status(500).entity(centerDao.getAllCenters()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleCenter(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		return Response.ok().entity(new Center(2, "name", "address", 1, "5")).build();
	}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response addCenter(final Center center) {
    	center.Id = center.Id+1;
    	return Response.status(201).entity(center).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateCenter(final Center center) {
    	center.Id = center.Id+1;
    	return Response.status(200).entity(center).build();
    }

	@DELETE
	@Path("/{param}")
	public Response deleteCenter(@PathParam("param") String msg) {
		String output = "Jersey say : " + msg;
		return Response.status(202).entity("Element deleted successfully!").build();
	}

}