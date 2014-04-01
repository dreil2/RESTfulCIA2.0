package com.conygre.training.services;

import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;


@Path("/orders/")
//@Interceptors(CallAudit.class)
@Stateless
public class SimpleREST {
	
	@GET
    @Path("{name}/")
    @Produces({"application/xml","application/json"})
    public String sayHello(@PathParam("name") String name){
       return "hello " + name;
    }
	

}
