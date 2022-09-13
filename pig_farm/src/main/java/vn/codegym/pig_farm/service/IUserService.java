package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    /**
     * @return list User (test list)
     * @creator LongNT
     * @day 12/09/2022
     */

    List<AppUser> findAll();

    /**
     * @param appUser
     * @creator LongNT
     * @day 12/09/2022
     */

    void save(AppUser appUser);

    /**
     * @param id
     * @return User
     * @creator LongNT
     * @day 12/09/2022
     */

    Optional<AppUser> findById(Integer id);

    /**
     * @param appUser
     * @creator LongNT
     * @day 12/09/2022
     */
    void edit(AppUser appUser);

    void deleteUser(int id);

}
