package vn.codegym.pig_farm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.dto.projections.PigstyDto;
import vn.codegym.pig_farm.entity.Pigsty;

import javax.transaction.Transactional;

public interface PigstyRepository extends JpaRepository<Pigsty, Integer> {
    /**
     * Create by PhucND
     * Date Create: 08/09/2022
     * This findAll
     * <p>
     * Param search,pageable
     */
    @Query(value = "select pigsty.id,pigsty.build_date as buildDate,pigsty.code,pigsty.creation_date as creationDate,pigsty.max_number as maxNumber,employee.code as employeeCode,employee.name as employeeName from pigsty left join employee on employee.id = pigsty.employee_id where employee.name like :search or pigsty.code like :search",countQuery = "select pigsty.id from pigsty left join employee on employee.id = pigsty.employee_id where employee.name like :search or pigsty.code like :search", nativeQuery = true)
    Page<PigstyDto>  findAll(Pageable pageable, @Param("search") String search);
    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: create a Pigsty
     *
     * @param pigsty
     */
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `pigsty` (`id`,`code`,`type_pigs`, `build_date`, `creation_date`, `max_number`, `employee_id`) " + " " +
            " VALUES (:#{#pigsty.id},:#{#pigsty.code},:#{#pigsty.typePigs},:#{#pigsty.buildDate},:#{#pigsty.creationDate},:#{#pigsty.maxNumber}," + ":#{#pigsty.employee});", nativeQuery = true)
    void createPigsty(Pigsty pigsty);

    /**
     * Created by: HieuCD
     * Date created: 08/09/2022
     * function: get a Pigsty by id with existing
     *
     * @param id
     * @return a pigsty
     */

    @Query(value = "  select `id`,`code`,`type_pigs`, `build_date`, `creation_date`, `max_number`, `employee_id`,`is_deleted`  " +
            " from pigsty p where p.employee_id=0 and p.id = :pigstyId ;", nativeQuery = true)
    Pigsty getPigstyById(@Param("pigstyId") Integer id);

    /**
     * Created by: HieuCD
     * Date created: 09/09/2022
     * function: update a Pigsty with condition existing
     *
     * @param pigsty
     */
    @Transactional
    @Modifying
    @Query(value = "update pigsty set `build_date`=:#{#pigsty.buildDate},`creation_date`=:#{#pigsty.creationDate}," + "`max_number`=:#{#pigsty.maxNumber} where `is_deleted`=0 and `id`=:#{#pigsty.id}", nativeQuery = true)
    void editPigsty(Pigsty pigsty);
}
