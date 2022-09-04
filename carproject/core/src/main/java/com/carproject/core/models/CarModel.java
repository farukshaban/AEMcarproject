package com.carproject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = Resource.class)
public class CarModel {

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String brand;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String model;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String year;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String km;

    @ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
    private String description;

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getKm() {
        return km;
    }

    public String getDescription() {
        return description;
    }
}
