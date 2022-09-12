package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.Role;
import vn.codegym.pig_farm.entity.User;
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
//        User user = new User();
//        user.setUsername(user.getUsername());
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        user.setEmail(user.getEmail());

        List<User> users = userRepository.findAll();
        UserRole userRole = new UserRole();
        Role role = new Role();
        role.setId(1);
        userRole.setIsDeleted(false);
        userRole.setUser(users.get(users.toArray().length - 1));
        userRole.setRole(role);
        userRoleRepository.save(userRole);

        employee.setUser(employee.getUser());
        employeeRepository.save(employee.getCode(), employee.getName(), employee.getBirthDay(), employee.getGender(), employee.getIdCard(), employee.getImage(), users.toArray().length);
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
