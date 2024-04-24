package com.siontech.userservice.controller;

import com.siontech.userservice.entity.User;
import com.siontech.userservice.model.Bike;
import com.siontech.userservice.model.Car;
import com.siontech.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService UserService;
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        List<User> users = UserService.getAll();
        if (users.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(users);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getById(@PathVariable("id") int id){
        User user = UserService.getUserById(id);
        if (user == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @PostMapping()
    public ResponseEntity<User> save(@RequestBody User user){
        User userNew = UserService.save(user);
        return ResponseEntity.ok(userNew);
    }

    @GetMapping("/cars/{userId}")
    public ResponseEntity<List<Car>> getCars(@PathVariable("userId") int userId){
        User user = UserService.getUserById(userId);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<Car> cars = UserService.getCars(userId);
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/bikes/{userId}")
    public ResponseEntity<List<Bike>> getBikes(@PathVariable("userId") int userId){
        User user = UserService.getUserById(userId);
        if (user == null)
            return ResponseEntity.notFound().build();
        List<Bike> bikes = UserService.getBikes(userId);
        return ResponseEntity.ok(bikes);
    }

    @PostMapping("/savecar/{userId}")
    public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId, @RequestBody Car car){
        Car carNew = UserService.saveCar(userId,car);
        return ResponseEntity.ok(carNew);
    }
}
