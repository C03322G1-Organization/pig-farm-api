package vn.codegym.pig_farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.service.IEmployeeService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {


    @Autowired
    private IEmployeeService iEmployeeService;

    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param pageable
     * @param name
     * @param idCard
     * @return if success status 2xx else if error status 4xx
     */
    @GetMapping("/searchList")
    public ResponseEntity<Page<Employee>> getAllListEmployeePaginationAndSearch(@PageableDefault(value = 2) Pageable pageable,
                                              @RequestParam Optional<String> name,
                                              @RequestParam Optional<String> idCard) {
        String keywordIdCard = idCard.orElse("");
        String keywordName = name.orElse("");
        Page<Employee> employeePage = iEmployeeService.getAllEmployeePaginationAndSearch(keywordName,keywordIdCard, pageable);
        if (employeePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(employeePage, HttpStatus.OK);
    }

    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param id
     * @return if success delete employee by id
     */
    @PatchMapping("/delete/{id}")
    public ResponseEntity<Employee> deleteEmployeeById(@PathVariable Integer id){
        iEmployeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
