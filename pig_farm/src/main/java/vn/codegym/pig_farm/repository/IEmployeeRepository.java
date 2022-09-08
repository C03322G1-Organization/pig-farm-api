package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.Employee;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    @Modifying
    @Query(value = "insert into employee (`code`, `name`, birth_day, gender, id_card, image, user_id) " +
            "values (:code, :name, :birthDay, :gender, :idCard, :image, :userId);" +
            "insert into `user` (username, `password`, email, creation_date)" +
            "values (:username, :password, :email, current_date());", nativeQuery = true)
    void save(@Param("code") String code, @Param("name") String name, @Param("birthDay") LocalDate birthDay, @Param("gender") String gender, @Param("idCard") String idCard, @Param("image") String image, @Param("userId") Integer userId,
              @Param("username") String username, @Param("password") String password, @Param("email") String email);

    @Query(value = "select * from employee where id = :id", nativeQuery = true)
    Optional<Employee> findById(@Param("id") Integer id);

    @Modifying
    @Query(value = "update employee " +
            "set `name` = :name, birth_day = :birthDay, gender = :gender, id_card = :idCard, image = :image, is_deleted = 0, user_id = :userId " +
            "where id = :id;" +
            "update `user` " +
            "set username = :username, `password` = :password, email = :email, creation_date = :creationDate, is_deleted = 0 " +
            "where id = :idUser;", nativeQuery = true)
    void edit(@Param("name") String name, @Param("birthDay") LocalDate birthDay, @Param("gender") String gender, @Param("idCard") String idCard, @Param("image") String image, @Param("userId") Integer userId, @Param("id") Integer id,
              @Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("creationDate") LocalDate creationDate, @Param("idUser") Integer idUser);
}
