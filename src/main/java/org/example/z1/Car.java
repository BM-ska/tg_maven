package org.example.z1;

import java.util.HashMap;
import java.util.UUID;

public class Car {
    private final UUID id;
    private final HashMap<String, Long> yearMileage;

    public Car(HashMap<String, Long> yearMileage) {
        this.id = UUID.randomUUID();
        this.yearMileage = yearMileage;
    }

    public UUID getId() {
        return id;
    }

    public HashMap<String, Long> getYearMileage() {
        return yearMileage;
    }

    public void addMileage(String year, Long mileage) {
        yearMileage.put(year, mileage);
    }
}
