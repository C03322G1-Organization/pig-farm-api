package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.User;

import javax.transaction.Transactional;

public interface IUserRepository extends JpaRepository<User,Integer> {

    /**
     * @param id function deleteUser
     * @Creator HungNQ
     * @Date 12/09/2022
     */
    @Transactional
    @Modifying
    @Query(value = "update `user` set is_deleted = 1 where id = :id", nativeQuery = true)
    void deleteUser(@Param("id") int id);
}
