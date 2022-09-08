package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.dto.IFoodDto;
import vn.codegym.pig_farm.repository.IFoodRepository;
import vn.codegym.pig_farm.service.IFoodService;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private IFoodRepository iFoodRepository;

    /**
     * Create by HoanTV
     * Date: 16:30 pm  08-9-2022
     * method show list and search and paging
     * HoanTV-list-food
     *
     * @param pageable
     * @param searchKeyWork
     * @return
     */
    @Override
    public Page<IFoodDto> getAllFood(Pageable pageable, String searchKeyWork) {
        return iFoodRepository.getAllFood(pageable, "%" + searchKeyWork + "%");
    }
}
