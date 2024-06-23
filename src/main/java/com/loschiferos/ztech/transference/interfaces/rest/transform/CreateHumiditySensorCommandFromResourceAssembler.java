package com.loschiferos.ztech.transference.interfaces.rest.transform;

import com.loschiferos.ztech.transference.domain.model.commands.CreateHumiditySensorCommand;
import com.loschiferos.ztech.transference.interfaces.rest.resources.CreateHumiditySensorResource;

public class CreateHumiditySensorCommandFromResourceAssembler {
    public static CreateHumiditySensorCommand toCommandFromResource(CreateHumiditySensorResource resource) {
        return new CreateHumiditySensorCommand(resource.flowerpotCloudId(), resource.humidity());
    }
}
