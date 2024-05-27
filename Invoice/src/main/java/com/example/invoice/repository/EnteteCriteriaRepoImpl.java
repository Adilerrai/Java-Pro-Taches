package com.example.invoice.repository;

import com.example.invoice.dto.EnteteFactDTO;
import com.example.invoice.dto.EnteteRechercheDTO;
import com.example.invoice.model.EnteteFact;
import com.example.invoice.service.mapper.EnteteMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class EnteteCriteriaRepoImpl implements EnteteCriteriaRepo {

    private final EntityManager em;

    private EnteteMapper enteteMapper;

    public EnteteCriteriaRepoImpl(EntityManager em , EnteteMapper enteteMapper) {
        this.em = em;
        this.enteteMapper = enteteMapper;
    }

    private Predicate[] generateWhere(CriteriaBuilder cb, Root<EnteteFact> rootEntete, EnteteRechercheDTO enteteRechercheDTO) {
        List<Predicate> predicates = new ArrayList<>();

        if (enteteRechercheDTO.getStatut() != null) {
            predicates.add(cb.equal(rootEntete.get("statut"), enteteRechercheDTO.getStatut()));
        }
        if (enteteRechercheDTO.getNumeroFacture() != null) {
            predicates.add(cb.equal(rootEntete.get("numeroFacture"), enteteRechercheDTO.getNumeroFacture()));
        }
        if (enteteRechercheDTO.getDateFacture() != null) {
            predicates.add(cb.equal(rootEntete.get("dateFacture"), enteteRechercheDTO.getDateFacture()));
        }
        if (enteteRechercheDTO.getModePaiement() != null) {
            predicates.add(cb.like(cb.lower(rootEntete.get("modePaiement")), "%" + enteteRechercheDTO.getModePaiement().toLowerCase().trim() + "%"));
        }
        if (enteteRechercheDTO.getClient() != null) {
            predicates.add(cb.equal(rootEntete.get("client"), enteteRechercheDTO.getClient()));
        }
        if (enteteRechercheDTO.getDetFactures() != null) {
            predicates.add(cb.equal(rootEntete.get("detFactures"), enteteRechercheDTO.getDetFactures()));
        }
        return predicates.toArray(new Predicate[0]);
    }

    @Override
    public Page<EnteteFactDTO> findByCriteria(EnteteRechercheDTO enteteRechercheDTO, Pageable pageable) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<EnteteFact> cq = cb.createQuery(EnteteFact.class);
        Root<EnteteFact> enteteFact = cq.from(EnteteFact.class);

        Predicate[] predicates = this.generateWhere(cb, enteteFact, enteteRechercheDTO);

        cq.where(predicates);
        cq.select(enteteFact);

        // Execute the query and get the results
        TypedQuery<EnteteFact> query = em.createQuery(cq);
        List<EnteteFact> results = query.getResultList();

        // Transform the results from EnteteFact to EnteteFactDTO
        List<EnteteFactDTO> dtoResults = results.stream()
                .map(fact -> {
                    // Transform fact to EnteteFactDTO
                    EnteteFactDTO dto = enteteMapper.entityToDto(fact);
                    return dto;
                })
                .collect(Collectors.toList());

        // count lignes
        CriteriaQuery<Long> cqcount = cb.createQuery(Long.class);
        Root<EnteteFact> enteteFactCount = cqcount.from(EnteteFact.class);
        cqcount.select(cb.count(enteteFactCount));
        Predicate[] predicates2 = this.generateWhere(cb, enteteFactCount, enteteRechercheDTO);
        cqcount.where(predicates2);
        Long totalCount = em.createQuery(cqcount).getSingleResult();

        // Return the results as a Page
        return new PageImpl<>(dtoResults, pageable, totalCount);
    }
}
