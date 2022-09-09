package vn.codegym.pig_farm.controller;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.FoodDto;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.entity.Storage;
import vn.codegym.pig_farm.service.FoodService;


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
     *
     * @param foodDto
     * @return if created food return HttpStatus.CREATED(201)
     */
    @PostMapping("/create")
    public ResponseEntity<Object> add(@Validated @RequestBody FoodDto foodDto, BindingResult bindingResult) {
        if (foodDto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_FOUND);
        }
        Food food = new Food();

        BeanUtils.copyProperties(foodDto, food);
        food.setAmount(foodDto.getAmount());
        food.setUnit(foodDto.getUnit());
        food.setStorage(foodDto.getStorage());
        food.setPigsty(foodDto.getPigsty());

        foodService.create(food);
        Storage storage = foodService.findByIdStorage(foodDto.getStorage().getId());
        int amountSet = storage.getAmount() - foodDto.getAmount();
        if (amountSet < 0) {
            return new ResponseEntity<>(bindingResult.getAllErrors(), HttpStatus.NOT_FOUND);
        }
        foodService.updateStorage(amountSet, storage.getId());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: edit a food
     *
     * @param foodDto
     * @return if created food return HttpStatus.CREATED(201)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") Integer id, @Validated @RequestBody FoodDto foodDto, BindingResult bindingResult) {
        Food foods = foodService.findById(id);
        if (foods == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (bindingResult.hasFieldErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        foods.setAmount(foodDto.getAmount());
        foods.setUnit(foodDto.getUnit());
        foods.setPigsty(foodDto.getPigsty());
        foods.setStorage(foodDto.getStorage());
        foodService.update(foods);
        return new ResponseEntity<>(foods, HttpStatus.CREATED);
    }


}
