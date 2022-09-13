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

    @Override
    public List<AppUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(AppUser user) {
        userRepository.save(user.getUsername(), user.getPassword(), user.getEmail());
    }

    @Override
    public Optional<AppUser> findById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public void edit(AppUser user) {
        userRepository.edit(user.getUsername(), user.getPassword(), user.getEmail(), user.getId());
    }
}
