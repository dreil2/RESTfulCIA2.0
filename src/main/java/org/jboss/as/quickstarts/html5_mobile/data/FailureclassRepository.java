package org.jboss.as.quickstarts.html5_mobile.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.conygre.training.entities.Failureclass;

@ApplicationScoped
public class FailureclassRepository {

    //@Inject
    @PersistenceContext(unitName="conygreChapter8")
    private EntityManager em;

    public Failureclass findById(int id) {
        return em.find(Failureclass.class, id);
    }

    public Failureclass findByDescription(String description) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Failureclass> criteria = cb.createQuery(Failureclass.class);
        Root<Failureclass> failureclass = criteria.from(Failureclass.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(failureclass).where(cb.equal(failureclass.get("description"), description));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Failureclass> findAllOrderedByDescription() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Failureclass> criteria = cb.createQuery(Failureclass.class);
        Root<Failureclass> failureclass = criteria.from(Failureclass.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(failureclass).orderBy(cb.asc(failureclass.get("description")));
        return em.createQuery(criteria).getResultList();
    }
}
