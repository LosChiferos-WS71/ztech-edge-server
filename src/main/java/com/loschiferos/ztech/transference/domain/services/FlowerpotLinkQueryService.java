package com.loschiferos.ztech.transference.domain.services;

import com.loschiferos.ztech.transference.domain.model.aggregates.FlowerpotLink;
import com.loschiferos.ztech.transference.domain.model.queries.GetFlowerpotLinkByIdQuery;

import java.util.Optional;

public interface FlowerpotLinkQueryService {
    Optional<FlowerpotLink> handle(GetFlowerpotLinkByIdQuery query);
}
