package vn.codegym.pig_farm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.repository.IEmployeeRepository;
import vn.codegym.pig_farm.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param name
     * @param idCard
     * @param pageable
     * @return Page<Employee>
     */
    @Override
    public Page<Employee> getAllEmployeePaginationAndSearch(String name, String idCard,Pageable pageable) {
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
}
