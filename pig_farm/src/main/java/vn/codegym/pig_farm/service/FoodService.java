package vn.codegym.pig_farm.service;

import org.springframework.data.relational.core.sql.In;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.entity.Storage;

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



    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: finById a Storage
     * @param id
     * @return
     */

    Storage findByIdStorage(int id);


    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: update a Storage
     * @param i
     * @param id
     */
    void updateStorage(int i, Integer id);
}
