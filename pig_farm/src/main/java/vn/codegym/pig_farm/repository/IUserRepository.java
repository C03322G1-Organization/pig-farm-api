package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Integer> {

    /**
     * @return list User
     * @creator LongNT
     * @day 12/09/2022
     */

    @Query(value = "select * from user", nativeQuery = true)
    List<User> findAll();

    /**
     * @param username
     * @param password
     * @param email
     * @return save new User
     * @creator LongNT
     * @day 12/09/2022
     */

    @Modifying
    @Query(value = "insert into `user` (username, `password`, email, creation_date, is_deleted) values (:username, :password, :email, current_date(), 0)", nativeQuery = true)
    void save(@Param("username") String username, @Param("password") String password, @Param("email") String email);

    /**
     * @param id must not be {@literal null}.
     * @return id of User
     * @creator LongNT
     * @day 12/09/2022
     */

    @Query(value = "select * from user where user.id = :id", nativeQuery = true)
    Optional<User> findById(@Param("id") Integer id);

    /**
     * @param username
     * @param password
     * @param email
     * @param id
     * @creator LongNT
     * @day 12/09/2022
     */

    @Modifying
    @Query(value = "update `user` set username = :username, `password` = :password, email = :email where id = :id", nativeQuery = true)
    void edit(@Param("username") String username, @Param("password") String password, @Param("email") String email, @Param("id") Integer id);

}
