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
			return Response.status(500).entity(centerDao.getAllCenters()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getSingleCenter(@PathParam("id") int id) {
		try{
			Center center = centerDao.getCenterById(id);
			if(center!=null){
				return Response.status(200).entity(center).build();
			}
			return Response.status(404).entity("Not found").build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
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