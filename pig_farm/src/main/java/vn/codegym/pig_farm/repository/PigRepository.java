package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.entity.Pig;
import vn.codegym.pig_farm.entity.Pigsty;

import java.time.LocalDate;
import java.util.List;
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


    @Query(value = "select * from Pig where is_deleted = 0", nativeQuery = true)
    List<Pig> findAll();

    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: createPig
     */
    @Modifying
    @Query(value = "insert into pig (code, date_in, date_out,status,weight,pigsty_id, is_deleted)" +
            " values (:code, :dateIn, :dateOut, :status, :weight,:pigsty, 0)", nativeQuery = true)
    void createPig(@Param("code") String code, @Param("dateIn") LocalDate dateIn,
                   @Param("dateOut") LocalDate dateOut, @Param("status") String status,
                   @Param("weight") String weight, @Param("pigsty") Integer pigsty);

    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: countPigOnPigsty
     */
    @Query(value = "select count(pig.pigsty_id) from pig join pigsty on pig.pigsty_id = pigsty.id where pigsty.id =:id", nativeQuery = true)
    Integer countPigOnPigsty(@Param("id") int id);

    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: findByIdPig
     */
    @Query(value = "select * from pig where id=:id", nativeQuery = true)
    Pig findByIdPig(@Param("id") Integer id);

    /**
     * Created by: DatVT
     * Date created: 08/09/2022
     * Function: updatePig
     */
    @Modifying
    @Query(value = "update pig set " +
            "code=:code, " +
            " date_in=:dateIn, " +
            "date_out=:dateOut, " +
            "status=:status," +
            "weight=:weight," +
            "pigsty_id=:pigsty " +
            "where id=:id", nativeQuery = true)
    void updatePig(@Param("code") String code, @Param("dateIn") LocalDate dateIn,
                   @Param("dateOut") LocalDate dateOut, @Param("status") String status,
                   @Param("weight") String weight, @Param("pigsty") Pigsty pigsty,
                   @Param("id") Integer id);
}

