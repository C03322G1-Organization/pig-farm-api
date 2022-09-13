package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.dto.projections.EmployeeDto;
import vn.codegym.pig_farm.repository.EmployeeRepository;
import vn.codegym.pig_farm.service.IEmployeeService;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository iEmployeeRepository;

    @Override
    public List<Employee> findAll() {
        return iEmployeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        iEmployeeRepository.save(employee.getCode(), employee.getName(), employee.getBirthDay(), employee.getGender(), employee.getIdCard(), employee.getImage(), employee.getUser());
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return iEmployeeRepository.findById(id);
    }

    @Override
    public void edit(Employee employee) {
        iEmployeeRepository.edit(employee.getName(), employee.getBirthDay(), employee.getGender(), employee.getIdCard(), employee.getImage(), employee.getId());
    }


    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param name
     * @param idCard
     * @param pageable
     * @return Page<Employee>
     */
    @Override
    public Page<EmployeeDto> getAllEmployeePaginationAndSearch(String name, String idCard, Pageable pageable) {
        return iEmployeeRepository.getAllEmployeePaginationAndSearch(name,idCard,pageable);
    }

    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param id
     */
    @Override
    public void deleteEmployee(int id) {
        iEmployeeRepository.deleteEmployee(id);
    }

    /**
     * @Creator HungNQ
     * @Date 09/09/2022
     * @return List employee
     */
    @Override
    public List<Employee> getAllEmployee() {
        return iEmployeeRepository.getAllEmployee();
    }
}
