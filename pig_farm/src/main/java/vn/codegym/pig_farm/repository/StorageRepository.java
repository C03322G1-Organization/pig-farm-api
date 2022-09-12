package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.dto.StorageListDto;
import vn.codegym.pig_farm.entity.Storage;

import java.time.LocalDate;

@Transactional
public interface StorageRepository extends JpaRepository<Storage, Integer> {

//    @Query(value = "select `storage`.id, `storage`.amount,`storage`.food_type, `storage`.`date`, `storage`.unit, `storage`.is_deleted from storage", nativeQuery = true)
//    List<Storage> storagePage();

    /**
     * Created by: HoangDT
     * Date created: 08/09/2022
     * Function: findAll
     */

    @Query(value = " select storage.id, storage.amount,storage.food_type as foodType, storage.date, storage.unit from storage where food_type like :foodType and is_deleted = 0 ", nativeQuery = true,
            countQuery = " select count(*) from (select * from storage where food_type like :foodType) temp_table ")
    Page<StorageListDto> findAllStorage(Pageable pageable, @Param("foodType") String foodType);

    /**
     * Created by: HoangDT
     * Date created: 08/09/2022
     * Function: create storage
     */

    @Modifying
    @Query(value = "insert into `storage` ( amount, food_type, `date`, unit)" +
            "values (:amount, :foodType, :date, :unit)", nativeQuery = true)
    void saveS(@Param("amount") Integer amount, @Param("foodType") String foodType, @Param("date") LocalDate date, @Param("unit") String unit);

}