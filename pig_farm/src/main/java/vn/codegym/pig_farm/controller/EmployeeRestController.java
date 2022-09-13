package vn.codegym.pig_farm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.dto.projection.EmployeeDto;
import vn.codegym.pig_farm.service.IEmployeeService;
import vn.codegym.pig_farm.service.IUserRoleService;
import vn.codegym.pig_farm.service.IUserService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {
    
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private IUserRoleService iUserRoleService;

    @Autowired
    private IUserService iUserService;

    /**
     * @Creator HungNQ
     * @Date 08/09/2022
     * @param pageable
     * @param name
     * @param idCard
     * @return if success status 2xx else if error status 4xx
     */
    @GetMapping("/searchList")
    public ResponseEntity<Page<EmployeeDto>> getAllListEmployeePaginationAndSearch(@PageableDefault(value = 6) Pageable pageable,
                                                                                   @RequestParam Optional<String> name,
                                                                                   @RequestParam Optional<String> idCard) {
        String keywordIdCard = idCard.orElse("");
        String keywordName = name.orElse("");

        Page<EmployeeDto> employeePage = iEmployeeService.getAllEmployeePaginationAndSearch(keywordName,keywordIdCard, pageable);
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
        List<Employee> employeeList = iEmployeeService.getAllEmployee();
        for (Employee employee: employeeList) {
            if(Objects.equals(id, employee.getId())){

                iEmployeeService.deleteEmployee(id);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    /**
     * @Creator HungNQ
     * @Date 12/09/2022
     * @param id
     * @return EmployeeDto
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeDtoById(@PathVariable Integer id){
        Optional<EmployeeDto> employeeDtoOptional = iEmployeeService.getEmployeeDtoById(id);
        if (!employeeDtoOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeDtoOptional.get(), HttpStatus.OK);
    }

    /**
     * @Creator HungNQ
     * @Date 13/09/2022
     * @return List employee
     */
    @GetMapping("/list")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(iEmployeeService.getAllEmployee(),HttpStatus.OK);
    }

}
