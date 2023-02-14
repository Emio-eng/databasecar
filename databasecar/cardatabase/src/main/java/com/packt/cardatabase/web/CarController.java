package com.packt.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Car;
import com.packt.cardatabase.domain.CarRepository;


@RestController
public class CarController {

    @Autowired
    private CarRepository repository;

    @RequestMapping("/cars")
    public Iterable<Car> getCars(){
        return repository.findAll();
    }
    
    @GetMapping("/colors")
    public Iterable<Car> getColor(@RequestParam("color") String color){
    	return this.repository.findByColor(color);
    }
    
    @GetMapping("/brand")
    public Iterable<Car> getBrand(@RequestParam("brand") String brand){
    	return this.repository.findByBrand(brand);
    }
}
