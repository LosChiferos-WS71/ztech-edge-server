package com.loschiferos.ztech.transference.interfaces.rest.transform;

import com.loschiferos.ztech.transference.domain.model.commands.CreateFlowerpotLinkCommand;
import com.loschiferos.ztech.transference.interfaces.rest.resources.CreateFlowerpotLinkResource;

public class CreateFlowerpotLinkCommandFromResourceAssembler {
    public static CreateFlowerpotLinkCommand toCommandFromResource(CreateFlowerpotLinkResource resource) {
        return new CreateFlowerpotLinkCommand(resource.flowerpotCloudId());
    }
}
