package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Food;

public interface IFoodService {
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
    Page<Food> getAllFood(Pageable pageable, String searchKeyWork);

}
