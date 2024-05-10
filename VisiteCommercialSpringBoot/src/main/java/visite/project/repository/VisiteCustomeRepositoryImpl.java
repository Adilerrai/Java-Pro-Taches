package visite.project.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import visite.project.dto.VisiteCriteria;
import visite.project.model.Visite;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository

public class VisiteCustomeRepositoryImpl implements VisiteCustomeRepository {
    EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public Page<Visite> findByCriteria(VisiteCriteria criteria, Pageable pageable) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Visite> query = cb.createQuery(Visite.class);
        Root<Visite> visiteRoot = query.from(Visite.class);

        Predicate[] predicates = generateWhere(cb, visiteRoot, criteria);
        query.where(predicates);

        TypedQuery<Visite> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
        typedQuery.setMaxResults(pageable.getPageSize());

        List<Visite> visites = typedQuery.getResultList();
        long totalItems = entityManager.createQuery(query).getResultList().size();

        return new PageImpl<>(visites, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), totalItems);


    }
    private Predicate[] generateWhere(CriteriaBuilder cb, Root<Visite> rootCommercial, VisiteCriteria criteria) {
        List<Predicate> predicates = new ArrayList<>();

        if (criteria.getName() != null) {
            predicates.add(cb.equal(rootCommercial.get("nom"), criteria.getName()));
        }

        if (criteria.getStatus()!= null) {
            predicates.add(cb.equal(rootCommercial.get("adresse"), criteria.getAddress()));
        }

        if (criteria.getPhoneNumber() != null) {
            predicates.add(cb.equal(rootCommercial.get("telephone"), criteria.getPhoneNumber()));
        }

        return predicates.toArray(new Predicate[0]);
    }
}
