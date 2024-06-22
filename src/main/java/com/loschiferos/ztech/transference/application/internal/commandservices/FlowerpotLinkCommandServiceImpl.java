package com.loschiferos.ztech.transference.application.internal.commandservices;

import com.loschiferos.ztech.shared.domain.exceptions.ValidationException;
import com.loschiferos.ztech.transference.domain.model.aggregates.FlowerpotLink;
import com.loschiferos.ztech.transference.domain.model.commands.CreateFlowerpotLinkCommand;
import com.loschiferos.ztech.transference.domain.services.FlowerpotLinkCommandService;
import com.loschiferos.ztech.transference.infrastructure.persistance.jpa.repositories.FlowerpotLinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlowerpotLinkCommandServiceImpl implements FlowerpotLinkCommandService {

    private final FlowerpotLinkRepository flowerpotLinkRepository;

    @Autowired
    public FlowerpotLinkCommandServiceImpl(FlowerpotLinkRepository flowerpotLinkRepository) {
        this.flowerpotLinkRepository = flowerpotLinkRepository;
    }

    @Override
    public Long handle(CreateFlowerpotLinkCommand command) {
        if (command.flowerpotCloudId().describeConstable().isEmpty()) {
            throw new ValidationException("Invalid flowerpotCloudId");
        }
        if (command.flowerpotCloudId() <= 0) {
            throw new ValidationException("Invalid flowerpotCloudId");

        }
        if (flowerpotLinkRepository.existsByFlowerpotCloudId(command.flowerpotCloudId())) {
            throw new ValidationException("FlowerpotLink already exists");
        }

        FlowerpotLink flowerpotLink = new FlowerpotLink(command.flowerpotCloudId());
        return flowerpotLinkRepository.save(flowerpotLink).getId();
    }
}
