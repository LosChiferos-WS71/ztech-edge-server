package com.loschiferos.ztech.transference.application.internal.queryservices;

import com.loschiferos.ztech.transference.domain.model.aggregates.FlowerpotLink;
import com.loschiferos.ztech.transference.domain.model.queries.GetFlowerpotLinkByIdQuery;
import com.loschiferos.ztech.transference.domain.services.FlowerpotLinkQueryService;
import com.loschiferos.ztech.transference.infrastructure.persistance.jpa.repositories.FlowerpotLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FlowerpotLinkQueryServiceImpl implements FlowerpotLinkQueryService {

    private final FlowerpotLinkRepository flowerpotLinkRepository;

    public FlowerpotLinkQueryServiceImpl(FlowerpotLinkRepository flowerpotLinkRepository) {
        this.flowerpotLinkRepository = flowerpotLinkRepository;
    }

    @Override
    public Optional<FlowerpotLink> handle(GetFlowerpotLinkByIdQuery query) {
        return flowerpotLinkRepository.findById(query.flowerpotLinkId());
    }
}
