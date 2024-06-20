package com.loschiferos.ztech.transference.domain.services;

import com.loschiferos.ztech.transference.domain.model.commands.CreateFlowerpotLinkCommand;

public interface FlowerpotLinkCommandService {
    Long handle(CreateFlowerpotLinkCommand command);
}
