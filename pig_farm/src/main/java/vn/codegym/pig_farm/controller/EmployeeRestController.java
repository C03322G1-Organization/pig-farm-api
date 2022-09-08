package vn.codegym.pig_farm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.entity.User;
import vn.codegym.pig_farm.service.IEmployeeService;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    IEmployeeService employeeService;

    /**
     * @param employee
     * @return create Employee
     * @creator LongNT
     * @day 08/09/2022
     */

    @PostMapping("")
    public ResponseEntity<Employee> save(@RequestBody Employee employee, @RequestBody User user) {
        employeeService.save(employee, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * @param id
     * @return Employee ID
     * @creator LongNT
     * @day 08/09/2022
     */

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> findById(@PathVariable Integer id) {
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    /**
     * @param id,
     * @param employee
     * @return Employee edited
     * @creator LongNT
     * @day 08/09/2022
     */

    @PutMapping("/{id}")
    public ResponseEntity<Employee> edit(@PathVariable Integer id, @RequestBody Employee employee, @RequestBody User user) {
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        employeeService.edit(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
