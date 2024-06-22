package com.loschiferos.ztech.transference.infrastructure.persistance.jpa.repositories;

import com.loschiferos.ztech.transference.domain.model.aggregates.FlowerpotLink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerpotLinkRepository extends JpaRepository<FlowerpotLink, Long> {
    boolean existsByFlowerpotCloudId(Long flowerpotCloudId);
}
