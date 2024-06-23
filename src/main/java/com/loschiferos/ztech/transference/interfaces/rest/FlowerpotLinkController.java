package com.loschiferos.ztech.transference.interfaces.rest;

import com.loschiferos.ztech.shared.domain.exceptions.ResourceNotFoundException;
import com.loschiferos.ztech.transference.domain.model.queries.GetFlowerpotLinkByIdQuery;
import com.loschiferos.ztech.transference.domain.services.FlowerpotLinkCommandService;
import com.loschiferos.ztech.transference.domain.services.FlowerpotLinkQueryService;
import com.loschiferos.ztech.transference.interfaces.rest.resources.CreateFlowerpotLinkResource;
import com.loschiferos.ztech.transference.interfaces.rest.resources.CreateTemperatureSensorResource;
import com.loschiferos.ztech.transference.interfaces.rest.resources.FlowerpotLinkResource;
import com.loschiferos.ztech.transference.interfaces.rest.transform.CreateFlowerpotLinkCommandFromResourceAssembler;
import com.loschiferos.ztech.transference.interfaces.rest.transform.CreateTemperatureSensorCommandFromResourceAssembler;
import com.loschiferos.ztech.transference.interfaces.rest.transform.FlowerpotLinkResourceFromEntityAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "**", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/flowerpot/links")
public class FlowerpotLinkController {
    private final FlowerpotLinkCommandService flowerpotLinkCommandService;
    private final FlowerpotLinkQueryService flowerpotLinkQueryService;

    @Autowired
    public FlowerpotLinkController(FlowerpotLinkCommandService flowerpotLinkCommandService, FlowerpotLinkQueryService flowerpotLinkQueryService) {
        this.flowerpotLinkCommandService = flowerpotLinkCommandService;
        this.flowerpotLinkQueryService = flowerpotLinkQueryService;
    }

    @PostMapping
    public ResponseEntity<FlowerpotLinkResource> createFlowerpotLink(@RequestBody CreateFlowerpotLinkResource resource) {
        var createFlowerpotLinkCommand = CreateFlowerpotLinkCommandFromResourceAssembler.toCommandFromResource(resource);
        var flowerpotLinkId = flowerpotLinkCommandService.handle(createFlowerpotLinkCommand);
        if (flowerpotLinkId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getFlowerpotLinkByIdQuery = new GetFlowerpotLinkByIdQuery(flowerpotLinkId);
        var flowerpotLink = flowerpotLinkQueryService.handle(getFlowerpotLinkByIdQuery);
        if (flowerpotLink.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        var flowerpotLinkResource = FlowerpotLinkResourceFromEntityAssembler.toResourceFromEntity(flowerpotLink.get());
        return new ResponseEntity<>(flowerpotLinkResource, HttpStatus.CREATED);
    }

    @PostMapping("/temperature")
    public ResponseEntity<Void> createTemperatureSensor(@RequestBody CreateTemperatureSensorResource resource) {
        var createTemperatureSensorCommand = CreateTemperatureSensorCommandFromResourceAssembler.toCommandFromResource(resource);
        flowerpotLinkCommandService.handle(createTemperatureSensorCommand);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{flowerpotLinkId}")
    public ResponseEntity<FlowerpotLinkResource> getFlowerpotLinkById(@PathVariable Long flowerpotLinkId) {
        var getFlowerpotLinkByIdQuery = new GetFlowerpotLinkByIdQuery(flowerpotLinkId);
        var flowerpotLink = flowerpotLinkQueryService.handle(getFlowerpotLinkByIdQuery);
        if (flowerpotLink.isEmpty()) {
            throw new ResourceNotFoundException("FlowerpotLink not found");
        }
        var flowerpotLinkResource = FlowerpotLinkResourceFromEntityAssembler.toResourceFromEntity(flowerpotLink.get());
        return new ResponseEntity<>(flowerpotLinkResource, HttpStatus.OK);
    }
}
