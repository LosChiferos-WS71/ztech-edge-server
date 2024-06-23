package com.loschiferos.ztech.transference.domain.model.valueobjects;

import com.loschiferos.ztech.transference.domain.model.entities.TemperatureSensor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Embeddable
public class TemperatureSensorList {
    @OneToMany(mappedBy = "flowerpotLink", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TemperatureSensor> temperatureSensors;

    public TemperatureSensorList()
    {
        this.temperatureSensors = new ArrayList<>();
    }

    public List<TemperatureSensor> getTemperatureSensors() {
        return temperatureSensors;
    }

    public void createTemperatureSensor(TemperatureSensor temperatureSensor)
    {
        this.temperatureSensors.add(temperatureSensor);
    }

    public void clear() {
        this.temperatureSensors.clear();
    }
}
