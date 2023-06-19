package org.example.z1;

import org.example.z1.Car;
import org.example.z1.CarDAO;
import org.example.z1.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CarDAOTest {

    @Mock
    private CarDAO carDAO = mock(CarDAO.class);
    private Car carId1;
    private HashMap<String, Long> yearMileage;
    private final UUID firstCarId = UUID.fromString("123e4567-e89b-42d3-a456-556642440000");
    @InjectMocks
    private CarService carService;

    @BeforeEach
    void setup() {
        yearMileage = new HashMap<>();
        yearMileage.put("2020", 1000L);
        yearMileage.put("2021", 2000L);
        yearMileage.put("2022", 3000L);
        yearMileage.put("2023", 4000L);

        carId1 = new Car(yearMileage);
    }

    @Test
    void findCarByIdTest() {
        when(carDAO.findCarById(firstCarId)).thenReturn(carId1);

        assertEquals(carService.findMileageBetweenYears(firstCarId, "2020", "2022"), 6000L);
        assertEquals(carService.findMileageBetweenYears(firstCarId, "2021", "2023"), 9000L);

        verify(carDAO, times(2)).findCarById(firstCarId);
    }


}