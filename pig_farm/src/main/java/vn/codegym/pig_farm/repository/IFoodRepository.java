package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Food;

@Repository
public interface IFoodRepository extends JpaRepository<Food, Integer> {
    /**
     * Create by HoanTV
     * Date: 16:30 pm  08-9-2022
     * method show list and search and paging
     * HoanTV-list-food
     *
     * @param pageable
     * @param foodType
     * @return
     **/
    @Query(value = " select f.* from food f " +
            " join storage s on s.id = f.storage_id " +
            " where s.food_type like :foodType ",nativeQuery = true,
    countQuery = " select count(*) from ( select f.* from food f join storage s on s.id = f.storage_id where s.food_type like :foodType ) temp ")
    Page<Food> getAllFood(Pageable pageable, @Param("foodType") String foodType);
}
