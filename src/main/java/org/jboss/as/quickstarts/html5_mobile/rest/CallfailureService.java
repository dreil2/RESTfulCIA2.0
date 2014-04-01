/**
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.as.quickstarts.html5_mobile.rest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateful;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.as.quickstarts.html5_mobile.data.CallfailureRepository;
import org.jboss.as.quickstarts.html5_mobile.service.MemberRegistration;

import com.conygre.training.entities.Callfailure;


/**
 * JAX-RS Example
 * <p/>
 * This class produces a RESTful service to read/write the contents of the members table.
 */
@Path("/callfailures")
@RequestScoped
@Stateful
public class CallfailureService {
    @Inject
    private Logger log;

    @Inject
    private Validator validator;

    @Inject
    private CallfailureRepository repository;

    @Inject
    MemberRegistration upload;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Callfailure> listAllFailureclasses() {
        return repository.findAllOrderedByIMSI();
    }

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces(MediaType.APPLICATION_JSON)
    public Callfailure lookupFailureclassById(@PathParam("id") int id) {
    	Callfailure callfailure = repository.findByBaseDataID(id);
        if (callfailure == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return callfailure;
    }
    
    @GET
    @Path("/imsiQuery/{imsi}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Callfailure> findCauseCode_EventIDByIMSI(@PathParam("imsi") String IMSI) {

  	    	
    	List<Callfailure> callfailures = repository.findCauseCode_EventIDByIMSI(IMSI);
        if (callfailures == null) {
        	throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return callfailures;
    }  
    
//    @GET
////    @Path("{startDateTimeString:[1900-2100]-[01-12]-[01-31]'T'[00-23]:[00-59]}/{endDateTimeString:[1900-2100]-[01-12]-[01-31]'T'[00-23]:[00-59]}")
//    @Path("{startDateTimeString}/{endDateTimeString}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public List<Callfailure> lookupFailureclassBetweenDates(
//    		@PathParam("startDateTime") String startDateTimeString,
//    		@PathParam("endDateTime") String endDateTimeString) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
//		Date startDateTime=null, endDateTime=null;
//		
//		try {
//			startDateTime = sdf.parse(startDateTimeString);
//	    	endDateTime = sdf.parse(endDateTimeString);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//    	    	
//    	List<Callfailure> callfailures = repository.findAllBetween(startDateTime, endDateTime);
//        if (callfailures == null) {
//        	throw new WebApplicationException(Response.Status.NOT_FOUND);
//        }
//        return callfailures;
//    }  
    
    

}
