package com.tcservice;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.validation.constraints.*;

import com.tcservice.dao.CenterDao;
import com.tcservice.model.Center;
import com.tcservice.view.CenterView;

// case sensitive
@Path("/centers")
public class CenterService {
	CenterDao centerDao = new CenterDao();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCenters() {
		try{
			return Response.status(200).entity(centerDao.getAllCenters()).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCenterById(@PathParam("id") int id) {
		try{
			CenterView center = centerDao.getCenterById(id);
			if(center!=null){
				return Response.status(200).entity(center).build();
			}
			return Response.status(404).entity("No such resource!").build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response insertCenter(final Center center) {
		try{
			System.out.println("............. insert 1");
			return Response.status(201).entity(centerDao.insertCenter(center)).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public Response updateCenter(final Center center) {
		try{
			if(centerDao.getCenterById(center.Id)==null){
				return Response.status(404).entity("No such resource!").build();
			}
			centerDao.deleteCenter(center.Id);
			return Response.status(200).entity(centerDao.insertCenter(center)).build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
    }

	@DELETE
	@Path("/{id}")
	public Response deleteCenter(@PathParam("id") int id) {
		try{
			if(centerDao.getCenterById(id)==null){
				return Response.status(404).entity("No such resource!").build();
			}
			centerDao.deleteCenter(id);
			return Response.status(202).entity("Resource deleted successfully!").build();
		}catch(Exception ex){
			return Response.status(500).entity(ex.getMessage()).build();
		}
	}
}