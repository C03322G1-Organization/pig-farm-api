package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.User;

import java.util.Optional;

public interface IUserService {

    void save(User user);

    Optional<User> findById(Integer id);

    void edit(User user);
}
