package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.repository.IUserRepository;
import vn.codegym.pig_farm.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public void deleteUser(int id) {
        iUserRepository.deleteUser(id);
    }
}
