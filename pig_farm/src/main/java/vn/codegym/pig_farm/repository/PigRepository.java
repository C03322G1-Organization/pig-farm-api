package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.entity.Pig;

import java.util.Optional;

public interface PigRepository extends JpaRepository<Pig, Integer> {

    /**
     * @param pageable
     * @param code
     * @param dateIn
     * @param status
     * @return pig, status 200
     * @function (Query to display all Pig and search)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @Query(value = " select * from pig where code like :code and date_in like :dateIn and status like :status ", nativeQuery = true,
            countQuery = " select count(*) from (select * from pig where code like :code and date_in like :dateIn and status like :status) temp_table ")
    Page<Pig> findAllPig(Pageable pageable, @Param("code") String code, @Param("dateIn") String dateIn, @Param("status") String status);

    /**
     *
     * @param id
     * @return pig, status 200
     * @function (find Pig by Id)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @Query(value = "select * from pig where id = :id", nativeQuery = true)
    Optional<Pig> findByIdPig(@Param("id") int id);


    /**
     *
     * @param id
     * @return pig, status 200
     * @function (delete Pig)
     * @creator LamNT
     * @date-create 08/09/2022
     */

    @Transactional
    @Modifying
    @Query(value = " update pig p set is_deleted = 1 where  p.id =:id and p.is_deleted = 0", nativeQuery = true)
    void deletePigById(@Param("id") Integer id);

}

