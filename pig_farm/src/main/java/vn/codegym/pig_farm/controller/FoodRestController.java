package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.service.IFoodService;

import java.util.Optional;
@CrossOrigin
@RestController
@RequestMapping("/food")
public class FoodRestController {
    @Autowired
    private IFoodService iFoodService;
    /**
     * Create by HoanTV
     * Date: 16:30 pm  08-9-2022
     * method show list and search and paging
     * HoanTV-list-food
     * @param pageable
     * @param foodType
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<Page<Food>> getAllFood(@PageableDefault(3) Pageable pageable,
                                                 Optional<String> foodType) {
        String searchKeyWork = foodType.orElse("");
        Page<Food> iFoodPage = this.iFoodService.getAllFood(pageable, searchKeyWork);
        if (iFoodPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(iFoodPage, HttpStatus.OK);
    }

}
