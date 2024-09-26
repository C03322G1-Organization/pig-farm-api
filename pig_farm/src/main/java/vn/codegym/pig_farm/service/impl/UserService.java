package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.AppUser;
import vn.codegym.pig_farm.repository.UserRepository;
import vn.codegym.pig_farm.service.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    /**
     * @return List User (test list)
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }


    /**
     * @param appUser
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public void save(AppUser appUser) {
        userRepository.save(appUser.getUsername(), appUser.getPassword(), appUser.getEmail());
    }

    /**
     * @param id
     * @return Employee
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public Optional<AppUser> findById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * @param appUser
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public void edit(AppUser appUser) {
        userRepository.edit(appUser.getUsername(), appUser.getPassword(), appUser.getEmail(), appUser.getId());
    }

    @Override
    public void deleteUser(int id) {
        userRepository.deleteUser(id);
    }
}
