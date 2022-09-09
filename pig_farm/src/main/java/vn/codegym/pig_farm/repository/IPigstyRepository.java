package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.entity.Pigsty;

@Repository

public interface IPigstyRepository extends JpaRepository<Pigsty, Integer> {
    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: create a Pigsty
     *
     * @param pigsty
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `pigsty` (`id`,`build_date`, `creation_date`, `max_number`, `employee_id`) " +
            " VALUES (:#{#pigsty.id},:#{#pigsty.buildDate},:#{#pigsty.creationDate},:#{#pigsty.maxNumber}," +
            ":#{#pigsty.employee});", nativeQuery = true)
    void createPigsty(Pigsty pigsty);

    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: get a Pigsty by id with existing
     *
     * @param id
     * @return a pigsty
     */
    @Query(value = " select `id`, `build_date`, `creation_date`, `is_deleted`, `max_number`, `employee_id`" +
            " from pigsty p where `is_deleted`=0 and p.id=pigstyId ;", nativeQuery = true)
    Pigsty getPigstyById(@Param("pigstyId") Integer id);


    @Transactional
    @Modifying
    @Query(value ="update pig_farm.pigsty set `build_date`=:#{#pigsty.buildDate},`creation_date`=:#{#pigsty.creationDate}," +
            "`max_number`=:#{#pigsty.maxNumber} where `is_deleted`=0 and `id`=:#{#pigsty.id}",nativeQuery=true)
    void editPigsty(Pigsty pigsty);
}
