package com.example.virtualcardealership;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    CarRepo carRepo;


    public CarService(CarRepo carRepo){
    Car savedCar = new Car(1,"Chevy", "Cruze", 20000);
        this.carRepo = carRepo;
        carRepo.save(savedCar);
    }
    public List<Car> getAllCars(){
        return (List<Car>) carRepo.findAll();
    }

    public boolean deleteCarFromInventory(long id) {
        carRepo.deleteById(id);
        return true;
    }
}
