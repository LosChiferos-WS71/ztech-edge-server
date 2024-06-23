package com.loschiferos.ztech.transference.domain.services;

import com.loschiferos.ztech.transference.domain.model.commands.CreateFlowerpotLinkCommand;
import com.loschiferos.ztech.transference.domain.model.commands.CreateHumiditySensorCommand;
import com.loschiferos.ztech.transference.domain.model.commands.CreateSunlightSensorCommand;
import com.loschiferos.ztech.transference.domain.model.commands.CreateTemperatureSensorCommand;

public interface FlowerpotLinkCommandService {
    Long handle(CreateFlowerpotLinkCommand command);
    void handle(CreateTemperatureSensorCommand command);
    void handle(CreateHumiditySensorCommand command);
    void handle(CreateSunlightSensorCommand command);
}
