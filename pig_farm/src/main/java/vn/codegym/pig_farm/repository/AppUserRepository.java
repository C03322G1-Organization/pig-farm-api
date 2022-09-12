package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.codegym.pig_farm.entity.AppUser;

import javax.transaction.Transactional;

@Transactional
public interface AppUserRepository extends JpaRepository<AppUser, Integer> {

    /**
     * Create by SangNH
     * Date: 08/09/2022
     * query: search by name
     * @param name
     */
    @Query(value = "select * from app_user a where a.name = :name", nativeQuery = true)
    AppUser findAppUserByName(@Param("name") String name);

    @Query(value = "SELECT `name` from app_user where `name` = ?1", nativeQuery = true)
    String existsByUserName(String username);
}
