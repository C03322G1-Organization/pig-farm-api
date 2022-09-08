package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.service.impl.FoodServiceImpl;

import java.util.List;

public interface FoodService{

    void create(Food food);

    void update(Food food);

    Food findById(int id);
}
