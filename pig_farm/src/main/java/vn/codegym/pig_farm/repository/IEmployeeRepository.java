package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Employee;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    /**
     * @return list employee (test)
     * @creator LongNT
     * @day 12/09/2022
     */

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> findAll();

    /**
     * @param code
     * @param name
     * @param birthDay
     * @param gender
     * @param idCard
     * @param image
     * @param userId
     * @creator LongNT
     * @day 12/09/2022
     */

    @Modifying
    @Query(value = "insert into employee (`code`, `name`, birth_day, gender, id_card, image, is_deleted, user_id) values (:code, :name, :birthDay, :gender, :idCard, :image, 0, :userId)", nativeQuery = true)
    void save(@Param("code") String code, @Param("name") String name, @Param("birthDay") LocalDate birthDay, @Param("gender") String gender, @Param("idCard") String idCard, @Param("image") String image, @Param("userId") Integer userId);

    /**
     * @param id must not be {@literal null}.
     * @return id of Employee
     * @creator LongNT
     * @day 12/09/2022
     */

    @Query(value = "select * from employee where id = :id", nativeQuery = true)
    Optional<Employee> findById(@Param("id") Integer id);

    /**
     * @param name
     * @param birthDay
     * @param gender
     * @param idCard
     * @param image
     * @param id
     * @creator LongNT
     * @day 12/09/2022
     */

    @Modifying
    @Query(value = "update employee set `name` = :name, birth_day = :birthDay, gender = :gender, id_card = :idCard, image = :image where id = :id", nativeQuery = true)
    void edit(@Param("name") String name, @Param("birthDay") LocalDate birthDay, @Param("gender") String gender, @Param("idCard") String idCard, @Param("image") String image, @Param("id") Integer id);
}
