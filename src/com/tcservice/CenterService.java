package com.tcservice;

import java.util.List; 

import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  

import com.tcservice.dao.CenterDao;
import com.tcservice.model.Center;

@Path("/CenterService") 

public class CenterService {  
   CenterDao centerDao = new CenterDao();  
   @GET 
   @Path("/centers") 
   @Produces(MediaType.APPLICATION_JSON) 
   public List<Center> getUsers(){ 
      return centerDao.getAllCenters(); 
   }  
}