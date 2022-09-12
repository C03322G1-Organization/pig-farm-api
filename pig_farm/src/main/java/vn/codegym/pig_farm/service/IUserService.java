package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    /**
     * @return list User (test list)
     * @creator LongNT
     * @day 12/09/2022
     */

    List<User> findAll();

    /**
     * @param user
     * @creator LongNT
     * @day 12/09/2022
     */

    void save(User user);

    /**
     * @param id
     * @return User
     * @creator LongNT
     * @day 12/09/2022
     */

    Optional<User> findById(Integer id);

    /**
     * @param user
     * @creator LongNT
     * @day 12/09/2022
     */

    void edit(User user);
}
