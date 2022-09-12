package vn.codegym.pig_farm.service;

import vn.codegym.pig_farm.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    /**
     * @return List Employee
     * @creator LongNT
     * @day 12/09/2022
     */

    List<Employee> findAll();

    /**
     * @param employee
     * @creator LongNT
     * @day 12/09/2022
     */

    void save(Employee employee);

    /**
     * @param id
     * @return Employee
     * @creator LongNT
     * @day 12/09/2022
     */

    Optional<Employee> findById(Integer id);

    /**
     * @param employee
     * @creator LongNT
     * @day 12/09/2022
     */

    void edit(Employee employee);
}
