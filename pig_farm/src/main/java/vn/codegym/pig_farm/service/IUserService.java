package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.AppUser;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<AppUser> findAll();

    void save(AppUser user);

    Optional<AppUser> findById(Integer id);

    void edit(AppUser user);
}
