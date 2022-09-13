package vn.codegym.pig_farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.dto.projections.EmployeeDto;
import vn.codegym.pig_farm.repository.EmployeeRepository;
import vn.codegym.pig_farm.service.IEmployeeService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    private IEmployeeService iEmployeeService;


    /**
     * @param pageable
     * @param name
     * @param idCard
     * @return if success status 2xx else if error status 4xx
     * @Creator HungNQ
     * @Date 08/09/2022
     */
    @GetMapping("/searchList")
    public ResponseEntity<Page<EmployeeDto>> getAllListEmployeePaginationAndSearch(@PageableDefault(value = 2) Pageable pageable,
                                                                                   @RequestParam Optional<String> name,
                                                                                   @RequestParam Optional<String> idCard) {
        String keywordIdCard = idCard.orElse("");
        String keywordName = name.orElse("");
        Page<EmployeeDto> employeePage = iEmployeeService.getAllEmployeePaginationAndSearch(keywordName, keywordIdCard, pageable);
        if (employeePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }


    /**
     * @param id
     * @return if success delete employee by id
     * @Creator HungNQ
     * @Date 08/09/2022
     */
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Integer id) {
        List<Employee> employeeList = iEmployeeService.getAllEmployee();
        for (Employee employee : employeeList) {
            if (Objects.equals(id, employee.getId())) {
                iEmployeeService.deleteEmployee(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllList() {
        List<Employee> employeeList = this.iEmployeeService.getAllEmployee();
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(employeeList, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }


}
