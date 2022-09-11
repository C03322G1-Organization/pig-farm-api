package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.dto.ITreatmentDto;
import vn.codegym.pig_farm.entity.Treatment;

import java.util.List;
import java.util.Optional;

@Repository
public interface TreatmentRepository extends JpaRepository<Treatment, Integer> {

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * write query for method findAllTreatment
     * @return
     */
    @Query(value = "SELECT t.id, t.amount, t.date, t.diseases, t.doctor, t.is_deleted, t.medicine," +
            " p.code as pigCode, pt.code as pigstyCode" +
            " FROM Treatment t JOIN pig p ON t.pig_id = p.id" +
            " JOIN pigsty pt ON p.pigsty_id = pt.id " +
            "where t.is_deleted = 0 and pt.code like :keySearch", nativeQuery = true)
    Page<ITreatmentDto> getAllTreatment(Pageable pageable,@Param("keySearch")  String keySearch);

    /**
     * Create by ThuanT
     * Date create: 08/09/2022
     * write query for method delete By Id Treatment
     * @param id
     * @return
     */
    @Modifying
    @Transactional
    @Query(value = "update Treatment t set t.is_deleted = 1 where t.id = :id",nativeQuery = true)
    void deleteByIdTreatment(@Param("id") int id);
    @Query(value = "select * from Treatment t where t.id = :id and t.is_deleted = 0",nativeQuery = true)
    Treatment findByIdTreatment(@Param("id") int id);
}
