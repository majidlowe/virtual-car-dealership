package com.example.virtualcardealership;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cars")
public class CarController {
    CarService carService;

    public CarController (CarService carService) {
        this.carService = carService;
    }

    @GetMapping("")
    public Iterable<Car> listOfCars(){
        return carService.getAllCars();
    }

    @DeleteMapping("/{id}")
    public boolean deleteCarById(@PathVariable long id){
        return carService.deleteCarFromInventory(id);
    }

}
