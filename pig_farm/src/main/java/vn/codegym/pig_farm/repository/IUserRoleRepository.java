package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.UserRole;

import javax.transaction.Transactional;

public interface IUserRoleRepository extends JpaRepository<UserRole,Integer> {


    /**
     * @param id function deleteUserRole
     * @Creator HungNQ
     * @Date 12/09/2022
     */
    @Transactional
    @Modifying
    @Query(value = "delete from user_role where user_id= :id",nativeQuery = true)
    void deleteUserRole(@Param("id") int id);
}
