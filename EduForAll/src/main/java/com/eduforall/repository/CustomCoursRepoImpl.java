package com.eduforall.repository;

import com.eduforall.model.Cours;
import com.eduforall.model.criteria.CoursCriteria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomCoursRepoImpl  implements CustomeCoursRepo {

    EntityManager em;

    public CustomCoursRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Iterable<Cours> findByCriteria(CoursCriteria coursCriteria, Pageable pageable) {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Cours> cq = cb.createQuery(Cours.class);
        Root<Cours> cours = cq.from(Cours.class);
        cq.select(cours);
        Predicate[] predicates = generateWhere(coursCriteria, cq, cb, cours);
        cq.where(predicates);
        TypedQuery<Cours> query = em.createQuery(cq);
        query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        query.setMaxResults(pageable.getPageSize());
        return query.getResultList();

    }

    private Predicate[]  generateWhere(CoursCriteria coursCriteria, CriteriaQuery<?> cq, CriteriaBuilder cb, Root<Cours> cours) {
        List<Predicate> predicates = new ArrayList<>();

        if (coursCriteria.getEcole() != null) {
            predicates.add(cb.equal(cours.get("ecole"), coursCriteria.getEcole()));
        }
        if (coursCriteria.getEcole() != null) {
            predicates.add(cb.equal(cours.get("ecole"), coursCriteria.getEcole()));
        }
        if (coursCriteria.getProfesseur()!=null){
            predicates.add(cb.equal(cours.get("professeur"), coursCriteria.getProfesseur()));
        }
        if (coursCriteria.getSubject()!=null){
            predicates.add(cb.equal(cours.get("subject"), coursCriteria.getSubject()));
        }
        if (coursCriteria.getLevel()!=null){
            predicates.add(cb.equal(cours.get("level"), coursCriteria.getLevel()));
        }
        if (coursCriteria.getDuration()!=0){
            predicates.add(cb.equal(cours.get("duration"), coursCriteria.getDuration()));
        }
        return predicates.toArray(new Predicate[0]);
    }
}
