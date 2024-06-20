package com.loschiferos.ztech.transference.interfaces.rest.transform;

import com.loschiferos.ztech.transference.domain.model.aggregates.FlowerpotLink;
import com.loschiferos.ztech.transference.interfaces.rest.resources.FlowerpotLinkResource;

public class FlowerpotLinkResourceFromEntityAssembler {
    public static FlowerpotLinkResource toResourceFromEntity(FlowerpotLink entity) {
        return new FlowerpotLinkResource(entity.getId(), entity.getFlowerpotCloudId());
    }
}
