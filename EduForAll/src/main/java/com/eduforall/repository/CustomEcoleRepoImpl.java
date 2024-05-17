package com.eduforall.repository;

import com.eduforall.model.Ecole;
import com.eduforall.model.criteria.EcoleCriteria;
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
public class CustomEcoleRepoImpl  implements  CustomeEcoleRepo{

    EntityManager em;

    public CustomEcoleRepoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Iterable<Ecole> findByCriteria(EcoleCriteria ecoleCriteria, Pageable pageable) {

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Ecole> cq = cb.createQuery(Ecole.class);
            Root<Ecole> ecole = cq.from(Ecole.class);



            cq.select(ecole);



            Predicate[] predicates = generateWhere(ecoleCriteria, cq, cb, ecole);
            cq.where(predicates);



            TypedQuery<Ecole> query = em.createQuery(cq);
            query.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
            query.setMaxResults(pageable.getPageSize());



            return em.createQuery(cq).getResultList();

    }

    private Predicate[] generateWhere(EcoleCriteria ecoleCriteria ,CriteriaQuery<?>cq, CriteriaBuilder cb, Root<Ecole> ecoleRoot) {

        List<Predicate> predicates = new ArrayList<>();

        if(ecoleCriteria.getNomEcole()!=null){
            predicates.add(cb.like(cb.lower(ecoleRoot.get("nomEcole")), "%" + ecoleCriteria.getNomEcole().toLowerCase().trim() + "%"));
        }

        if(ecoleCriteria.getAdresse()!=null){
            predicates.add(cb.like(cb.lower(ecoleRoot.get("adresse")), "%" + ecoleCriteria.getAdresse().toLowerCase().trim() + "%"));
        }

        if(ecoleCriteria.getEmail()!=null){
            predicates.add(cb.like(cb.lower(ecoleRoot.get("email")), "%" + ecoleCriteria.getEmail().toLowerCase().trim() + "%"));
        }
        if(ecoleCriteria.getTelephone()!=null){
            predicates.add(cb.like(cb.lower(ecoleRoot.get("telephone")), "%" + ecoleCriteria.getTelephone().toLowerCase().trim() + "%"));
        }

        return predicates.toArray(new Predicate[0]);

    }
}
