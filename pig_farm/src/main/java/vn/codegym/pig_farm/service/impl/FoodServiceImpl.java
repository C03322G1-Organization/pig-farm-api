package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.entity.Storage;
import vn.codegym.pig_farm.repository.IFoodRepository;
import vn.codegym.pig_farm.repository.IStorageRepository;
import vn.codegym.pig_farm.service.FoodService;


@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    IFoodRepository iFoodRepository;

    @Autowired
    IStorageRepository storageRepository;

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: create a food
     * @param food
     */
    @Override
    public void create(Food food) {
        iFoodRepository.save(food.getAmount(), food.getUnit(), food.getPigsty(), food.getStorage());
    }

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: update a food
     * @param food
     */
    @Override
    public void update(Food food) {
        iFoodRepository.update(food.getAmount(), food.getUnit(), food.getPigsty(), food.getStorage(), food.getId());
    }

    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: finById a food
     * @param id
     * @return
     */
    @Override
    public Food findById(int id) {
        return iFoodRepository.findById(id);
    }

    @Override
    public Storage findByIdStorage(int id) {
        return storageRepository.findByIdStorage(id);
    }



    @Override
    public void updateStorage(int i, Integer id) {
        storageRepository.updateAmountStorage(i, id);
    }
}
