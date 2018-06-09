package com.tcservice;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;

import com.tcservice.dao.CenterDao;
import com.tcservice.model.Center;

// case sensitive
@Path("/centerservice")
public class CenterService {
	CenterDao centerDao = new CenterDao();

	@GET
	@Path("/centers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Center> getUsers() {
		return centerDao.getAllCenters();
	}

	@GET
	@Path("/centers/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Center getMsg(@PathParam("param") String msg) {

		String output = "Jersey say : " + msg;
		return new Center(2);
	}
}