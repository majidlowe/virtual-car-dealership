package com.example.virtualcardealership;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// Mock the repo, use the service layer
@ExtendWith(MockitoExtension.class)
public class CarServiceTest {
    @Mock
    CarRepo carRepo;

//is there a .save() needed
//save method wasnt used to test the controller though
// find all is a method of CrudRepo


    @Test
    public void getAllTest(){
        Car myCar = new Car(1,"Chevy","Cruze",20000, false);
        List myCarList = new ArrayList();
        myCarList.add(myCar);

        CarService carService = new CarService(carRepo);


        when(carRepo.findAll()).thenReturn(myCarList);

        List<Car> returnedList = carService.getAllCars();
        assertThat(returnedList).hasSize(1);
        assertThat(returnedList.get(0).getMake()).isEqualTo("Chevy");

    }
    @Test
    public void purchaseCarById(){
        CarService carService = new CarService(carRepo);
        carService.purchaseCar(1);
        verify(carRepo, times(1)).deleteById(1L);

    }
    @Test
    public void updateSalesCommission(){

    }
}
