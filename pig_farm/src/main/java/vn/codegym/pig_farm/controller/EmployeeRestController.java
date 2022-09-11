package vn.codegym.pig_farm.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import vn.codegym.pig_farm.dto.EmployeeDto;
import vn.codegym.pig_farm.entity.Employee;
import vn.codegym.pig_farm.service.IEmployeeService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/employee")
public class EmployeeRestController {

    @Autowired
    IEmployeeService employeeService;

    @Autowired(required = false)
    private ModelMapper modelMapper;

    @GetMapping("")
    public ResponseEntity<List<Employee>> findAll() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    /**
     * @param employeeDto
     * @return create Employee
     * @creator LongNT
     * @day 08/09/2022
     */

    @PostMapping("")
    public ResponseEntity<List<FieldError>> save(@RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        Employee employeeObj = new Employee();

        BeanUtils.copyProperties(employeeDto, employeeObj);

        employeeService.save(employeeObj);

        return new ResponseEntity<>(HttpStatus.CREATED);
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
     * @param id
     * @param employeeDto
     * @return Employee edited
     * @creator LongNT
     * @day 08/09/2022
     */

    @PutMapping("/{id}")
    public ResponseEntity<List<FieldError>> edit(@PathVariable Integer id, @RequestBody @Valid EmployeeDto employeeDto, BindingResult bindingResult) {
        Optional<Employee> employeeObj = employeeService.findById(id);

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(bindingResult.getFieldErrors(), HttpStatus.NOT_ACCEPTABLE);
        }

        if (!employeeObj.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        employeeObj.get().setCode(employeeDto.getCode());

        employeeObj.get().setName(employeeDto.getName());

        employeeObj.get().setBirthDay(employeeDto.getBirthDay());

        employeeObj.get().setIdCard(employeeDto.getIdCard());

        employeeObj.get().setImage(employeeDto.getImage());

        employeeService.edit(employeeObj.get());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
