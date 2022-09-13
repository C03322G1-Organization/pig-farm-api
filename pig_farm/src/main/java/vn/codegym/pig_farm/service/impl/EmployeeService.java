package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.AppRole;
import vn.codegym.pig_farm.entity.AppUser;
import vn.codegym.pig_farm.entity.UserRole;
import vn.codegym.pig_farm.repository.IEmployeeRepository;
import vn.codegym.pig_farm.repository.IUserRepository;
import vn.codegym.pig_farm.repository.IUserRoleRepository;
import vn.codegym.pig_farm.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Autowired
    IUserRepository userRepository;

    @Autowired
    IUserRoleRepository userRoleRepository;


//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }

//    private PasswordEncoder passwordEncoder;

    /**
     * @return list Employee (test list)
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    /**
     * @param employee
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public void save(Employee employee) {
        List<AppUser> appUsers = userRepository.findAll();
        UserRole userRole = new UserRole();
        AppRole appRole = new AppRole();
        appRole.setId(1);
        userRole.setIsDeleted(false);
        userRole.setAppUser(appUsers.get(appUsers.toArray().length - 1));
        userRole.setAppRole(appRole);
        userRoleRepository.save(userRole);

        employee.setAppUser(employee.getAppUser());
        employeeRepository.save(employee.getCode(), employee.getName(), employee.getBirthDay(), employee.getGender(), employee.getIdCard(), employee.getImage(), appUsers.toArray().length);
    }

    /**
     * @param id
     * @return Employee
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    /**
     * @param employee
     * @creator LongNT
     * @day 12/09/2022
     */

    @Override
    public void edit(Employee employee) {

        employeeRepository.edit(employee.getName(), employee.getBirthDay(), employee.getGender(), employee.getIdCard(), employee.getImage(), employee.getId());
    }
}
