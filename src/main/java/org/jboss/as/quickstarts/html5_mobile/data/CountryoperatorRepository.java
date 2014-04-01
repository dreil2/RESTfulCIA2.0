package org.jboss.as.quickstarts.html5_mobile.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.conygre.training.entities.Countryoperator;

@ApplicationScoped
public class CountryoperatorRepository {

    //@Inject
    @PersistenceContext(unitName="conygreChapter8")
    private EntityManager em;

    public Countryoperator findById(int id) {
        return em.find(Countryoperator.class, id);
    }

    public Countryoperator findByCountry(String country) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Countryoperator> criteria = cb.createQuery(Countryoperator.class);
        Root<Countryoperator> countryoperator = criteria.from(Countryoperator.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(countryoperator).where(cb.equal(countryoperator.get("country"), country));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Countryoperator> findAllOrderedByCountry() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Countryoperator> criteria = cb.createQuery(Countryoperator.class);
        Root<Countryoperator> countryoperator = criteria.from(Countryoperator.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(countryoperator).orderBy(cb.asc(countryoperator.get("country")));
        return em.createQuery(criteria).getResultList();
    }
}
