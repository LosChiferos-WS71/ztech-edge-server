package com.loschiferos.ztech.shared.domain.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ExternalServiceRequest {
    @JsonProperty("flowerpot_id")
    private Long flowerpotId;
    @JsonProperty("type")
    private int type;
    @JsonProperty("value")
    private double value;

    public ExternalServiceRequest(Long flowerpotId, int type, double value) {
        this.flowerpotId = flowerpotId;
        this.type = type;
        this.value = value;
    }
}