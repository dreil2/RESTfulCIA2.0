package com.conygre.training.services;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Remote;
import javax.jws.WebService;

import org.jboss.as.quickstarts.html5_mobile.model.Member;

import com.conygre.training.entities.CompactDisc;
//@WebService
@Local
public interface CompactDiscService {

	public List<CompactDisc> getCatalog() ;
	public CompactDisc getDiscById(int id);
	public void addToCatalog(CompactDisc disc);
	
}
