package org.example.z1;

import java.util.UUID;

public class CarService {
    private final CarDAO carDAO;

    public CarService(CarDAO carDAO) {
        this.carDAO = carDAO;
    }

    Long findMileageBetweenYears(UUID id, String startYear, String endYear) {
        Car car = carDAO.findCarById(id);
        long result = 0;
        for (String year : car.getYearMileage().keySet()) {
            if (year.compareTo(startYear) >= 0 && year.compareTo(endYear) <= 0) {
                result += car.getYearMileage().get(year);
            }
        }
        return result;
    }
}
