package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.entity.Treatment;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Repository
public interface ITreatmentRepository extends JpaRepository<Treatment,Integer> {
    /**
     * create by TuongTK
     * date: 08/09/2022
     * write query for method save
     * @param id
     * @param date
     * @param doctor
     * @param diseases
     * @param medicine
     * @param amount
     * @param pig
     */
    @Modifying
    @Transactional
    @Query(value = "insert into treatment(id, `date`, doctor, diseases, medicine, amount, pig_id) " +
            " values (:id, :date, :doctor, :diseases, :medicine, :amount, :pig_id);", nativeQuery = true)
    void save(@Param("id") Integer id,
              @Param("date") LocalDate date,
              @Param("doctor") String doctor,
              @Param("diseases") String diseases,
              @Param("medicine") String medicine,
              @Param("amount") Integer amount,
              @Param("pig_id") Pig pig);

}
