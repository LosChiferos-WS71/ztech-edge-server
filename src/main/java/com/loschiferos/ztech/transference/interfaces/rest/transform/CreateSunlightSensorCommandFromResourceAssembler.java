package com.loschiferos.ztech.transference.interfaces.rest.transform;

import com.loschiferos.ztech.transference.domain.model.commands.CreateSunlightSensorCommand;
import com.loschiferos.ztech.transference.interfaces.rest.resources.CreateSunlightSensorResource;

public class CreateSunlightSensorCommandFromResourceAssembler {
    public static CreateSunlightSensorCommand toCommandFromResource(CreateSunlightSensorResource resource) {
        return new CreateSunlightSensorCommand(resource.flowerpotCloudId(), resource.sunlight());
    }
}
