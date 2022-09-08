package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.service.impl.FoodServiceImpl;

import java.util.List;

public interface FoodService{

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: create a food
     * @param food
     */
    void create(Food food);

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: update a food
     * @param food
     */

    void update(Food food);

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: finById a food
     * @param id
     * @return
     */

    Food findById(int id);
}
