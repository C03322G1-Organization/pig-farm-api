package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.codegym.pig_farm.entity.UserRole;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IUserRoleRepository extends JpaRepository<UserRole, Integer> {

    /**
     * @return list UserRole
     * @creator LongNT
     * @day 12/09/2022
     */

    @Query(value = "select * from user_role", nativeQuery = true)
    List<UserRole> findAll();

    /**
     * @param roleId
     * @param userId
     * @creator LongNT
     * @day 12/09/2022
     */

    @Modifying
    @Query(value = "insert into user_role (is_deleted, role_id, user_id) values (0, :roleId, :userId)", nativeQuery = true)
    void save(@Param("roleId") Integer roleId, @Param("userId") Integer userId);
}
