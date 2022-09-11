package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.projection.IEmployeeProjection;

import java.util.List;
import java.util.Optional;


public interface IEmployeeService {
    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param name
     * @param phoneNumber
     * @param pageable
     * @return Page employee
     */
    Page<IEmployeeProjection> getAllEmployeePaginationAndSearch(String name, String phoneNumber, Pageable pageable);

    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param id
     */
    void deleteEmployee(int id);

    /**
     * @Creator HungNQ
     * @Date 09/09/2022
     * return List employee
     */
    List<Employee> getAllEmployee();

    List<Employee> findAll();

    void save(Employee employee);

    Optional<Employee> findById(Integer id);

    void edit(Employee employee);
}
