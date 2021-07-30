package com.example.virtualcardealership;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarService {
    CarRepo carRepo;


    public CarService(CarRepo carRepo){
    Car savedCar = new Car(1,"Chevy", "Cruze", 20000, false);
        this.carRepo = carRepo;
        carRepo.save(savedCar);
    }
    public List<Car> getAllCars(){
        return (List<Car>) carRepo.findAll();
    }

    public boolean purchaseCar(long id) {
        Optional<Car> newSavedCar = carRepo.findById(1L);
        carRepo.deleteById(id);
        if(newSavedCar.isPresent()) {
            Car soldCar = newSavedCar.get();
            soldCar.setSold(true);
            return true;
        }
        return false;


    }
}
