package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> findAll();

    void save(Employee employee);

    Optional<Employee> findById(Integer id);

    void edit(Employee employee);
}
