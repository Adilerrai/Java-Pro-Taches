//package visite.project.repository;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.stereotype.Repository;
//import visite.project.dto.CommercialCriteria;
//import visite.project.model.Commercial;
//
//import javax.persistence.EntityManager;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//import java.util.ArrayList;
//import java.util.List;
//@Repository
//
//public class CommercialCustomeRepoImpl implements CommercialCustomRepo {
//
//    EntityManager entityManager;
//
//    public CommercialCustomeRepoImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public Page<Commercial> findByCriteria(CommercialCriteria criteria, Pageable pageable) {
//        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
//        CriteriaQuery<Commercial> query = criteriaBuilder.createQuery(Commercial.class);
//        Root<Commercial> rootCommercial = query.from(Commercial.class);
//
//        Predicate[] predicates = generateWhere(criteriaBuilder, rootCommercial, criteria);
//        query.where(predicates);
//
//        TypedQuery<Commercial> typedQuery = entityManager.createQuery(query);
//        typedQuery.setFirstResult(pageable.getPageNumber() * pageable.getPageSize());
//        typedQuery.setMaxResults(pageable.getPageSize());
//
//        List<Commercial> commercials = typedQuery.getResultList();
//        long totalItems = entityManager.createQuery(query).getResultList().size();
//
//        return new PageImpl<>(commercials, PageRequest.of(pageable.getPageNumber(), pageable.getPageSize()), totalItems);
//    }
//
//    private Predicate[] generateWhere(CriteriaBuilder cb, Root<Commercial> rootCommercial, CommercialCriteria criteria) {
//        List<Predicate> predicates = new ArrayList<>();
//
//        if (criteria.getName() != null) {
//            predicates.add(cb.equal(rootCommercial.get("nom"), criteria.getName()));
//        }
//
//        if (criteria.getAddress() != null) {
//            predicates.add(cb.equal(rootCommercial.get("adresse"), criteria.getAddress()));
//        }
//
//        if (criteria.getPhoneNumber() != null) {
//            predicates.add(cb.equal(rootCommercial.get("telephone"), criteria.getPhoneNumber()));
//        }
//
//        return predicates.toArray(new Predicate[0]);
//    }
//}
