package org.jboss.as.quickstarts.html5_mobile.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.conygre.training.entities.Equipment;


@ApplicationScoped
public class EquipmentRepository {

    //@Inject
    @PersistenceContext(unitName="conygreChapter8")
    private EntityManager em;

    public Equipment findByTac(int tAC) {
        return em.find(Equipment.class, tAC);
    }

    public Equipment findByEquipmentType(String equipmentType) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Equipment> criteria = cb.createQuery(Equipment.class);
        Root<Equipment> equipment = criteria.from(Equipment.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).where(cb.equal(member.get(Member_.name), email));
        criteria.select(equipment).where(cb.equal(equipment.get("equipmentType"), equipmentType));
        return em.createQuery(criteria).getSingleResult();
    }

    public List<Equipment> findAllOrderedByEquipmentType() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Equipment> criteria = cb.createQuery(Equipment.class);
        Root<Equipment> equipment = criteria.from(Equipment.class);
        // Swap criteria statements if you would like to try out type-safe criteria queries, a new
        // feature in JPA 2.0
        // criteria.select(member).orderBy(cb.asc(member.get(Member_.name)));
        criteria.select(equipment).orderBy(cb.asc(equipment.get("equipmentType")));
        return em.createQuery(criteria).getResultList();
    }
}
