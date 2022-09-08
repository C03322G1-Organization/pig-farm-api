package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vn.codegym.pig_farm.entity.Pigsty;

@Repository

public interface IPigstyRepository extends JpaRepository<Pigsty, Integer> {
    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: create a Pigsty
     * @param pigsty
     */
    @Transactional
    @Modifying
    @Query(value="INSERT INTO `pigsty` (`id`,`build_date`, `creation_date`, `max_number`, `employee_id`) " +
            " VALUES (:#{#pigsty.id},:#{#pigsty.buildDate},:#{#pigsty.creationDate},:#{#pigsty.maxNumber}," +
            ":#{#pigsty.employee});",nativeQuery = true)
    void createPigsty(Pigsty pigsty);


}
