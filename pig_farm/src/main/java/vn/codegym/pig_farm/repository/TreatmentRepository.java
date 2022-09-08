package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.dto.ITreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;

import java.util.List;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {
    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * write query for method findAllTreatment
     * @return
     */
    @Query(value = "SELECT t.id, t.amount, t.date, t.diseases, t.doctor, t.is_deleted, t.medicine, p.pig_code as pigCode, pt.pigsty_code as pigstyCode  " +
            " FROM Treatment t JOIN pig p ON t.pig_id = p.id JOIN pigsty pt ON p.pigsty_id = pt.id where t.is_deleted = 0",
            nativeQuery = true)
    List<ITreatmentDto> getAllTreatment();

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * write query for method delete By Id Treatment
     * @param id
     * @return
     */
    @Modifying
    @Query(value = " UPDATE Treatment SET `is_deleted` = 1 WHERE (`id` = :id); ", nativeQuery = true)
    void deleteByIdTreatment(@Param("id") int id);

}
