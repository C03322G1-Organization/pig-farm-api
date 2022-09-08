package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.dto.IFoodDto;
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
     * @param nameSearch
     * @return
     **/
    @Query(value = " SELECT f.id as id,f.amount ,f.unit,f.is_deleted as isdeleted,f.pigsty_id as pigsty ,f.storage_id as storage FROM food as f " +
            " where f.amount like :nameSearch ", nativeQuery = true,
            countQuery = " SELECT count(*) from (SELECT f.id as id,f.amount ,f.unit,f.is_deleted,f.pigsty_id as pigsty,f.storage_id as storage FROM food as f where f.amount like :nameSearch ) table_name")
    Page<IFoodDto> getAllFood(Pageable pageable, @Param("nameSearch") String nameSearch);
}
