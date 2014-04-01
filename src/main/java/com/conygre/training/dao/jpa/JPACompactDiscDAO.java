package com.conygre.training.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.conygre.training.dao.CompactDiscDAO;
import com.conygre.training.entities.CompactDisc;

@JPA
public class JPACompactDiscDAO implements CompactDiscDAO {

	@PersistenceContext(unitName="conygreChapter8")
	private EntityManager em;
	
	public void addCompactDisc(CompactDisc disc) {
	
		Query query = em.createQuery("select cd from CompactDisc cd");
		List<CompactDisc> discs = query.getResultList(); 
		if (!discs.contains(disc))
			em.persist(disc);		
	}


	public CompactDisc getCompactDiscByTitle(String title) {
		// TODO Auto-generated method stub		
		Query query  = em.createQuery("from CompactDisc cd where cd.title = :title");
		query.setParameter("title", title);
		// remember we are assuming only one album has any particular title
		// could have used getSingleResult() but this an exception if there is more than one result
		List<CompactDisc> result = query.getResultList();
		return result.get(0);
	}

	public List<CompactDisc> getDiscsByArtist(String artist) {
		// TODO Auto-generated method stu
		Query query  = em.createQuery("from CompactDisc cd where cd.artist = :artist");
		query.setParameter("artist", artist);
		List<CompactDisc> result = query.getResultList();
		return result;
	}

	public List<CompactDisc> getAllDiscs() {
		// TODO Auto-generated method stub
		// not the best place to start at TX but nevermind for now!
		Query query = em.createQuery("select distinct cd from CompactDisc cd left join fetch cd.trackTitles"); //join fetch cd.trackTitles");
		List<CompactDisc> discs = query.getResultList(); 
		System.out.println(discs.size());
		return discs;
		
	}
	
	public CompactDisc findById(int id) {
		return em.find(CompactDisc.class, id);
	}

}
