package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.Food;
import vn.codegym.pig_farm.entity.Pigsty;
import vn.codegym.pig_farm.entity.Storage;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface IFoodRepository extends JpaRepository<Food, Integer> {

    @Modifying
    @Query(value = "INSERT INTO food(amount, unit, pigsty_id, storage_id) " +
            " values(:amount, :unit , :pigsty, :storage)", nativeQuery = true)
    void save(@Param("amount") Integer amount,
              @Param("unit") String unit,
              @Param("pigsty") Pigsty pigsty,
              @Param("storage") Storage storage);


    @Transactional
    @Modifying
    @Query(value = "update food set amount = :amount, unit = :unit, pigsty_id = :pigsty, storage_id = :storage where id = :id", nativeQuery = true)
    void update(@Param("amount") Integer amount,
                @Param("unit") String unit,
                @Param("pigsty") Pigsty pigsty,
                @Param("storage") Storage storage,
                @Param("id") Integer id);


    @Query(value = "select * from food where id = :id", nativeQuery = true)
    Food findById(@Param("id") int id);
}

