package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.User;
import vn.codegym.pig_farm.repository.IEmployeeRepository;
import vn.codegym.pig_farm.service.IEmployeeService;

import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public void save(Employee employee, User user) {
        employeeRepository.save(employee.getCode(),
                employee.getName(),
                employee.getBirthDay(),
                employee.getGender(),
                employee.getIdCard(),
                employee.getImage(),
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail());
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void edit(Employee employee) {
        employeeRepository.edit(employee.getName(), employee.getBirthDay(), employee.getGender(), employee.getIdCard(), employee.getImage(), employee.getUser().getId(), employee.getId(), employee.getUser().getUsername(), employee.getUser().getPassword(), employee.getUser().getEmail(), employee.getUser().getCreationDate(), employee.getUser().getId());
    }
}
