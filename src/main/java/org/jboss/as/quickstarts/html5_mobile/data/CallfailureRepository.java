package org.jboss.as.quickstarts.html5_mobile.data;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import com.conygre.training.entities.Callfailure;

@ApplicationScoped
public class CallfailureRepository {

    //@Inject
    @PersistenceContext(unitName="conygreChapter8")
    private EntityManager em;

    public Callfailure findByBaseDataID(int baseDataID) {
        return em.find(Callfailure.class, baseDataID);
    }

    public Callfailure findByIMSI(String iMSI) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Callfailure> criteria = cb.createQuery(Callfailure.class);
        Root<Callfailure> callfailure = criteria.from(Callfailure.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(callfailure).where(cb.equal(callfailure.get("iMSI"), iMSI));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Callfailure> findAllOrderedByIMSI() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Callfailure> criteria = cb.createQuery(Callfailure.class);
        Root<Callfailure> callfailure = criteria.from(Callfailure.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(callfailure).orderBy(cb.asc(callfailure.get("iMSI")));
        return em.createQuery(criteria).getResultList();
    }
    
    public List<Callfailure> findAllBetween(Date startDateTime, Date endDateTime) {
   		List<Callfailure> callFailures = (List<Callfailure>) em
				.createNamedQuery("CallFailure.findAllBetween")
				.setParameter("startDateTime", startDateTime)
				.setParameter("endDateTime", endDateTime).getResultList();
		if (callFailures.size() == 0)
			return null;
		else
			return callFailures;
    }
    
    public List<Callfailure> findCauseCode_EventIDByIMSI(String IMSI) {
		List<Callfailure> callfailures = (List<Callfailure>) 
				em.createNamedQuery("Callfailure.findByIMSI").setParameter("IMSI", IMSI).getResultList();
		if (callfailures.size() == 0)
			return null;
		else
			return callfailures;
	}
    
    
}
