package com.loschiferos.ztech.transference.interfaces.rest.transform;

import com.loschiferos.ztech.transference.domain.model.commands.CreateTemperatureSensorCommand;
import com.loschiferos.ztech.transference.interfaces.rest.resources.CreateTemperatureSensorResource;

public class CreateTemperatureSensorCommandFromResourceAssembler {
    public static CreateTemperatureSensorCommand toCommandFromResource(CreateTemperatureSensorResource resource) {
        return new CreateTemperatureSensorCommand(resource.flowerpotCloudId(), resource.temperature());
    }
}
