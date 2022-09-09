package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.User;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Optional;

@Repository
@Transactional
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "insert into employee (`code`, `name`, birth_day, gender, id_card, image, is_deleted, user_id) values (:code, :name, :birthDay, :gender, :idCard, :image, 0, :userId)", nativeQuery = true)
    void save(@Param("code") String code, @Param("name") String name, @Param("birthDay") LocalDate birthDay, @Param("gender") String gender, @Param("idCard") String idCard, @Param("image") String image, @Param("userId") User userId);

    @Query(value = "select * from employee where id = :id", nativeQuery = true)
    Optional<Employee> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update employee set `name` = :name, birth_day = :birthDay, gender = :gender, id_card = :idCard, image = :image where id = :id", nativeQuery = true)
    void edit(@Param("name") String name, @Param("birthDay") LocalDate birthDay, @Param("gender") String gender, @Param("idCard") String idCard, @Param("image") String image, @Param("id") Integer id);
}
