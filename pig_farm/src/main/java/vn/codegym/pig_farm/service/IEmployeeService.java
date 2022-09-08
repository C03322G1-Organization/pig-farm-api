package vn.codegym.pig_farm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.pig_farm.entity.Employee;


public interface IEmployeeService {
    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param name
     * @param phoneNumber
     * @param pageable
     * @return Page employee
     */
    Page<Employee> getAllEmployeePaginationAndSearch(String name, String phoneNumber, Pageable pageable);

    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param id
     */
    void deleteEmployee(int id);

}
