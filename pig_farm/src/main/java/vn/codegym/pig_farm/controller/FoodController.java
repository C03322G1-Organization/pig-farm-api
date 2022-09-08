package vn.codegym.pig_farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.service.FoodService;

import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/api/food")
public class FoodController {


    @Autowired
    FoodService foodService;

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: create a food
     * @param food
     * @return
     * if created food return HttpStatus.CREATED(201)
     *
     */
    @PostMapping("/create")
    public ResponseEntity<Object> add(@RequestBody Food food) {
        if (food == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        foodService.create(food);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: edit a food
     * @param food
     * @return
     * if created food return HttpStatus.CREATED(201)
     *
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @RequestBody Food food) {
        Food foods = foodService.findById(id);
        if (foods == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        foods.setAmount(food.getAmount());
        foods.setUnit(food.getUnit());
        foods.setPigsty(food.getPigsty());
        foods.setStorage(food.getStorage());
        foodService.update(food);
        return new ResponseEntity<>(foods,HttpStatus.CREATED);
    }
}
