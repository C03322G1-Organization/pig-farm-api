package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.Storage;

import javax.transaction.Transactional;

public interface IStorageRepository extends JpaRepository<Storage, Integer> {
    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: findByIdStorage2 a Storage
     * @param id
     * @return
     */
    @Query(value = "select id , amount, date, is_deleted, unit from storage where id = :id ", nativeQuery = true)
    Storage findByIdStorage(@Param("id") int id);


    /**
     * Create by: HungNV
     * Date created: 08/09/2022
     * function: edit a Storage
     * @param amount
     */

    @Transactional
    @Modifying
    @Query(value = "update storage set amount = :amount where id = :id", nativeQuery = true)
    void updateAmountStorage(@Param("amount") Integer amount,@Param("id") Integer id);
}
