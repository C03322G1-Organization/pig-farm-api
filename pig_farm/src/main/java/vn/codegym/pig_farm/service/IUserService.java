package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<User> findAll();

    void save(User user);

    Optional<User> findById(Integer id);

    void edit(User user);
}
