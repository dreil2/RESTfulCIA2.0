package com.conygre.training.services;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;




import org.jboss.as.quickstarts.html5_mobile.model.Member;

import com.conygre.training.dao.CompactDiscDAO;
import com.conygre.training.dao.jpa.JPA;
import com.conygre.training.entities.CompactDisc;
@Stateless
//@WebService(endpointInterface="com.conygre.training.services.CompactDiscService")
@Local(CompactDiscService.class)

public class CompactDiscServiceEJB implements CompactDiscService {
	
	private CompactDiscDAO dao;
	
	@Inject
	public void setDao(@JPA CompactDiscDAO dao) {
		this.dao = dao;
	}

	public void addToCatalog(CompactDisc disc) {
		if (!dao.getAllDiscs().contains(disc))
			dao.addCompactDisc(disc);
	}
	
	public List<CompactDisc> getCatalog() {
		List<CompactDisc> cds = dao.getAllDiscs();
		for (CompactDisc cd : cds) {
			System.out.println(cd.getTitle());
		}
		
		return cds;
	}

	public CompactDisc getDiscById(int id) {
		// TODO Auto-generated method stub
		CompactDisc cd = dao.findById(id);
		return cd;
	}



}
