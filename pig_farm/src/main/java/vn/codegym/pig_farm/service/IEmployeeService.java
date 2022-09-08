package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.User;

import java.util.Optional;

public interface IEmployeeService {

    void save(Employee employee, User user);

    Optional<Employee> findById(Integer id);

    void edit(Employee employee);
}
