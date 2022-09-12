package vn.codegym.pig_farm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.pig_farm.entity.AppUser;
import vn.codegym.pig_farm.entity.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    List<UserRole> findAllByAppUser(AppUser appUser);
}
