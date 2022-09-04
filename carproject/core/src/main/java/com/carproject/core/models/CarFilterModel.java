package com.carproject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Model(adaptables = Resource.class)
public class CarFilterModel {
    @ResourcePath(path = "/content/carproject/carData/cars")
    private Resource allCars;

    private List<CarModel> filteredCars = new ArrayList<>();

    @PostConstruct
    protected void init() {
        allCars.getChildren().forEach(this::addCarToFilteredList);
    }

    @ValueMapValue(name = "selectedCar", injectionStrategy = InjectionStrategy.OPTIONAL)
    private String selectedCar;

    private void addCarToFilteredList(Resource resource) {
        CarModel car = resource.adaptTo(CarModel.class);

        if ("All".equals(selectedCar)) {
            filteredCars.add(car);
        }

        if (car.getBrand().equals(selectedCar)) {
            filteredCars.add(car);
        }
    }

    public List<CarModel> getFilteredCars() {
        return filteredCars;
    }
}
