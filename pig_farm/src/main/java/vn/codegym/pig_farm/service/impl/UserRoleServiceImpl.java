package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.repository.IUserRoleRepository;
import vn.codegym.pig_farm.service.IUserRoleService;

@Service
public class UserRoleServiceImpl implements IUserRoleService {

    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public void deleteUserRole(int id) {
        iUserRoleRepository.deleteUserRole(id);
    }
}
