package vn.codegym.pig_farm.repository;

import  org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.Pigsty;

public interface PigstyRepository extends JpaRepository<Pigsty, Integer> {
    /**
     * Create by PhucND
     * Date Create: 08/09/2022
     * This findAll
     *
     * Param search,pageable
     */
    @Query(value = "select * from pigsty left join employee on employee.id = pigsty.employee_id " +
            "where employee.name like :search or pigsty.code like:search", nativeQuery = true)
    Page<Pigsty> findAll(Pageable pageable, @Param("search") String search);
}
