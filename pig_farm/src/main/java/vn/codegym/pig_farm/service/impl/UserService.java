package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.User;
import vn.codegym.pig_farm.repository.IUserRepository;
import vn.codegym.pig_farm.service.IUserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository userRepository;

    /**
     * @return List User (test list)
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * @param user
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public void save(User user) {
        userRepository.save(user.getUsername(), user.getPassword(), user.getEmail());
    }

    /**
     * @param id
     * @return Employee
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public Optional<User> findById(Integer id) {
        return userRepository.findById(id);
    }

    /**
     * @param user
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public void edit(User user) {
        userRepository.edit(user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
    }
}
