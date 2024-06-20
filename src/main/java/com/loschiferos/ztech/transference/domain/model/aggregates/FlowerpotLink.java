package com.loschiferos.ztech.transference.domain.model.aggregates;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Entity
@Getter
@AllArgsConstructor
public class FlowerpotLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flowerpotCloudId;

    public FlowerpotLink() {
        this.flowerpotCloudId = null;
    }

    public FlowerpotLink(Long flowerpotCloudId) {
        this();
        this.flowerpotCloudId = flowerpotCloudId;
    }
}
