package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.repository.IFoodRepository;
import vn.codegym.pig_farm.service.FoodService;


@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    IFoodRepository iFoodRepository;

    @Override
    public void create(Food food) {
        iFoodRepository.save(food.getAmount(), food.getUnit(), food.getPigsty(), food.getStorage());
    }

    @Override
    public void update(Food food) {
        iFoodRepository.update(food.getAmount(), food.getUnit(), food.getPigsty(), food.getStorage(), food.getId());
    }

    @Override
    public Food findById(int id) {
        return iFoodRepository.findById(id);
    }
}
